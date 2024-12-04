package com.jorgecamper0.horoscoapp.data.providers

import com.jorgecamper0.horoscoapp.R
import com.jorgecamper0.horoscoapp.domain.model.HoroscopeInfo
import com.jorgecamper0.horoscoapp.domain.model.HoroscopeInfo.*
import javax.inject.Inject

class HoroscopeProvider @Inject constructor() {
    fun getHoroscopes(): List<HoroscopeInfo> {
        return listOf(
            Aries,
            Taurus,
            Gemini,
            Cancer,
            Leo,
            Virgo,
            Libra,
            Scorpio,
            Sagittarius,
            Capricorn,
            Pisces,
            Aquarius
        )
    }
}