package com.oishikenko.android.recruitment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.oishikenko.android.recruitment.ui.theme.RecruitmentTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RecruitmentTheme {
                // RecipeListScreen()
                App()
            }
        }
    }
}

@Composable
fun App() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "profile") {
        composable("profile") { ProfileScreen(navController) }
        composable("friends") { FriendsScreen() }
    }
}

@Composable
fun ProfileScreen(navController: NavHostController) {
    Column {
        Text(text = "profile screen")
        Button(
            onClick = {
                navController.navigate("friends")
            }
        ) {
            Text(text = "go to friends")
        }
    }
}

@Composable
fun FriendsScreen() {
    Text(text = "friends screen")
}