package com.jiwon.todaysdish

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jiwon.todaysdish.databinding.FragmentRecipeBinding

import androidx.fragment.app.activityViewModels
import com.jiwon.todaysdish.adapter.RecipeCardAdapter

import com.jiwon.todaysdish.model.recipeViewModel

class RecipeFragment : Fragment() {

    private var binding: FragmentRecipeBinding? = null
    private val sharedViewModel: recipeViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentRecipeBinding.inflate(inflater, container, false)
        binding=fragmentBinding

        return fragmentBinding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.recipeFragment = this
        //binding?.test?.text=entrees[0].recipeName
        //loadData()
        val entrees=sharedViewModel.getrecipe()
        binding?.recipeRecyclerView?.adapter= RecipeCardAdapter(
            context,
            entrees
        )


    }
    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }



}