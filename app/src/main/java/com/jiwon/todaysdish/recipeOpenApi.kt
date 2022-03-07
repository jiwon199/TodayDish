package com.jiwon.todaysdish

import com.jiwon.todaysdish.data.Library
import com.jiwon.todaysdish.data.Row
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

class recipeOpenApi {
    //companion object 안에 선언한 애들은 recipeOpenApi.어쩌구로 접근하지 않아도 됨
    companion object{
        val DOMAIN="http://openapi.foodsafetykorea.go.kr/api/"
    }
}

//레트로핏에서 사용할 인터페이스
interface recipeOpenService{

    @GET("{api_key}/COOKRCP01/json/1/200")
    fun getData(@Path("api_key") key: String): Call <Library>
}
