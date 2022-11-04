package com.jashvantsewmangal.statecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jashvantsewmangal.statecodelab.ui.theme.StateCodelabTheme

@Composable
fun WaterCounterWithVM(modifier: Modifier = Modifier) {
    val waterCounterViewModel: WaterCounterViewModel = viewModel()
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        waterCounterViewModel.count.value.let {
            Text(
                "You've drank $it glasses of water",
                modifier = modifier.padding(16.dp)
            )
        }
        Button(onClick = {
            waterCounterViewModel.addWaterAmount()
        }) {
            Text("Click me")
        }
    }
}

@Composable
fun WaterCounterWithAbsolutelyUselessVM(modifier: Modifier = Modifier) {
    val waterCounterViewModel = WaterCounterViewModel()
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        waterCounterViewModel.count.value.let {
            Text(
                "You've drank $it glasses of water",
                modifier = modifier.padding(16.dp)
            )
        }
        Button(onClick = {
            waterCounterViewModel.addWaterAmount()
        }) {
            Text("Click me")
        }
    }
}



@Composable
fun WaterCounterWithoutVM(modifier: Modifier = Modifier) {
    var count by rememberSaveable {
        mutableStateOf(0)
    }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text("You've drank $count glasses of water", modifier = modifier.padding(16.dp))
        Button(onClick = {
            count++
        }) {
            Text("Click me")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WaterCounterPreview() {
    StateCodelabTheme {
        WaterCounterWithVM()
    }
}