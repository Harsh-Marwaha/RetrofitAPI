package com.harsh.retrofitapi

import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

// https://newsapi.org/v2/top-headlines?country=in&apiKey=83f340fcb6dd4d4fa3f1a9eba155e586
//https://newsapi.org/v2/everything?q=apple&from=2024-07-30&to=2024-07-30&sortBy=popularity&apiKey=83f340fcb6dd4d4fa3f1a9eba155e586

const val BASE_URL = "https://newsapi.org/"
const val API_KEY = "83f340fcb6dd4d4fa3f1a9eba155e586"

interface NewsService {

    @GET("v2/everything?q=apple&from=2024-07-30&to=2024-07-30&sortBy=popularity&apiKey=$API_KEY")
    fun getHeadlines() : Call<NewsModel>
    

}

object News_Service {

    var newsInstance : NewsService
    init {
        var retrofit = Retrofit.Builder()
                       .baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                       .build()
        newsInstance = retrofit.create(NewsService::class.java)
    }

}