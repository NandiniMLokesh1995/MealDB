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
import com.example.mealdb.databasemodel.MealEntity


class MealsItemAdpter :
    RecyclerView.Adapter<MealsItemAdpter.MyViewHolder>() {
    lateinit var context:Context
    private var clickListener: ClickListener<MealEntity>? = null
    var itemsList= mutableListOf<MealEntity>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_meal, parent, false)
       this.context=parent.context
        return MyViewHolder(view)
    }
    fun setData( itemsList: List<MealEntity>){
        this.itemsList=itemsList.toMutableList()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = itemsList[position]
        val url=item.strMealThumb
        holder.name.text = item.strMeal
        Glide
            .with(context)
            .load(url)
            .into(holder.thumn);
        holder.itemLayout.setOnClickListener { v -> clickListener!!.onClick(v, item, position) }
    }

    override fun getItemCount(): Int {
        return itemsList?.size ?:0
    }

    fun setOnItemClickListener(clickListener: ClickListener<MealEntity>) {
        this.clickListener = clickListener
    }
    fun clearItems() {
        for(i:Int in 0..itemCount.dec()) {
            itemsList.drop(i)
            //notifyItemRemoved(i)
        }
        notifyDataSetChanged()
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView = itemView.findViewById(R.id.name)
        var thumn:ImageView=itemView.findViewById(R.id.tmage)
       val itemLayout: CardView = itemView.findViewById(R.id.layout_meal_items)

    }
}