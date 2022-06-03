package com.jiwon.todaysdish.model
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.jiwon.todaysdish.data.Row
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
class RecipeViewModel  : ViewModel() {


    val _selecteNum = MutableLiveData<Int>()
    val recipeNum: LiveData<Int> = _selecteNum

    //사용자가 고른 레시피의 번호를 프래그먼트들이 공유하는 걸로 한다든지...
    public fun setNum(numberRecipe: Int) {
        _selecteNum.value = numberRecipe

    }

    private val recipeList = mutableListOf<recipeItem>()


    fun setrecipe(
        recipeNum:Int,
        data:Row
    ) {

        val manuals: List<String> = listOf(data.MANUAL01,data.MANUAL02,data.MANUAL03,data.MANUAL04,data.MANUAL05,data.MANUAL06,data.MANUAL07,
            data.MANUAL08,data.MANUAL09,data.MANUAL10,data.MANUAL11,data.MANUAL12,data.MANUAL13,data.MANUAL14,data.MANUAL15,data.MANUAL16,
            data.MANUAL17,data.MANUAL18,data.MANUAL19,data.MANUAL20)
        val imgs: List<String> = listOf(data.MANUAL_IMG01,data.MANUAL_IMG02,data.MANUAL_IMG03,data.MANUAL_IMG04,data.MANUAL_IMG05,data.MANUAL_IMG06,data.MANUAL_IMG07
        ,data.MANUAL_IMG08,data.MANUAL_IMG09,data.MANUAL_IMG10,data.MANUAL_IMG11,data.MANUAL_IMG12,data.MANUAL_IMG13,data.MANUAL_IMG14,data.MANUAL_IMG15
        ,data.MANUAL_IMG16,data.MANUAL_IMG17,data.MANUAL_IMG18,data.MANUAL_IMG19,data.MANUAL_IMG20)
        recipeList.add(recipeItem(recipeNum,data.RCP_NM,data.RCP_PARTS_DTLS,manuals,imgs))
    }
    fun getrecipe(): MutableList<recipeItem> {
        return recipeList
    }


}