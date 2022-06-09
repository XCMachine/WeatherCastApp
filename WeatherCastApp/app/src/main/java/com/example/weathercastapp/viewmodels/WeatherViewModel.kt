package com.example.weathercastapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.network.entities.models.OpenWeatherDTO
import com.example.network.repositories.OpenWeatherRepository

class WeatherViewModel(
    private val weatherRepository: OpenWeatherRepository = OpenWeatherRepository
): ViewModel() {
    private val _weatherMain = MutableLiveData<OpenWeatherDTO.Main>()
    val weatherMain: LiveData<OpenWeatherDTO.Main> = _weatherMain

    fun getWeatherData() {
        weatherRepository.getWeatherData(_weatherMain)
    }
}