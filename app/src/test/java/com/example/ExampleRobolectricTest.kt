package com.example

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.example.model.ExperienceLevel
import com.example.viewmodel.JobRecommendationViewModel
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [36])
class ExampleRobolectricTest {

  @Test
  fun `read string from context`() {
    val context = ApplicationProvider.getApplicationContext<Context>()
    val appName = context.getString(R.string.app_name)
    assertEquals("Job Recommendation", appName)
  }

  @Test
  fun `test recommendation scoring for Frontend Developer`() {
    val viewModel = JobRecommendationViewModel()
    viewModel.toggleSkill("HTML")
    viewModel.toggleSkill("CSS")
    viewModel.toggleSkill("JavaScript")
    viewModel.toggleSkill("React")
    viewModel.selectExperience(ExperienceLevel.FRESHER)

    viewModel.getRecommendations()

    val results = viewModel.uiState.value.recommendations
    assertNotNull(results)
    assertTrue(results!!.isNotEmpty())
    val topResult = results.first()
    assertEquals("Frontend Developer", topResult.job.title)
    assertEquals(100, topResult.matchPercent)
    assertTrue(topResult.isLevelMatch)
  }
}
