package com.example.retrofit.repository

import com.example.retrofit.api.RetrofitInstance
import com.example.retrofit.model.Post

class Repository {
    suspend fun getPost(): List<Post>{
        return RetrofitInstance.api.getPost()
    }

}