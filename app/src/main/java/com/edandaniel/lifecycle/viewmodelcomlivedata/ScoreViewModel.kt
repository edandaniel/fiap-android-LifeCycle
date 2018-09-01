package com.edandaniel.lifecycle.viewmodelcomlivedata

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class ScoreViewModel: ViewModel(){
    val scoreHome = MutableLiveData<Int>()
    val scoreGuest = MutableLiveData<Int>()

    init{
        scoreGuest.value = 0
        scoreHome.value = 0
    }

    fun pointHome(point:Int){
        scoreHome.value = scoreHome.value?.plus(point)
    }

    fun pointGuest(point:Int){
        scoreGuest.value = scoreGuest.value?.plus(point)
    }

    fun reset(){
        scoreHome.value = 0
        scoreGuest.value = 0
    }
}