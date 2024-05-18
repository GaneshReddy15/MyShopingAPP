package com.example.myshopingapp

import org.json.JSONArray
import java.net.HttpURLConnection
import java.net.URL

object ApiService {
    fun getProducts(): List<Product> {
        val productList = mutableListOf<Product>()
        try {
            val url = URL("https://fakestoreapi.com/products")
            val connection = url.openConnection() as HttpURLConnection
            val response = connection.inputStream.bufferedReader().use { it.readText() }
            val jsonArray = JSONArray(response)
            for (i in 0 until jsonArray.length()) {
                val jsonObject = jsonArray.getJSONObject(i)
                val product = Product(
                    id = jsonObject.getString("id"),
                    name = jsonObject.getString("title"),
                    price = jsonObject.getString("price"),
                    imageUrl = jsonObject.getString("image"),
                    description = jsonObject.getString("description")
                )
                productList.add(product)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return productList
    }
}
