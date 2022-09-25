package com.alexa.cryptoapp.model

data class CoinItem(
    val id: String,
    val symbol: String,
    val name: String,
    val image: String,
    val currentPrice: Double,
    val changePercentage: Double
)