package com.oishikenko.android.recruitment.feature.list

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.oishikenko.android.recruitment.feature.R

@Composable
fun RecipeDetailScreen(
    onNavigateToList: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .height(56.dp),
                backgroundColor = Color.White,
                contentPadding = PaddingValues(0.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = 20.dp,
                        ),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Back",
                        modifier = Modifier
                            .clickable(
                                onClick = onNavigateToList
                            ),
                        tint = Color(0xFF333333)
                    )
                    Spacer(modifier = Modifier.size(20.dp))
                    Text(
                        text = stringResource(id = R.string.recipe_detail_title),
                        fontSize = 20.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF333333)
                    )
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding)
        ) {
            Text(text = "test")
        }
    }
}

@Preview
@Composable
fun PreviewRecipeDetailScreen() {
    MaterialTheme {
        RecipeDetailScreen(
            onNavigateToList = {}
        )
    }
}
