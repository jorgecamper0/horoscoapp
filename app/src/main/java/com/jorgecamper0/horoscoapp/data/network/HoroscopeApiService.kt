package com.jorgecamper0.horoscoapp.data.network

import com.jorgecamper0.horoscoapp.data.network.response.PredictionResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface HoroscopeApiService {

    @GET("/{SIGN}")
    suspend fun getHoroscope(@Path("sign") sign:String):PredictionResponse

}