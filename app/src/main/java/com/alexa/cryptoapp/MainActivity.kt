package com.alexa.cryptoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.alexa.cryptoapp.api.RetrofitClient
import com.alexa.cryptoapp.model.CoinItem
import com.alexa.cryptoapp.ui.theme.CryptoAppTheme
import com.alexa.cryptoapp.viewmodel.CoinViewModel

class MainActivity : ComponentActivity() {

    val viewModel by viewModels<CoinViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CryptoAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CoinsList(coinsList = viewModel.eurCoinsListResponse)
                    viewModel.getCoinsList()
                }
            }
        }
    }
}

@Composable
fun Coin(coin: CoinItem) {
    Row(Modifier.fillMaxWidth()) {
        AsyncImage(
            model = coin.image,
            contentDescription = null,
            modifier = Modifier.weight(1f)
        )
        Column(
            modifier = Modifier
                .height(80.dp)
                .weight(2f),
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = coin.name, fontSize = 16.sp)
            Text(text = coin.symbol.toUpperCase(), color = Color.LightGray, fontSize = 14.sp)
        }
        Column(
            horizontalAlignment = Alignment.End,
            modifier = Modifier
                .height(80.dp)
                .weight(2f),
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "$ ${coin.current_price}", fontSize = 16.sp)
            Text(
                text = "${coin.market_cap_change_percentage_24h} %",
                color = Color.Green,
                fontSize = 14.sp
            )
        }
    }
}

@Composable
fun CoinsList(coinsList: List<CoinItem>) {
    LazyColumn {
        itemsIndexed(items = coinsList) { index, item ->
            Coin(coin = item)
        }
    }

}



