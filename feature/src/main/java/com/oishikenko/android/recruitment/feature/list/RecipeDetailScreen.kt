package com.oishikenko.android.recruitment.feature.list

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.oishikenko.android.recruitment.feature.R

@Composable
fun RecipeDetailScreen(
    onNavigateToList: () -> Unit,
    comment: String,
    imageUrl: String,
    recipeType: String,
    recordedAt: String
) {

    var drawableId = R.drawable.soup
    if (recipeType == "main_dish") drawableId = R.drawable.maindish
    if (recipeType == "side_dish") drawableId = R.drawable.sidedish

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
            Box(
                modifier = Modifier
                    .aspectRatio(1F)
                    .clip(
                        RectangleShape
                    )
                    .background(
                        Color.LightGray
                    )
            ) {
                AsyncImage(
                    model = imageUrl,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                )
                Image(
                    painter = painterResource(drawableId),
                    contentDescription = null,
                    modifier = Modifier
                        .align(
                            Alignment.BottomEnd
                        )
                        .padding(
                            horizontal = 8.dp,
                            vertical = 8.dp
                        )
                        .height(36.dp)
                        .width(98.dp)
                        .testTag("recipeTypeImage")
                )
            }
            Text(
                text = comment,
                fontSize = 20.sp,
                fontWeight = FontWeight(500),
                modifier = Modifier
                    .padding(
                        horizontal = 16.dp,
                        vertical = 8.dp
                    )
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    text = recordedAt,
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400),
                    modifier = Modifier.padding(end = 16.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewRecipeDetailScreen() {
    MaterialTheme {
        RecipeDetailScreen(
            onNavigateToList = {},
            comment = "comment",
            imageUrl = "https://cooking-records.ex.oishi-kenko.com/images/1.jpg",
            recipeType = "soup",
            recordedAt = "2023/2/3 17:00"
        )
    }
}