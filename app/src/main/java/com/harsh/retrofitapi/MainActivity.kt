package com.harsh.retrofitapi

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    var recViewAdapter : NewsRecViewAdapter? = null
    var recView : RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        recView=findViewById(R.id.recView)
        getNews()

    }

    private fun getNews() {
        val news : Call<NewsModel> = News_Service.newsInstance.getHeadlines()
        news.enqueue(object : Callback<NewsModel>{
            override fun onResponse(p0: Call<NewsModel>, p1: Response<NewsModel>) {

                val news = p1.body()

                if (news!=null) {

                    Log.d("APP_NEWS", news.toString())
                    recViewAdapter = NewsRecViewAdapter(this@MainActivity, news.articles)
                    recView?.adapter = recViewAdapter
                    recView?.layoutManager = LinearLayoutManager(this@MainActivity)

                }
            }

            override fun onFailure(p0: Call<NewsModel>, p1: Throwable) {
                Log.d("APP_NEWS", "Error in Fetching News")
            }

        })
    }
}