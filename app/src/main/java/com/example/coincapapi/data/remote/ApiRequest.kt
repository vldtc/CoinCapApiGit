package com.example.coincapapi.data.remote

import com.example.coincapapi.data.model.exchanges.ExchangesModel
import com.example.coincapapi.data.model.markets.MarketsModel
import com.example.coincapapi.data.model.rates.RatesModel
import retrofit2.http.GET

interface ApiRequest {

    @GET(ApiDetails.ASSETS)
    suspend fun getAssets(): com.example.coincapapi.data.model.assets.AssetsModel

    @GET(ApiDetails.ASSETS_BTC)
    suspend fun getAssetsBitcoin(): com.example.coincapapi.data.model.assets.AssetsModel

    @GET(ApiDetails.RATES)
    suspend fun getRates(): RatesModel

    @GET(ApiDetails.EXCHANGES)
    suspend fun getExchanges(): ExchangesModel

    @GET(ApiDetails.MARKET)
    suspend fun getMarkets(): MarketsModel
}