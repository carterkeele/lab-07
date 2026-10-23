package com.example.lab_07

import androidx.compose.ui.test.junit4.v2.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FormulaZeroTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>() // access MainActivity

    @Test
    fun navigate_to_races_add_race_and_return_home() {
        // navigate to race screen
        composeTestRule
            .onNodeWithTag("raceButton")
            .performClick()

        // verify race screen
        composeTestRule
            .onNodeWithText("Upcoming Races")
            .assertExists()

        // enter race location
        composeTestRule
            .onNodeWithTag("locationInput")
            .performTextInput("Canada")

        // add race location
        composeTestRule
            .onNodeWithTag("addRaceButton")
            .performClick()

        // verify race appears
        composeTestRule
            .onNodeWithText("Canada")
            .assertExists()

        // return to home screen
        composeTestRule
            .onNodeWithTag("backButton")
            .performClick()

        // verify return to home screen
        composeTestRule
            .onNodeWithText("FormulaZero Home")
            .assertExists()
    }

    @Test
    fun navigate_from_home_to_drivers() {
        composeTestRule.onNodeWithTag("driversButton").performClick()

        composeTestRule.onNodeWithText("FormulaZero Drivers").assertExists()
    }

    @Test
    fun add_driver_displays_in_list() {
        composeTestRule.onNodeWithTag("driversButton").performClick()

        composeTestRule.onNodeWithTag("driverInput").performTextInput("Hamilton")
        composeTestRule.onNodeWithTag("addDriverButton").performClick()

        composeTestRule.onNodeWithText("Hamilton").assertExists()
    }

    @Test
    fun clear_drivers_removes_them_from_list() {
        composeTestRule.onNodeWithTag("driversButton").performClick()

        composeTestRule.onNodeWithTag("driverInput").performTextInput("Hamilton")
        composeTestRule.onNodeWithTag("addDriverButton").performClick()
        composeTestRule.onNodeWithText("Hamilton").assertExists()

        composeTestRule.onNodeWithTag("clearDriversButton").performClick()

        composeTestRule.onNodeWithText("Hamilton").assertDoesNotExist()
    }

    @Test
    fun drivers_back_button_returns_home() {
        composeTestRule.onNodeWithTag("driversButton").performClick()
        composeTestRule.onNodeWithText("FormulaZero Drivers").assertExists()

        composeTestRule.onNodeWithTag("driversBackButton").performClick()

        composeTestRule.onNodeWithText("FormulaZero Home").assertExists()
    }
}