package com.example.network.entities.api

import com.example.network.entities.models.OpenWeatherDTO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ServiceApi {
    @GET("data/2.5/weather")
    fun getWeather(
        @Query("lat")
        latitude: Double,
        @Query("lon")
        longitude: Double,
        @Query("appid")
        apiKey: String = API_KEY
    ): Call<OpenWeatherDTO.Main>

    companion object {
        private const val API_KEY = "42f4f4396ec96b2f9aa9d60cecd413ed"
    }
}