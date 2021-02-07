package com.example.garam.takemissinginfo.network

import android.app.Application
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkController: Application() {

    private val baseUrl = "https://b5f53c1032e8.ngrok.io"

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