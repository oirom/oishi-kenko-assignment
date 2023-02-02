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

    NavHost(navController, startDestination = "recipe_list") {
        composable("recipe_list") {
            RecipeListScreen(
                onNavigateToDetail = { navController.navigate("recipe_detail") }
            )
        }
        composable("recipe_detail") {
            RecipeDetailScreen(
                onNavigateToList = { navController.popBackStack() }
            )
        }
    }
}