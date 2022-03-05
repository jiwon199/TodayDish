package com.jiwon.todaysdish

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.jiwon.todaysdish.databinding.FragmentStartBinding
import androidx.navigation.fragment.findNavController
import com.jiwon.todaysdish.model.recipeViewModel

class startFragment : Fragment() {
    private var binding: FragmentStartBinding? = null
    //private val sharedViewModel: recipeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //뷰바인딩 쓰자!
        val fragmentBinding = FragmentStartBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //binding?.startFragment = this
        binding?.recipeListButton?.setOnClickListener{
            findNavController().navigate(R.id.action_startFragment_to_recipeFragment)
        }

    }
    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }



}