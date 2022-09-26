package com.alexa.cryptoapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alexa.cryptoapp.api.RetrofitClient
import com.alexa.cryptoapp.model.CoinItem
import kotlinx.coroutines.launch

class CoinViewModel : ViewModel() {
    var usdCoinsListResponse: List<CoinItem> by mutableStateOf(listOf())
    var eurCoinsListResponse: List<CoinItem> by mutableStateOf(listOf())

    fun getCoinsList() {
        viewModelScope.launch {
            val client = RetrofitClient.api
            val usdCoinsList = client.getUsdCoins()
            val eurCoinsList = client.getEurCoins()

            usdCoinsListResponse = usdCoinsList
            eurCoinsListResponse = eurCoinsList
        }
    }
}