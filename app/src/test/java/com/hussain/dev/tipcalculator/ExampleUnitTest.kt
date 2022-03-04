package com.hussain.dev.tipcalculator

import com.hussain.dev.tipcalculator.Const.option3
import com.hussain.dev.tipcalculator.ui.screens.home.MainViewModel
import org.junit.Assert.assertEquals
import org.junit.Test

class ExampleUnitTest {
    @Test
    fun calculate20TipOf100_Result20() {
//        before
        val mainViewModel = MainViewModel()
        mainViewModel.setCostOfServiceInput("105")
        mainViewModel.setIsRound(false)
        mainViewModel.setOption(option3)

//        during
        mainViewModel.calculateTip()

//        after
        assertEquals(mainViewModel.finalResult.value, "Tip Amount $15.75")
    }
}