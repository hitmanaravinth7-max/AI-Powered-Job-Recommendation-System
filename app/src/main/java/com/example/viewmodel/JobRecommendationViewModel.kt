package com.example.viewmodel

import androidx.lifecycle.ViewModel
import com.example.data.JobRepository
import com.example.model.ExperienceLevel
import com.example.model.Job
import com.example.model.JobRecommendation
import com.example.model.SkillCategory
import com.example.model.SkillItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class UiState(
    val selectedSkills: Set<String> = emptySet(),
    val selectedExperience: ExperienceLevel = ExperienceLevel.FRESHER,
    val selectedCategory: SkillCategory = SkillCategory.ALL,
    val skillSearchQuery: String = "",
    val recommendations: List<JobRecommendation>? = null,
    val hasCalculated: Boolean = false,
    val errorMessage: String? = null,
    val bookmarkedJobIds: Set<String> = emptySet(),
    val selectedJobForDetails: Job? = null
)

class JobRecommendationViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    val allSkills: List<SkillItem> = JobRepository.availableSkills

    fun toggleSkill(skillName: String) {
        _uiState.update { current ->
            val updated = if (current.selectedSkills.contains(skillName)) {
                current.selectedSkills - skillName
            } else {
                current.selectedSkills + skillName
            }
            current.copy(
                selectedSkills = updated,
                errorMessage = if (updated.isNotEmpty()) null else current.errorMessage
            )
        }
    }

    fun selectExperience(level: ExperienceLevel) {
        _uiState.update { it.copy(selectedExperience = level) }
    }

    fun selectCategory(category: SkillCategory) {
        _uiState.update { it.copy(selectedCategory = category) }
    }

    fun updateSearchQuery(query: String) {
        _uiState.update { it.copy(skillSearchQuery = query) }
    }

    fun clearAllSkills() {
        _uiState.update {
            it.copy(
                selectedSkills = emptySet(),
                recommendations = null,
                hasCalculated = false,
                errorMessage = null
            )
        }
    }

    fun selectPresetWebDev() {
        val webSkills = setOf("HTML", "CSS", "JavaScript", "React")
        _uiState.update { it.copy(selectedSkills = webSkills, errorMessage = null) }
    }

    fun selectPresetDataAnalyst() {
        val dataSkills = setOf("SQL", "Excel", "Data Analysis", "Python")
        _uiState.update { it.copy(selectedSkills = dataSkills, errorMessage = null) }
    }

    fun getRecommendations() {
        val state = _uiState.value
        if (state.selectedSkills.isEmpty()) {
            _uiState.update {
                it.copy(
                    errorMessage = "Please select at least one skill.",
                    recommendations = emptyList(),
                    hasCalculated = true
                )
            }
            return
        }

        val currentSkills = state.selectedSkills
        val currentExp = state.selectedExperience

        val scored = JobRepository.jobDatabase.mapNotNull { job ->
            val matched = job.skills.filter { currentSkills.contains(it) }
            val missing = job.skills.filter { !currentSkills.contains(it) }
            val matchCount = matched.size

            if (matchCount == 0) {
                null
            } else {
                val levelMatch = job.levels.contains(currentExp)
                val levelScore = if (levelMatch) 1 else 0
                val score = matchCount * 2 + levelScore
                val percent = Math.round((matchCount.toDouble() / job.skills.size) * 100).toInt()

                JobRecommendation(
                    job = job,
                    matchedSkills = matched,
                    missingSkills = missing,
                    matchPercent = percent,
                    isLevelMatch = levelMatch,
                    totalScore = score
                )
            }
        }.sortedByDescending { it.totalScore }

        _uiState.update {
            it.copy(
                recommendations = scored,
                hasCalculated = true,
                errorMessage = null
            )
        }
    }

    fun toggleBookmark(jobId: String) {
        _uiState.update { current ->
            val updatedBookmarks = if (current.bookmarkedJobIds.contains(jobId)) {
                current.bookmarkedJobIds - jobId
            } else {
                current.bookmarkedJobIds + jobId
            }
            current.copy(bookmarkedJobIds = updatedBookmarks)
        }
    }

    fun showJobDetails(job: Job) {
        _uiState.update { it.copy(selectedJobForDetails = job) }
    }

    fun dismissJobDetails() {
        _uiState.update { it.copy(selectedJobForDetails = null) }
    }

    fun dismissErrorMessage() {
        _uiState.update { it.copy(errorMessage = null) }
    }
}
