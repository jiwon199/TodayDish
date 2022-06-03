package com.jiwon.todaysdish

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.jiwon.todaysdish.databinding.FragmentStartBinding
import androidx.navigation.fragment.findNavController
import com.jiwon.todaysdish.data.Library
import com.jiwon.todaysdish.model.RecipeViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class StartFragment : Fragment() {
    private var binding: FragmentStartBinding? = null
    private val sharedViewModel: RecipeViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        GlobalScope.launch{
            //레시피 정보를 서버한테 받아서 공유 뷰 모델에 저장!
            loadData()
        }
        super.onCreate(savedInstanceState)


    }

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
        binding?.startFragment = this
        binding?.recipeListButton?.setOnClickListener{

            findNavController().navigate(R.id.action_startFragment_to_recipeFragment)
        }



    }
    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    fun loadData(){
        //json 컨버터를 설정해서 레트로핏 생성
        val retrofit= Retrofit.Builder()
            .baseUrl(recipeOpenApi.DOMAIN)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        //앞서 정의한 인터페이스를 실행 가능한 서비스 객체로 반환
        val recipeOpenService=retrofit.create(recipeOpenService::class.java)
        recipeOpenService
            .getData(resources.getString(R.string.api_key))
            .enqueue(object: Callback<Library> { //enqueue 메서드 사용하여 서버에 요청
                override fun onFailure(call: Call<Library>, t: Throwable) {
                    Toast.makeText(getActivity(),"서버에서 데이터를 가져올 수 없습니다.",Toast.LENGTH_LONG).show()
                }
                override fun onResponse(call: Call<Library>, response: Response<Library>) {
                    showData(response.body() as Library)
                }
            })
    }
    fun showData(datas:Library){

        var count=1
        for (r in datas.COOKRCP01.row){
            sharedViewModel.setrecipe(count,r)
            count+=1
        }
        Log.v("test","서버로부터 데이터를 가져옴")
        Toast.makeText( context,"로드..", Toast.LENGTH_SHORT).show()
    }



}