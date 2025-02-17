package com.example.states

import com.example.states.ui.theme.StatesTheme
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick

import org.junit.Rule
import org.junit.Test

class InstrumentedTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun press_previous_button() {
        composeTestRule.setContent {
            StatesTheme {
                TeamsLayout()
            }
        }
        composeTestRule.onNodeWithText("Granada Club de Fútbol")
            .assertExists("initial state was not set properly")
        composeTestRule.onNodeWithText("Previous")
            .performClick()
        composeTestRule.onNodeWithText("Club Recreativo Granada")
            .assertExists("previous state was not set properly")
        composeTestRule.onNodeWithText("Next")
            .performClick()
        composeTestRule.onNodeWithText("Granada Club de Fútbol")
            .assertExists("next state was not set properly")
    }
}