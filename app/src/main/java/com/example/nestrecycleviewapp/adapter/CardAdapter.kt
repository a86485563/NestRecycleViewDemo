package com.example.nestrecycleviewapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nestrecycleviewapp.R
import com.example.nestrecycleviewapp.data.CardModel
import com.example.nestrecycleviewapp.utils.Pig

class CardAdapter(val lifeCicleDatas : ArrayList<CardModel>) : RecyclerView.Adapter<CardAdapter.BookBiewHolder>() {

    class BookBiewHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {
        //把layout檔的元件們拉進來，指派給當地變數
        val image = itemView.findViewById<ImageView>(R.id.book_image)
        val title = itemView.findViewById<TextView>(R.id.book_name)

        fun bind(model: CardModel){
            //綁定當地變數與dataModel中的每個值
            image.setImageBitmap(Pig.base64ToBitMap(model.image)  )
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
        val currentModel = lifeCicleDatas.get(position)
        holder.bind(currentModel)
    }

    override fun getItemCount(): Int {
        return lifeCicleDatas.size
    }


}