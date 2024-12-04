package com.jorgecamper0.horoscoapp.ui.detail

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.navArgs
import com.jorgecamper0.horoscoapp.R
import com.jorgecamper0.horoscoapp.databinding.ActivityHoroscopeDetailBinding
import com.jorgecamper0.horoscoapp.domain.model.HoroscopeModel.Aquarius
import com.jorgecamper0.horoscoapp.domain.model.HoroscopeModel.Aries
import com.jorgecamper0.horoscoapp.domain.model.HoroscopeModel.Cancer
import com.jorgecamper0.horoscoapp.domain.model.HoroscopeModel.Capricorn
import com.jorgecamper0.horoscoapp.domain.model.HoroscopeModel.Gemini
import com.jorgecamper0.horoscoapp.domain.model.HoroscopeModel.Leo
import com.jorgecamper0.horoscoapp.domain.model.HoroscopeModel.Libra
import com.jorgecamper0.horoscoapp.domain.model.HoroscopeModel.Pisces
import com.jorgecamper0.horoscoapp.domain.model.HoroscopeModel.Sagittarius
import com.jorgecamper0.horoscoapp.domain.model.HoroscopeModel.Scorpio
import com.jorgecamper0.horoscoapp.domain.model.HoroscopeModel.Taurus
import com.jorgecamper0.horoscoapp.domain.model.HoroscopeModel.Virgo
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint


class HoroscopeDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHoroscopeDetailBinding
    private val horoscopeDetailViewModel:HoroscopeDetailViewModel by viewModels()

    private val args:HoroscopeDetailActivityArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHoroscopeDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
        horoscopeDetailViewModel.getHoroscope(args.type)

        enableEdgeToEdge()
        setContentView(R.layout.activity_horoscope_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun initUI() {
        initListener()
        initUIState()
    }

    private fun initListener() {
        binding.ivBack.setOnClickListener { onBackPressedDispatcher }
    }

    private fun initUIState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                horoscopeDetailViewModel.state.collect{
                    when(it){
                        HoroscopeDetailState.Loading -> {
                            loadingState()}

                        is HoroscopeDetailState.Error -> {
                            errorState()
                        }

                        is HoroscopeDetailState.Success -> {
                            successState(it)
                        }
                    }
                }
            }
        }
    }


    private fun loadingState() {
        binding.pb.isVisible = true
    }

    private fun errorState() {
        binding.pb.isVisible = false
    }

    private fun successState(state: HoroscopeDetailState.Success) {
        binding.pb.isVisible = false
        binding.tvTitle.text = state.sign
        binding.tvBody.text = state.prediction

        val image = when(state.HoroscopeModel){
            Aries -> R.drawable.detail_aries
            Taurus -> R.drawable.detail_taurus
            Gemini -> R.drawable.detail_gemini
            Cancer -> R.drawable.detail_cancer
            Leo -> R.drawable.detail_leo
            Virgo -> R.drawable.detail_virgo
            Libra -> R.drawable.detail_libra
            Scorpio -> R.drawable.detail_scorpio
            Sagittarius -> R.drawable.detail_sagittarius
            Capricorn -> R.drawable.detail_capricorn
            Pisces -> R.drawable.detail_pisces
            Aquarius -> R.drawable.detail_aquarius
        }
        binding.ivDetail.setImageResource(image)
    }
}