package com.jorgecamper0.horoscoapp.data.providers

import com.jorgecamper0.horoscoapp.domain.model.HoroscopeInfo
import com.jorgecamper0.horoscoapp.domain.model.HoroscopeInfo.Aquarius
import com.jorgecamper0.horoscoapp.domain.model.HoroscopeInfo.Aries
import com.jorgecamper0.horoscoapp.domain.model.HoroscopeInfo.Cancer
import com.jorgecamper0.horoscoapp.domain.model.HoroscopeInfo.Capricorn
import com.jorgecamper0.horoscoapp.domain.model.HoroscopeInfo.Gemini
import com.jorgecamper0.horoscoapp.domain.model.HoroscopeInfo.Leo
import com.jorgecamper0.horoscoapp.domain.model.HoroscopeInfo.Libra
import com.jorgecamper0.horoscoapp.domain.model.HoroscopeInfo.Pisces
import com.jorgecamper0.horoscoapp.domain.model.HoroscopeInfo.Sagittarius
import com.jorgecamper0.horoscoapp.domain.model.HoroscopeInfo.Scorpio
import com.jorgecamper0.horoscoapp.domain.model.HoroscopeInfo.Taurus
import com.jorgecamper0.horoscoapp.domain.model.HoroscopeInfo.Virgo
import javax.inject.Inject

class HoroscopeProvider @Inject constructor() {
    fun getHoroscopes(): List<HoroscopeInfo> {
        return listOf(
            Taurus,
            Aries,
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