package com.c1ph3rj.c1ph3rcart.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.c1ph3rj.c1ph3rcart.components.ProductView
import com.c1ph3rj.c1ph3rcart.model.ProductModel
import com.c1ph3rj.c1ph3rcart.network.DummyJsonApi
import com.c1ph3rj.c1ph3rcart.network.RequestManager
import com.c1ph3rj.c1ph3rcart.network.api.ApiRequest
import com.c1ph3rj.c1ph3rcart.ui.theme.appColor1

@Composable
fun AllProducts(navController: NavController) {
    val listOfAllProducts = mutableListOf<ProductModel>()

    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "All Products", textAlign = TextAlign.Center,
            fontSize = 35.sp,
            fontWeight = FontWeight.Bold,
            color = appColor1,
        )
        LazyColumn {
            items(count = listOfAllProducts.size){
                index ->
                val currentProduct = listOfAllProducts[index]
                ProductView(currentProduct = currentProduct)
            }
        }
//        ProductView(currentProduct = ProductModel(
//            id = 23456,
//            title = "Sony WH34521C",
//            description = "Experience music like never before with our premium quality wireless Bluetooth headphones. These headphones provide an immersive audio experience with Hi-Fi sound and crystal-clear clarity. The built-in Active Noise Cancellation (ANC) technology blocks out unwanted background noise, allowing you to focus on your music or enjoy your favorite movies without any distractions.\n\nDesigned for maximum comfort, these headphones feature cushioned ear cups and an adjustable headband, ensuring a perfect fit for long listening sessions. The wireless Bluetooth connectivity lets you enjoy your music without the hassle of tangled wires, while the long-lasting battery ensures extended playback time.\n\nWith a sleek and stylish design, these headphones are perfect for both casual listening and professional use. Whether you're a music enthusiast, a frequent traveler, or someone who values high-quality audio, our premium wireless Bluetooth headphones are the perfect choice.",
//            price = 9999,
//            discountPercentage = 10.0,
//            rating = 4.5,
//            stock = 100,
//            brand = "Sony",
//            category = "HeadPhone",
//            thumbnail = "https://cdn.shopify.com/s/files/1/0153/8863/products/Headphone-Zone-Sony-WH-1000XM5-Black.jpg?v=1663741826&width=800",
//            images = listOf(
//                "https://www.insidehook.com/wp-content/uploads/2022/06/sony-h.jpg?resize=1200%2C630",
//                "https://manofmany.com/wp-content/uploads/2022/06/Sony-WH-1000XM5-feature-2-1.jpg",
//                "https://www.stuff.tv/wp-content/uploads/sites/2/2022/06/IMG_5175.jpg"
//            )
//        ))
    }
}