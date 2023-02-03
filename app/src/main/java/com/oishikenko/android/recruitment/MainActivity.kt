package com.oishikenko.android.recruitment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.oishikenko.android.recruitment.feature.list.RecipeDetailScreen
import com.oishikenko.android.recruitment.feature.list.RecipeListScreen
import com.oishikenko.android.recruitment.ui.theme.RecruitmentTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RecruitmentTheme {
                RecipeAppNavHost()
            }
        }
    }
}

@Composable
fun RecipeAppNavHost() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "recipeList") {
        composable("recipeList") {
            RecipeListScreen { comment, imageUrl, recipeType, recordedAt ->
                navController.navigate("recipeDetail/$comment/$imageUrl/$recipeType/$recordedAt")
            }
        }
        composable(
            route = "recipeDetail/{comment}/{imageUrl}/{recipeType}/{recordedAt}",
            arguments = listOf(
                navArgument("comment") { type = NavType.StringType },
                navArgument("imageUrl") { type = NavType.StringType },
                navArgument("recipeType") { type = NavType.StringType },
                navArgument("recordedAt") { type = NavType.StringType } )
        ) {  navBackStackEntry ->
            val comment = navBackStackEntry.arguments?.getString("comment") ?: ""
            val imageUrl = navBackStackEntry.arguments?.getString("imageUrl") ?: ""
            val recipeType = navBackStackEntry.arguments?.getString("recipeType") ?: ""
            val recordedAt = navBackStackEntry.arguments?.getString("recordedAt") ?: ""

            RecipeDetailScreen(
                onNavigateToList = { navController.popBackStack() },
                comment = comment,
                imageUrl = imageUrl,
                recipeType = recipeType,
                recordedAt = recordedAt
            )
        }
    }
}