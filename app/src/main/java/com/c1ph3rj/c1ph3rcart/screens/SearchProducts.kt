package com.c1ph3rj.c1ph3rcart.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.c1ph3rj.c1ph3rcart.ui.theme.appColor1

@Composable
fun SearchProducts(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Search Products", textAlign = TextAlign.Center,
            fontSize = 35.sp,
            fontWeight = FontWeight.Bold,
            color = appColor1,
        )
    }
}