package com.example.nestrecycleviewapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.nestrecycleviewapp.R
import com.example.nestrecycleviewapp.data.BookModel
import com.example.nestrecycleviewapp.data.ParentModel
import com.example.nestrecycleviewapp.data.lifeCircleVo.CategoryProduct
import com.example.nestrecycleviewapp.data.lifeCircleVo.LifeCycleData
import com.example.nestrecycleviewapp.utils.Pig
import java.util.*


class ParentAdapter(val parentArray : ArrayList<LifeCycleData>, val cxt : Context) : RecyclerView.Adapter<ParentAdapter.ParentViewHolder>() {

    class ParentViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {
        //把layout檔的元件們拉進來，指派給當地變數
        val category = itemView.findViewById<TextView>(R.id.book_category)
        val childRecyclerView = itemView.findViewById<RecyclerView>(R.id.Child_RV)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParentViewHolder {
        //將book_items 與 BookBiewHolder 綁定
        val inflater = LayoutInflater.from(parent.context)
        val example = inflater.inflate(R.layout.parent_recyclerview_items, parent, false)
        return ParentViewHolder(example)
    }

    override fun onBindViewHolder(holder: ParentViewHolder, position: Int) {
        val currentModel = parentArray.get(position)
        val layoutManager: LayoutManager =
            LinearLayoutManager(cxt, LinearLayoutManager.HORIZONTAL, false)
        holder.childRecyclerView.setLayoutManager(layoutManager)
        holder.childRecyclerView.setHasFixedSize(true)

        holder.category.text = currentModel?.categoryMetadata?.displayName?:""

        //建立booklist
        val arrayList: ArrayList<BookModel> = ArrayList<BookModel>()


       for(item: CategoryProduct in parentArray.get(position).data!!){
           var img = Pig.IMG
           if(item.prodImagesRatioSmall?.get(0)!=""){
               //不包含.jpg or .png 的 就是base64 String
                            if(!((item.prodImagesRatioSmall?.get(0)?.contains(".jpg") == true) ||(item.prodImagesRatioSmall?.get(0)?.contains(".png") == true)))
                                img = item.prodImagesRatioSmall?.get(0)?:Pig.IMG
           }
           arrayList.add(BookModel(item.prodName?:"",img))
       }

        val childRecyclerViewAdapter = BookAdapter(arrayList);
        holder.childRecyclerView.setAdapter(childRecyclerViewAdapter);
    }

    override fun getItemCount(): Int {
        return parentArray.size
    }


}