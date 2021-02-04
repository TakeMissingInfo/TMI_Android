package com.example.garam.takemissinginfo.network

import android.app.Application
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class NetworkController: Application() {

    private val baseUrl = "https://5860a014be07.ngrok.io"

    lateinit var networkService: NetworkService

    companion object{
        lateinit var instance: NetworkController
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        buildNetwork()
    }

    fun buildNetwork(){

        val retrofit : Retrofit = Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build()

        networkService = retrofit.create(NetworkService::class.java)
    }

}