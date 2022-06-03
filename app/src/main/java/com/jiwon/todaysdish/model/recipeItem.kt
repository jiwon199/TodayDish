package com.jiwon.todaysdish.model

data class recipeItem (
    var recipeNum:Int,
    var recipeName:String,
    var ingredient:String,
    val manuals: List<String>,
    val imgs: List<String>
)