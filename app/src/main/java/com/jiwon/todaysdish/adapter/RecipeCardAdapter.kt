package com.jiwon.todaysdish.adapter
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.navigation.Navigation
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.jiwon.todaysdish.R
import com.jiwon.todaysdish.model.recipeItem

class RecipeCardAdapter(
    private val context: Context?,
    private val dataset: List<recipeItem>,
    private var selectedNum : MutableLiveData<Int>

): RecyclerView.Adapter<RecipeCardAdapter.RecipeCardViewHolder>() {


    class RecipeCardViewHolder(view: View?): RecyclerView.ViewHolder(view!!) {

        val recipe_name: TextView = view!!.findViewById(R.id.recipe_name)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeCardViewHolder{

        var adapterLayout= LayoutInflater.from(parent.context)
            .inflate(R.layout.recipe_item, parent, false)

        return RecipeCardViewHolder(adapterLayout)
    }

    //데이터셋의 사이즈 반환
    override fun getItemCount(): Int {
        return dataset.size

    }

    override fun onBindViewHolder(holder: RecipeCardViewHolder, position: Int) {

        val recipe = dataset[position] //position 변수가 현재 항목을 나타냄.
        holder.recipe_name.text = recipe.recipeName

        holder.itemView.setOnClickListener{
            //Toast.makeText( context,recipe.recipeNum.toString(), Toast.LENGTH_LONG).show()
            selectedNum.value=recipe.recipeNum

            var navController = Navigation.findNavController(holder.itemView)
            navController!!.navigate(R.id.action_recipeFragment_to_detailRecipeFragment)

        }

    }



}