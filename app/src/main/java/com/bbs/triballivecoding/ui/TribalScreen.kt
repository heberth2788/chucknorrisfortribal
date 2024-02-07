package com.bbs.triballivecoding.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.bbs.triballivecoding.R
import com.bbs.triballivecoding.ui.theme.TribalLiveCodingTheme


// State hoisting
@Composable
fun TribalScreen(
    //vm: TribalViewModel = viewModel(),
    vm: TribalViewModel = hiltViewModel(),
) {
    //State management
    /*var textFieldStr by remember { mutableStateOf("") }
    val onValueChangeTextField: (String) -> Unit  = {
        textFieldStr = it
    }*/

    TribalContet(
        textFieldStr = vm.tribalState.value.textFieldStr, //textFieldStr,
        onValueChange =  { vm.onValueChangeTextField(it) },
        onClickRandom = { vm.onClickRandom() },
        onClickQuery = { vm.onClickQuery() },
        onClickAllCategories = { vm.onClickAllCategories() },
        textFieldResult = vm.tribalState.value.textFieldResult,
    )
}

@Composable
fun TribalContet(
    textFieldStr: String = "animal",
    onValueChange: (String) -> Unit = {},
    onClickRandom: () -> Unit = {},
    onClickQuery: () -> Unit = {},
    onClickAllCategories: () -> Unit = {},
    textFieldResult: String = "animal, explicit, etc"
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        TextField(value = textFieldStr, onValueChange = onValueChange, modifier = Modifier.weight(0.1f))
        Row(modifier = Modifier.weight(0.1f)) {
            TextButton(onClick = onClickRandom) {
                Text(text = stringResource(id = R.string.button_random))
            }
            TextButton(onClick = onClickQuery) {
                Text(text = stringResource(id = R.string.button_query))
            }
        }
        TextButton(onClick = onClickAllCategories, modifier = Modifier.weight(0.1f)) {
            Text(text = stringResource(id = R.string.button_all_categories))
        }
        Text(text = textFieldResult, modifier = Modifier.weight(0.7f).fillMaxSize())
    }
}

@Composable
@Preview(showSystemUi = true, showBackground = true)
fun TribalContextPreview() {
    TribalLiveCodingTheme {
        TribalContet()
    }
}