package com.jorgecamper0.horoscoapp.ui.detail

import com.jorgecamper0.horoscoapp.domain.model.HoroscopeModel

sealed class HoroscopeDetailState {
    data object Loading:HoroscopeDetailState()
    data class Error(val error:String):HoroscopeDetailState()
    data class Success(val prediction:String, val sign:String, val HoroscopeModel: HoroscopeModel):HoroscopeDetailState()
}