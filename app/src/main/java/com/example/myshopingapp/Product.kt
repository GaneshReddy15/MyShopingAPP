package com.example.myshopingapp
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
@Parcelize
data class Product(val id: String,
                   val name: String,
                   val price: String,
                   val imageUrl: String,
                   val description: String
) : Parcelable

data class ProductResponse(
    val products: List<Product>
)