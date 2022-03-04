package com.hussain.dev.tipcalculator.ui.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.hussain.dev.tipcalculator.Const
import com.hussain.dev.tipcalculator.R

@Composable
fun HomeScreen(mainViewModel: MainViewModel) {
    Column() {
        HomePart(mainViewModel)
        DisplayRadioGroup(mainViewModel)
        ListPart(mainViewModel)
    }
}


@Composable
fun HomePart(mainViewModel: MainViewModel) {
    val costOfServiceValue = mainViewModel.costOfServiceInput.collectAsState().value

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {

        OutlinedTextField(value = costOfServiceValue,
            onValueChange = mainViewModel::setCostOfServiceInput,
            label = {
                Text(stringResource(id = R.string.label_cost_of_service))
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),

            keyboardActions = KeyboardActions(
                onNext = {
                    mainViewModel.calculateTip()
                }
            )
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            stringResource(id = R.string.label_how_service),
            style = MaterialTheme.typography.body1
        )
    }
}

@Composable
fun DisplayRadioGroup(mainViewModel: MainViewModel) {

    val selected = mainViewModel.option.collectAsState().value

    Column(modifier = Modifier.padding(10.dp)) {
        Row(modifier = Modifier.padding(10.dp)) {
            RadioButton(
                selected = selected == Const.option1,
                onClick = { mainViewModel.setOption(Const.option1) }
            )
            Text(
               text = Const.option1,
                modifier = Modifier
                    .clickable(onClick = { mainViewModel.setOption(Const.option1) })
                    .padding(start = 4.dp),
            )
        }
        Spacer(modifier = Modifier.size(4.dp))
        Row(modifier = Modifier.padding(10.dp)) {
            RadioButton(
                selected = selected == Const.option2,
                onClick = { mainViewModel.setOption(Const.option2) })
            Text(
               text= Const.option2,
                modifier = Modifier
                    .clickable(onClick = { mainViewModel.setOption(Const.option2) })
                    .padding(start = 4.dp),
            )
        }

        Spacer(modifier = Modifier.size(4.dp))
        Row(modifier = Modifier.padding(10.dp)) {
            RadioButton(
                selected = selected == Const.option3,
                onClick = { mainViewModel.setOption(Const.option3) })
            Text(
               text= Const.option3,
                modifier = Modifier
                    .clickable(onClick = { mainViewModel.setOption(Const.option3) })
                    .padding(start = 4.dp),
            )
        }
    }
}

@Composable
fun ListPart(mainViewModel: MainViewModel) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = stringResource(id = R.string.label_round_tip),
            color = Color.Black
        )
        Switch(
            checked = mainViewModel.isRound.collectAsState().value,
            onCheckedChange = mainViewModel::setIsRound
        )
    }
    Spacer(modifier = Modifier.height(8.dp))
    Button(
        onClick =
        mainViewModel::calculateTip,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
    ) {
        Text(text = stringResource(id = R.string.label_calculate))
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 8.dp),
        horizontalArrangement = Arrangement.End
    ) {
        Text(
            text = mainViewModel.finalResult.collectAsState().value,
            color = Color.Black.copy(alpha = .5f)
        )
    }
}
