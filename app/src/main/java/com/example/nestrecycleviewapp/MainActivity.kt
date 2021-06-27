package com.example.nestrecycleviewapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nestrecycleviewapp.adapter.CategoryAdapter
import com.example.nestrecycleviewapp.api.LifeCicleService
import com.example.nestrecycleviewapp.data.lifeCircleVo.LifeCircleResponse
import com.example.nestrecycleviewapp.data.lifeCircleVo.LifeCycleData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val parentRecycleView = findViewById(R.id.Parent_recyclerView)as RecyclerView
        val context = this

//
        parentRecycleView.setHasFixedSize(true)
        parentRecycleView.layoutManager = LinearLayoutManager(this)


         var retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://10.0.2.2:3000/")
            .build()
        val teamApi = retrofit.create(LifeCicleService::class.java)

        val call = teamApi.getData()

        call.enqueue(object : Callback<LifeCircleResponse> {
            override fun onFailure(call: Call<LifeCircleResponse>?, t: Throwable?) {

                Log.d("Call", " get teams fail ")
            }

            override fun onResponse(call: Call<LifeCircleResponse>?, response: Response<LifeCircleResponse>) {

                Log.d("Call", " get teams  success "+response.body())
                if(response?.body() != null){
                    val parentAdapter = CategoryAdapter(response.body()?.data!! as ArrayList<LifeCycleData>, context)
                    parentRecycleView.setAdapter(parentAdapter)
                    parentAdapter.notifyDataSetChanged()
                }
            }
        })
    }
}