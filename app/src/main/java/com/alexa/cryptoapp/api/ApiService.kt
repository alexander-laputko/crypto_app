package com.alexa.cryptoapp.api

import com.alexa.cryptoapp.model.CoinItem
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("coins/markets?vs_currency=usd&order=market_cap_desc&per_page=20&page=1&sparkline=false&price_change_percentage=24")
    suspend fun getUsdCoins(): Response<CoinItem>

    @GET("coins/markets?vs_currency=eur&order=market_cap_desc&per_page=20&page=1&sparkline=false&price_change_percentage=24")
    suspend fun getEurCoins(): Response<CoinItem>
}

