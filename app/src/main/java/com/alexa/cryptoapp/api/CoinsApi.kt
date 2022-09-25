package com.alexa.cryptoapp.api

import com.alexa.cryptoapp.model.CoinsList
import retrofit2.Call
import retrofit2.http.*


interface RetrofitServices {

    @GET("api/v3/coins/markets?vs_currency={currency}&order=market_cap_desc&per_page=20&page=1&sparkline=false&price_change_percentage=24/")
    fun getMangaList(@Path("currency") currency: String): Call<MutableList<CoinsList>>
}

