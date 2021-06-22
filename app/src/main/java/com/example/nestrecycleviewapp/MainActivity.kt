package com.example.nestrecycleviewapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nestrecycleviewapp.adapter.ParentAdapter
import com.example.nestrecycleviewapp.data.ParentModel
import java.util.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val parentRecycleView = findViewById(R.id.Parent_recyclerView)as RecyclerView
        val parentModelArrayList: ArrayList<ParentModel> = ArrayList<ParentModel>()

        parentModelArrayList.add(ParentModel("comic"))
        parentModelArrayList.add(ParentModel("cook"))
        parentModelArrayList.add(ParentModel("finance"))
        parentModelArrayList.add(ParentModel("health"))

        parentRecycleView.setHasFixedSize(true)
        parentRecycleView.layoutManager = LinearLayoutManager(this)
        val parentAdapter = ParentAdapter(parentModelArrayList, this)
        parentRecycleView.setAdapter(parentAdapter)
        parentAdapter.notifyDataSetChanged()
    }
}