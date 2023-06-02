package com.c1ph3rj.c1ph3rcart.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.c1ph3rj.c1ph3rcart.model.ProductModel
import com.c1ph3rj.c1ph3rcart.network.RequestManager
import com.c1ph3rj.c1ph3rcart.screens.AllProducts
import com.c1ph3rj.c1ph3rcart.screens.Categories
import com.c1ph3rj.c1ph3rcart.screens.SearchProducts

@Composable
fun Navigation(
    navController: NavHostController,
    requestManager: RequestManager = RequestManager()
) {
    val allProducts = mutableListOf<ProductModel>()
    val listOfAllProducts = requestManager.getAllProductsResponse.value.products
    Log.d("AllProducts", "$listOfAllProducts")
    if (listOfAllProducts != null) {
        allProducts.addAll(listOfAllProducts)
    }
    NavHost(navController = navController, startDestination = BottomNavData.AllProducts.route) {
        bottomNavigation(navController)
        composable("Categories") {
            Categories(navController = navController)
        }
        composable("SearchProducts") {
            SearchProducts(navController = navController)
        }
    }
}

fun NavGraphBuilder.bottomNavigation(
    navController: NavController
) {
    composable(BottomNavData.AllProducts.route) {
        AllProducts(navController = navController)
    }
    composable(BottomNavData.Categories.route) {
        Categories(navController = navController)
    }
    composable(BottomNavData.SearchProducts.route) {
        SearchProducts(navController = navController)
    }
}