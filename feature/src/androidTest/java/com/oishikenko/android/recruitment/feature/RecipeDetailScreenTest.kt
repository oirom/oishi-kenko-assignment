package com.oishikenko.android.recruitment.feature

import androidx.compose.material.MaterialTheme
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import com.oishikenko.android.recruitment.feature.list.RecipeDetailScreen
import org.junit.Rule
import org.junit.Test

class RecipeDetailScreenTest {

    @get:Rule
    val rule = createComposeRule()

    @Test
    fun soupRecipeDetailScreen() {
        val comment = "This is soup."
        val recipeType = "soup"
        val recordedAt = "2023/2/7 17:00"

        rule.setContent {
            MaterialTheme {
                RecipeDetailScreen(
                    onNavigateToList = {},
                    comment = comment,
                    imageUrl = "",
                    recipeType = recipeType,
                    recordedAt = recordedAt
                )
            }
        }
        rule.onNodeWithText(comment).assertIsDisplayed()
        rule.onNodeWithTag("recipeTypeImage").assertIsDisplayed()
        rule.onNodeWithText(recordedAt).assertIsDisplayed()
    }

    @Test
    fun mainDishRecipeDetailScreen() {
        val comment = "This is main dish."
        val recipeType = "main_dish"
        val recordedAt = "2023/2/7 17:00"

        rule.setContent {
            MaterialTheme {
                RecipeDetailScreen(
                    onNavigateToList = {},
                    comment = comment,
                    imageUrl = "",
                    recipeType = recipeType,
                    recordedAt = recordedAt
                )
            }
        }
        rule.onNodeWithText(comment).assertIsDisplayed()
        rule.onNodeWithTag("recipeTypeImage").assertIsDisplayed()
        rule.onNodeWithText(recordedAt).assertIsDisplayed()
    }

    @Test
    fun sideDishRecipeDetailScreen() {
        val comment = "This is side dish."
        val recipeType = "side_dish"
        val recordedAt = "2023/2/7 17:00"

        rule.setContent {
            MaterialTheme {
                RecipeDetailScreen(
                    onNavigateToList = {},
                    comment = comment,
                    imageUrl = "",
                    recipeType = recipeType,
                    recordedAt = recordedAt
                )
            }
        }
        rule.onNodeWithText(comment).assertIsDisplayed()
        rule.onNodeWithTag("recipeTypeImage").assertIsDisplayed()
        rule.onNodeWithText(recordedAt).assertIsDisplayed()
    }
}