package com.jorgecamper0.horoscoapp.domain

import com.jorgecamper0.horoscoapp.data.network.response.PredictionResponse
import com.jorgecamper0.horoscoapp.domain.model.PredictionModel

interface Repository {

    suspend fun getPrediction(sign:String):PredictionModel?
}