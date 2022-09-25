package com.alexa.cryptoapp.model

data class CoinsList(
    var id: String? = null,
    var symbol: String? = null,
    var name: String? = null,
    var image: String? = null,
    var currentPrice: Double? = null,
    var changePercentage: Double? = null
)