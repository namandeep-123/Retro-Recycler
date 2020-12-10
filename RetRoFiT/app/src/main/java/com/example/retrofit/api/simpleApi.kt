package com.example.retrofit.api

import com.example.retrofit.model.Post
import retrofit2.http.GET

interface simpleApi {
    @GET("photos")
    suspend fun getPost(): List<Post>
}