package com.example.domain.usecases

import androidx.lifecycle.MutableLiveData
import com.example.network.entities.models.OpenWeatherDTO
import com.example.weathercastapp.repositories.OpenWeatherRepository

class GetLatestWeatherUseCase(
    private val weatherRepository: OpenWeatherRepository
) {
    operator fun invoke(mutableLiveData: MutableLiveData<OpenWeatherDTO.Main>) {
        weatherRepository.getWeatherData(mutableLiveData)
    }
}