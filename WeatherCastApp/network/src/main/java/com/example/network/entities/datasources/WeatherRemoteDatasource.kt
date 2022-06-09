package com.example.network.entities.datasources

import android.util.Log
import com.example.network.Retrofit
import com.example.network.entities.api.ServiceApi
import com.example.network.entities.models.OpenWeatherDTO
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WeatherRemoteDatasource(
    private val serviceApi: ServiceApi = Retrofit().getInstance().create(ServiceApi::class.java)
) {
    fun getWeatherData(
        callback: DataCallback
    ) {
        val call = serviceApi.getWeather(
            latitude = 42.697708,
            longitude = 23.321867
        )

        call.enqueue(object : Callback<OpenWeatherDTO.Main> {
            override fun onResponse(
                call: Call<OpenWeatherDTO.Main>,
                response: Response<OpenWeatherDTO.Main>
            ) {
                response.body()?.run {
                    callback.onDataReady(this)
                }
            }

            override fun onFailure(call: Call<OpenWeatherDTO.Main>, t: Throwable) {
                Log.e("Call Error", t.localizedMessage!!)
            }
        })
    }

    interface DataCallback {
        fun onDataReady(data: OpenWeatherDTO.Main)
    }
}