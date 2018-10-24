package com.example.miras.newsapp.news

import com.example.miras.newsapp.entity.News
import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface NewsService {

    @GET("news")
    fun getNews () : Observable<List<News>>

    @POST("news")
    fun addNews(@Body news: News) : Observable<ResponseBody>

}