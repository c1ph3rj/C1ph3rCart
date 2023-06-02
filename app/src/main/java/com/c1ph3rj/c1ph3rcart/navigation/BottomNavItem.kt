package com.c1ph3rj.c1ph3rcart.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingBasket
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavData(val route: String,val icon: ImageVector,val title: String){
    object AllProducts: BottomNavData(route = "AllProducts", icon = Icons.Filled.ShoppingBasket, title = "AllProducts")
    object Categories: BottomNavData(route = "Categories", icon = Icons.Filled.Category, title = "Categories")
    object SearchProducts: BottomNavData(route = "SearchProducts", icon = Icons.Filled.Search, title = "SearchProducts")
}