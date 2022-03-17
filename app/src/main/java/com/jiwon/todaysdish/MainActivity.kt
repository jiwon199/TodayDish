package com.jiwon.todaysdish

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast


import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.jiwon.todaysdish.data.Library
import com.jiwon.todaysdish.data.Row
import com.jiwon.todaysdish.databinding.ActivityMainBinding

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
    //lateinit var binding: ActivityMainBinding //뷰바인딩!
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)


        //테스트!
        //binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        //loadData()

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        setupActionBarWithNavController(navController)
    }
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
    /*
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
            .enqueue(object: Callback<Library>{ //enqueue 메서드 사용하여 서버에 요청
                override fun onFailure(call: Call<Library>, t: Throwable) {
                    Toast.makeText(baseContext,"서버에서 데이터를 가져올 수 없습니다.",Toast.LENGTH_LONG).show()
                }
                override fun onResponse(call: Call<Library>, response: Response<Library>) {
                    showData(response.body() as Library)
                }

            })
    }
    fun showData(datas:Library){
        //val testText:TextView=binding.testid
        //testText.text= datas.COOKRCP01.row.toString()
        Toast.makeText(baseContext,"showData 실행.",Toast.LENGTH_LONG).show()

    }

     */

}