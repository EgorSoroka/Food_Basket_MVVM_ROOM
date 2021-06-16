package com.example.foodbasket.magpie.screens.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.foodbasket.magpie.R
import com.example.foodbasket.magpie.models.AppFood

class MainAdapter:RecyclerView.Adapter<MainAdapter.MainHolder>() {

    private var mListFoods = emptyList<AppFood>()


    override fun onViewAttachedToWindow(holder: MainHolder) {
        holder.itemView.setOnClickListener{
            MainFragment.click(mListFoods[holder.adapterPosition])
        }
    }

    override fun onViewDetachedFromWindow(holder: MainHolder) {
        holder.itemView.setOnClickListener(null)
        super.onViewDetachedFromWindow(holder)
    }

    class MainHolder(view:View):RecyclerView.ViewHolder(view){
            val nameFood: TextView = view.findViewById(R.id.item_food_name)
            val quantityFood: TextView = view.findViewById(R.id.item_food_quantity)
            val date: TextView = view.findViewById(R.id.item_shelf_life)
            val categories: TextView = view.findViewById(R.id.item_categories)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.food_item, parent, false)
        return MainHolder(view)
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        holder.nameFood.text = mListFoods[position].name
        holder.quantityFood.text = mListFoods[position].quantity
        holder.date.text = mListFoods[position].date
        holder.categories.text = mListFoods[position].category
    }

    override fun getItemCount(): Int = mListFoods.size

    fun setList(list:List<AppFood>){
        mListFoods = list
        notifyDataSetChanged()
    }
}