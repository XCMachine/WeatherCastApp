package com.example.weathercastapp.repositories

import androidx.lifecycle.MutableLiveData
import com.example.network.entities.datasources.WeatherRemoteDatasource
import com.example.network.entities.models.OpenWeatherDTO

object OpenWeatherRepository {
    private val weatherDatasource: WeatherRemoteDatasource = WeatherRemoteDatasource()

    //Cache
    private var latestWeatherData: OpenWeatherDTO.Main? = null

    fun getWeatherData(
        mutableLiveData: MutableLiveData<OpenWeatherDTO.Main>
    ) {
        if (latestWeatherData != null) {
            mutableLiveData.value = latestWeatherData
        } else {
            weatherDatasource.getWeatherData(object : WeatherRemoteDatasource.DataCallback {
                override fun onDataReady(data: OpenWeatherDTO.Main) {
                    latestWeatherData = data
                    mutableLiveData.value = latestWeatherData
                }
            })
        }
    }
}