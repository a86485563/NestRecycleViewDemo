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
import java.util.*


class ParentAdapter(val parentArray : ArrayList<ParentModel>,val cxt : Context) : RecyclerView.Adapter<ParentAdapter.ParentViewHolder>() {

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
        holder.category.text = currentModel.category

        //建立booklist
        val arrayList: ArrayList<BookModel> = ArrayList<BookModel>()

        // added the first child row
        if (parentArray.get(position).category.equals("comic")) {
            arrayList.add(BookModel("七龍珠",R.drawable.comic1,))
            arrayList.add(BookModel("航海王",R.drawable.comic2))
            arrayList.add(BookModel("拜託讓我六點下班",R.drawable.comic3 ))
            arrayList.add(BookModel("多拉a夢",R.drawable.comic4))
            arrayList.add(BookModel("小朱佩佩",R.drawable.comic5 ))

        }

        if (parentArray.get(position).category.equals("cook")) {
            arrayList.add(BookModel("cook1",R.drawable.cook1,))
            arrayList.add(BookModel("cook2",R.drawable.cook2))
            arrayList.add(BookModel("cook3",R.drawable.cook3 ))
            arrayList.add(BookModel("cook4",R.drawable.cook4))
            arrayList.add(BookModel("cook5",R.drawable.cook5 ))
        }

        if (parentArray.get(position).category.equals("finance")) {
            arrayList.add(BookModel("finance1",R.drawable.finance1,))
            arrayList.add(BookModel("finance2",R.drawable.finance2))
            arrayList.add(BookModel("finance3",R.drawable.finance3 ))
            arrayList.add(BookModel("finance4",R.drawable.finance3))
            arrayList.add(BookModel("finance5",R.drawable.finance5 ))
        }

        if (parentArray.get(position).category.equals("health")) {
            arrayList.add(BookModel("health1",R.drawable.health1,))
            arrayList.add(BookModel("health2",R.drawable.health2))
            arrayList.add(BookModel("health3",R.drawable.health3 ))
            arrayList.add(BookModel("health4",R.drawable.health4))
            arrayList.add(BookModel("health5",R.drawable.health5 ))

        }

        val childRecyclerViewAdapter = BookAdapter(arrayList);
        holder.childRecyclerView.setAdapter(childRecyclerViewAdapter);
    }

    override fun getItemCount(): Int {
        return parentArray.size
    }


}