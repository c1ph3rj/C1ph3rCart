package com.c1ph3rj.c1ph3rcart.model

data class GetProductsModel(
    val products: List<ProductModel>? = null,
    val total: Long? = null,
    val skip: Long? = null,
    val limit: Long? = null,
)

data class ProductModel(
    val id: Long,
    val title: String,
    val description: String,
    val price: Long,
    val discountPercentage: Double,
    val rating: Double,
    val stock: Long,
    val brand: String,
    val category: String,
    val thumbnail: String,
    val images: List<String>,
)