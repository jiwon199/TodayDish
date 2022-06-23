package com.jiwon.todaysdish.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jiwon.todaysdish.R
import com.jiwon.todaysdish.model.recipeItem

class RecipeDetailAdapter(

    private val context: Context?,
    private val dataset: List<String>,
    private val imgs: List<String>
) : RecyclerView.Adapter<RecipeDetailAdapter.RecipeDetailViewHolder>() {


    class RecipeDetailViewHolder(view: View?): RecyclerView.ViewHolder(view!!) {

        //val recipe_name: TextView = view!!.findViewById(R.id.recipe_name)
        val recipe_content: TextView = view!!.findViewById(R.id.recipe_content)
        val recipe_img: ImageView = view!!.findViewById(R.id.recipe_img)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeDetailViewHolder{

        var adapterLayout= LayoutInflater.from(parent.context)
            .inflate(R.layout.recipe_detail, parent, false)

        return RecipeDetailViewHolder(adapterLayout)
    }

    //데이터셋의 사이즈 반환
    override fun getItemCount(): Int {
        return dataset.size

    }

    override fun onBindViewHolder(holder: RecipeDetailViewHolder, position: Int) {

        val recipe = dataset[position] //position 변수가 현재 항목을 나타냄.

        if (dataset[position].length>100){
            holder.recipe_content.setVisibility(View.GONE)
        }
        else {
            holder.recipe_content.text = dataset[position]
        }

        if (context != null) {
            if (imgs[position].length>5){
                Glide.with(context).load(imgs[position]).into(holder.recipe_img)
            }
        };




    }



}