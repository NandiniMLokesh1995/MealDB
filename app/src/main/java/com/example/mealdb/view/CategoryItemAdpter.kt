package com.example.mealdb.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mealdb.R
import com.example.mealdb.databasemodel.Category


class CategoryItemAdpter :
    RecyclerView.Adapter<CategoryItemAdpter.MyViewHolder>() {
    lateinit var context:Context
    private var clickListener: ClickListener<Category>? = null
    private var itemsList= mutableListOf <Category>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_catg, parent, false)
       this.context=parent.context
        return MyViewHolder(view)
    }

    fun setData(item: List<Category>) {
        itemsList = item.toMutableList()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = itemsList[position]
        val url=item.strCategoryThumb
        holder.name.text = item.strCategory
        holder.desc.text = item.strCategoryDescription
        Glide
            .with(context)
            .load(url)
            .into(holder.thumn);
        holder.itemLayout.setOnClickListener { v -> clickListener!!.onClick(v, item, position) }
    }

    override fun getItemCount(): Int {
        return itemsList?.size ?:0
    }

    fun setOnItemClickListener(clickListener: ClickListener<Category>) {
        this.clickListener = clickListener
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView = itemView.findViewById(R.id.name)
        var desc: TextView = itemView.findViewById(R.id.desc)
        var thumn:ImageView=itemView.findViewById(R.id.tmage)
       val itemLayout: CardView = itemView.findViewById(R.id.layout_items)

    }
}