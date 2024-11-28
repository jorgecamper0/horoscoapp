package com.jorgecamper0.horoscoapp.data.providers

import com.jorgecamper0.horoscoapp.R
import com.jorgecamper0.horoscoapp.domain.model.HoroscopeInfo
import javax.inject.Inject

class HoroscopeProvider @Inject constructor() {
    fun getHoroscopes(): List<HoroscopeInfo> {
        return listOf(
            HoroscopeInfo.Aries,
            HoroscopeInfo.Taurus,
            HoroscopeInfo.Gemini,
            HoroscopeInfo.Cancer,
            HoroscopeInfo.Leo,
            HoroscopeInfo.Virgo,
            HoroscopeInfo.Libra,
            HoroscopeInfo.Scorpio,
            HoroscopeInfo.Sagittarius,
            HoroscopeInfo.Capricorn,
            HoroscopeInfo.Pisces,
            HoroscopeInfo.Aquarius
        )
    }
}