package com.oishikenko.android.recruitment.feature.list

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.oishikenko.android.recruitment.data.model.CookingRecord
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun RecipeListItem(
    cookingRecord: CookingRecord,
    onNavigateToDetail: (String, String, String, String) -> Unit = { _,_,_,_ -> }
) {
    val displayRecipeType : Map<String, String> = mapOf(
        "soup" to "スープ",
        "main_dish" to "主菜/主食",
        "side_dish" to "副菜"
    )

    val simpleDateFormatWithHyphen = SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
    val date : Date = simpleDateFormatWithHyphen.parse(cookingRecord.recordedAt) as Date
    val simpleDateFormatWithSlash = SimpleDateFormat("yyyy/MM/dd hh:mm")
    val displayRecordedAt: String = simpleDateFormatWithSlash.format(date)

    Spacer(
        modifier = Modifier.size(8.dp)
    )
    Surface(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .padding(horizontal = 16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .border(
                    width = 1.dp,
                    color = Color(0xFFDCE0E0),
                    shape = RoundedCornerShape(8.dp),
                )
                .background(
                    color = Color(0xFFFFFFFF),
                )
                .clickable(
                    onClick = {
                        onNavigateToDetail(
                            cookingRecord.comment,
                            cookingRecord.imageUrl
                                .replace("/","%2F"),
                            cookingRecord.recipeType,
                            displayRecordedAt
                                .replace("/","%2F"),
                        )
                    }
                )
            ,
        ) {
            AsyncImage(
                model = cookingRecord.imageUrl,
                contentDescription = cookingRecord.comment,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(64.dp)
                    .clip(
                        shape = RoundedCornerShape(
                            topStart = 8.dp,
                            topEnd = 0.dp,
                            bottomStart = 8.dp,
                            bottomEnd = 0.dp
                        )
                    )
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 8.dp,
                        vertical = 12.dp,
                    )
            ) {
                Text(
                    text = displayRecipeType[cookingRecord.recipeType].toString(),
                    color = Color(0xFF333333),
                    fontSize = 14.sp, /* from Figma inspect *//* TODO: sp?? dp?? */
                    fontWeight = FontWeight(700), /* from Figma inspect */
                    /* TODO: fontFamily('Noto Sans JP') */
                )
                Text(
                    text = displayRecordedAt,
                    color = Color(0xFF676767),
                    fontSize = 14.sp, /* from Figma inspect *//* TODO: sp?? dp?? */
                    fontWeight = FontWeight(400), /* from Figma inspect */
                    /* TODO: fontFamily('Noto Sans JP') */
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewRecipeListItem() {
    RecipeListItem(
        cookingRecord = CookingRecord(
            imageUrl= "",
            comment = "豚肉のコクとごぼうの香り、野菜の甘みで奥行きのある味わい。",
            recipeType = "soup",
            recordedAt = "2018-05-01 17:57:31"
        )
    )
}