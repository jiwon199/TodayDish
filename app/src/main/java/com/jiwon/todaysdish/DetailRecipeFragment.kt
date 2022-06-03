package com.jiwon.todaysdish

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.jiwon.todaysdish.databinding.FragmentDetailRecipeBinding
import com.jiwon.todaysdish.model.RecipeViewModel


class DetailRecipeFragment : Fragment() {

    private var binding: FragmentDetailRecipeBinding? = null
    public val sharedViewModel: RecipeViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentDetailRecipeBinding.inflate(inflater, container, false)
        binding= fragmentBinding

        return fragmentBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.detailRecipeFragment = this
        val selectedNum=sharedViewModel._selecteNum.value //뷰모델에서 데이터를 가져와서 어뎁터에 넣기
        binding?.number?.setText(selectedNum.toString())

    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
    /*
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_recipe, container, false)
    }

     */


}