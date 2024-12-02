package com.example.calanderappsdev264

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Text
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.runtime.Composable

import androidx.compose.runtime.collectAsState

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calanderappsdev264.viewmodel.MainViewModel


@Composable
fun SettingsScreen() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Gray)
            .height(100.dp)
            .border(6.dp, Color.Black)
    ) {
        Text(
            text = "Settings",
            style = TextStyle(fontSize = 30.sp),
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 16.dp)
                .padding(10.dp)
                .fillMaxWidth()
                .padding(0.dp, 20.dp, 0.dp, 0.dp)
        )
    }
}



@Composable
fun OptionsScreen1(viewModel: MainViewModel) {
    // Access the value of the State object returned by collectAsState
    val checkedOff = viewModel.checkedOff.collectAsState().value

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(25.dp)
    ) {
        IconToggleButton(
            checked = checkedOff,
            onCheckedChange = { checked ->
                // Update the ViewModel state when the toggle changes
                viewModel.checkedOffToggle(checked)
            },
            modifier = Modifier
                .padding(15.dp)
                .background(Color.DarkGray)
        ) {
            Icon(
                imageVector = if (checkedOff) Icons.Filled.Check else Icons.Filled.Close,
                contentDescription = "Toggle Check",
                modifier = Modifier.width(50.dp)
            )
        }
        Text(
            text = "Color Settings",
            style = TextStyle(fontSize = 30.sp),
            textAlign = TextAlign.Center,
            modifier = Modifier.align(Alignment.CenterVertically)
        )
    }
}
