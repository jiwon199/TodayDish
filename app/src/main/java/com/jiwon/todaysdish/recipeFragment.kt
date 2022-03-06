package com.jiwon.todaysdish

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.jiwon.todaysdish.databinding.FragmentRecipeBinding
import com.jiwon.todaysdish.databinding.FragmentStartBinding

import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.jiwon.todaysdish.data.Library
import com.jiwon.todaysdish.data.RecipeDataSource

import com.jiwon.todaysdish.data.Row
import com.jiwon.todaysdish.databinding.ActivityMainBinding
import com.jiwon.todaysdish.model.recipeViewModel

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
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
        //loadData()
        val entrees=sharedViewModel.getrecipe()
        binding?.test?.text=entrees[0].recipeName

    }
    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }



}