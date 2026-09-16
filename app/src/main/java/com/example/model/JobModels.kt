package com.example.model

enum class ExperienceLevel(val id: String, val label: String, val subtitle: String) {
    FRESHER("fresher", "Fresher", "0–1 years"),
    JUNIOR("junior", "Junior", "1–3 years"),
    MID("mid", "Mid-Level", "3–6 years"),
    SENIOR("senior", "Senior", "6+ years");

    companion object {
        fun fromId(id: String): ExperienceLevel = entries.firstOrNull { it.id == id } ?: FRESHER
    }
}

enum class SkillCategory(val label: String) {
    ALL("All Skills"),
    TECH("Tech & Dev"),
    DATA("Data & AI"),
    BUSINESS("Business & Creative")
}

data class SkillItem(
    val name: String,
    val category: SkillCategory
)

data class Job(
    val id: String,
    val title: String,
    val skills: List<String>,
    val levels: List<ExperienceLevel>,
    val description: String,
    val salaryRange: String,
    val keyResponsibilities: List<String>
)

data class JobRecommendation(
    val job: Job,
    val matchedSkills: List<String>,
    val missingSkills: List<String>,
    val matchPercent: Int,
    val isLevelMatch: Boolean,
    val totalScore: Int
)
