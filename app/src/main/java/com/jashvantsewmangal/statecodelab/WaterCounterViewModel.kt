package com.jashvantsewmangal.statecodelab

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class WaterCounterViewModel: ViewModel() {
    private val _count: MutableState<Int> = mutableStateOf(0)
    val count: State<Int> = _count

    fun addWaterAmount(){
        _count.value++
        Log.d("amount", count.value.toString())
    }
}