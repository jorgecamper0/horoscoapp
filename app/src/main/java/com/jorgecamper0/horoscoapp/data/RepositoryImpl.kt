package com.jorgecamper0.horoscoapp.data

import android.util.Log
import com.jorgecamper0.horoscoapp.data.network.HoroscopeApiService
import com.jorgecamper0.horoscoapp.domain.Repository
import com.jorgecamper0.horoscoapp.domain.model.PredictionModel
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val apiService: HoroscopeApiService) :Repository {
    override suspend fun getPrediction(sign: String): PredictionModel? {
        runCatching { apiService.getHoroscope(sign) }
            .onSuccess { return it.toDomain() }
            .onFailure { Log.i("jorge", "es un error:${it.message} ")}

        return null
    }
}