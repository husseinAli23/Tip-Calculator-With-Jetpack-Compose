package com.hussain.dev.tipcalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.hussain.dev.tipcalculator.ui.screens.home.HomeScreen
import com.hussain.dev.tipcalculator.ui.screens.home.MainViewModel
import com.hussain.dev.tipcalculator.ui.theme.TipCalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val mainViewModel = MainViewModel()
        super.onCreate(savedInstanceState)
        setContent {
            TipCalculatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    HomeScreen(mainViewModel= mainViewModel)
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TipCalculatorTheme {
//        DisplayRadioGroup()
    }
}