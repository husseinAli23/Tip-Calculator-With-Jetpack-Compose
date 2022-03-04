package com.hussain.dev.tipcalculator.ui.screens.home

import androidx.lifecycle.ViewModel
import com.hussain.dev.tipcalculator.Const
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlin.math.roundToInt

class MainViewModel : ViewModel() {


    private val _isRound = MutableStateFlow(false)
    val isRound = _isRound.asStateFlow()

    fun setIsRound(isRound: Boolean) {
        _isRound.value = isRound
    }

    private val _costOfServiceInput = MutableStateFlow("")
    val costOfServiceInput = _costOfServiceInput.asStateFlow()

    fun setCostOfServiceInput(value: String) {
        _costOfServiceInput.value = value
    }

    private val _option = MutableStateFlow(Const.option1)
    val option = _option.asStateFlow()

    fun setOption(value: String) {
        _option.value = value
    }

    private val _finalResult = MutableStateFlow("Tip Amount")
    val finalResult = _finalResult.asStateFlow()

    fun calculateTip() {
        var tipWithPercentage  = 0.0
        val cost = costOfServiceInput.value.toInt()
        tipWithPercentage = when (option.value) {
            Const.option1 -> cost * .2
            Const.option2 -> cost * .18
            Const.option3 -> cost * .15
            else -> option.value.toDouble()
        }
        _finalResult.value =
            if (isRound.value) "Tip Amount $" + tipWithPercentage.roundToInt() else "Tip Amount $" + tipWithPercentage
    }
}
