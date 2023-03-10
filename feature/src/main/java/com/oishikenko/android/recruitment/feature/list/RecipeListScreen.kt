package com.oishikenko.android.recruitment.feature.list

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.oishikenko.android.recruitment.feature.R

@OptIn(ExperimentalLayoutApi::class, ExperimentalLifecycleComposeApi::class)
@Composable
fun RecipeListScreen(
    viewModel: RecipeListViewModel = hiltViewModel(),
    onNavigateToDetail: (String, String, String, String) -> Unit = { _,_,_,_ -> }
) {
    val cookingRecords = viewModel.cookingRecords.collectAsLazyPagingItems()

    Scaffold { innerPadding ->
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = stringResource(id = R.string.cooking_records_title),
                    color = Color(0xFF333333),
                    fontSize = 20.sp,
                    fontWeight = FontWeight(700),
                    /* TODO: fontFamily('Noto Sans JP') */
                    modifier = Modifier
                        .height(29.dp)
                        .width(160.dp)
                )
                Spacer(
                    modifier = Modifier.size(4.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.header),
                    contentDescription = "header_image",
                    modifier = Modifier
                        .height(64.dp)
                        .width(66.72.dp)
                )
            }

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(innerPadding)
                    .consumedWindowInsets(innerPadding)
            ) {
                items(cookingRecords) { item ->
                    item?.let {
                        RecipeListItem(
                            cookingRecord = it,
                            onNavigateToDetail = onNavigateToDetail
                        )
                    }
                }

                when (cookingRecords.loadState.append) {
                    is LoadState.NotLoading -> Unit
                    is LoadState.Loading -> {
                        item {
                            LoadingItem()
                        }
                    }
                    is LoadState.Error -> {
                        item {

                        }
                    }
                    else -> {}
                }
            }
        }
    }
}

@Composable
fun LoadingItem() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        contentAlignment = Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .width(42.dp)
                .height(42.dp)
                .padding(8.dp),
            strokeWidth = 5.dp
        )
    }
}

@Preview
@Composable
fun PreviewRecipeListScreen(){
    MaterialTheme {
        RecipeListScreen()
    }
}