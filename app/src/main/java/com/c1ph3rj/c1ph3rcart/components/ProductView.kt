package com.c1ph3rj.c1ph3rcart.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material.icons.outlined.StarHalf
import androidx.compose.material.icons.outlined.StarOutline
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.c1ph3rj.c1ph3rcart.model.ProductModel
import com.c1ph3rj.c1ph3rcart.ui.theme.appColor2
import com.c1ph3rj.c1ph3rcart.ui.theme.appColor3
import kotlin.math.ceil
import kotlin.math.floor

@Composable
fun ProductView(currentProduct: ProductModel){
    val titleLineCount = remember {
        mutableStateOf(0)
    }
    Box (modifier = Modifier.padding(8.dp)){
        Card (
            elevation = 8.dp,
            backgroundColor = Color.White,
            shape = RoundedCornerShape(8.dp)
                ) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .padding(8.dp)){
                AsyncImage(
                    modifier = Modifier.weight(1f),
                    model = currentProduct.thumbnail,
                    contentScale = ContentScale.Crop,
                    contentDescription = currentProduct.description
                )
                Column (
                    modifier = Modifier
                        .weight(2f)
                        .padding(4.dp)){
                    Text(
                        text = currentProduct.title,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        onTextLayout = {
                            textLayoutResult ->
                            titleLineCount.value = textLayoutResult.lineCount
                        }
                    )
                    Text(
                        text = currentProduct.description,
                        maxLines = if(titleLineCount.value <= 1) 3 else if(titleLineCount.value == 2) 2 else 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Row (modifier = Modifier.padding(vertical = 4.dp)) {
                        RatingBar(rating = currentProduct.rating)
                        Text(text = "(${currentProduct.rating})", fontWeight = FontWeight.Light)
                    }
                    Row {
                        Text(text = convertDollarToINR(currentProduct.price),
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(2f),
                            fontWeight = FontWeight.Bold)
                        Text(text = "${currentProduct.discountPercentage.toInt()}% OFF", color = appColor3, modifier = Modifier.weight(1f), textAlign = TextAlign.End, fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
}

fun convertDollarToINR(dollars: Long): String {
    val exchangeRate = 74.90 // This is the current exchange rate as of 2023-06-01
    val inr = dollars * exchangeRate
    return String.format("₹ ${inr.toInt()}")
}

@Composable
fun RatingBar(
    modifier: Modifier = Modifier,
    rating: Double = 0.0,
    stars: Int = 5,
    starsColor: Color = appColor2,
) {
    val filledStars = floor(rating).toInt()
    val unfilledStars = (stars - ceil(rating)).toInt()
    val halfStar = !(rating.rem(1).equals(0.0))
    Row(modifier = modifier) {
        repeat(unfilledStars) {
            Icon(
                imageVector = Icons.Outlined.StarOutline,
                contentDescription = null,
                tint = starsColor
            )
        }
        repeat(filledStars) {
            Icon(imageVector = Icons.Outlined.Star, contentDescription = null, tint = starsColor)
        }
        if (halfStar) {
            Icon(
                imageVector = Icons.Outlined.StarHalf,
                contentDescription = null,
                tint = starsColor
            )
        }
    }
}
