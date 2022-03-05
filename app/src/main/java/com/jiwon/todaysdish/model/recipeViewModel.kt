package com.jiwon.todaysdish.model
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
class recipeViewModel  : ViewModel() {


    private val _recipeNum = MutableLiveData<Int>()
    val recipeNum: LiveData<Int> = _recipeNum
    //사용자가 고른 레시피의 번호를 프래그먼트들이 공유하는 걸로 한다든지...
    fun setNum(numberRecipe: Int) {
        _recipeNum.value = numberRecipe
    }

    //컵케이크 예제에서 공유 뷰 모델을 썼었지...
    //그거랑 비슷하게 사용자가 옵션 여러개를 고르게 하고, 그에 맞는 레시피를 랜덤 추천해주는 시스템을 만들까?

}