package com.example.nestrecycleviewapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nestrecycleviewapp.R
import com.example.nestrecycleviewapp.data.BookModel

class BookAdapter(val bookArray : ArrayList<BookModel>) : RecyclerView.Adapter<BookAdapter.BookBiewHolder>() {

    class BookBiewHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {
        //把layout檔的元件們拉進來，指派給當地變數
        val image = itemView.findViewById<ImageView>(R.id.book_image)
        val title = itemView.findViewById<TextView>(R.id.book_name)

        fun bind(model: BookModel){
            //綁定當地變數與dataModel中的每個值
            image.setImageResource(model.image)
            title.text = model.title

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookBiewHolder {
        //將book_items 與 BookBiewHolder 綁定
        val inflater = LayoutInflater.from(parent.context)
        val example = inflater.inflate(R.layout.book_items, parent, false)
        return BookBiewHolder(example)
    }

    override fun onBindViewHolder(holder: BookBiewHolder, position: Int) {
        val currentModel = bookArray.get(position)
        holder.bind(currentModel)
    }

    override fun getItemCount(): Int {
        return bookArray.size
    }


}