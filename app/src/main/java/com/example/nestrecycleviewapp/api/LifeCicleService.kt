package com.example.nestrecycleviewapp.api

import com.example.nestrecycleviewapp.data.lifeCircleVo.LifeCircleResponse
import retrofit2.Call
import retrofit2.http.GET

interface LifeCicleService {
    @GET("recommendations")
    fun getData(
    ): Call<LifeCircleResponse>;
}