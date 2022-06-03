package com.jiwon.todaysdish

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jiwon.todaysdish.databinding.FragmentRecipeBinding

import androidx.fragment.app.activityViewModels
import com.jiwon.todaysdish.adapter.RecipeCardAdapter

import com.jiwon.todaysdish.model.RecipeViewModel

class RecipeFragment : Fragment() {

    private var binding: FragmentRecipeBinding? = null
    private val sharedViewModel: RecipeViewModel by activityViewModels()


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
        val entrees=sharedViewModel.getrecipe() //뷰모델에서 데이터를 가져와서 어뎁터에 넣기
        binding?.recipeRecyclerView?.adapter= RecipeCardAdapter(
            context,
            entrees,
            sharedViewModel._selecteNum

        )


    }
    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }



}