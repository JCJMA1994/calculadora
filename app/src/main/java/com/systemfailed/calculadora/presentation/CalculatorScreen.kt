package com.systemfailed.calculadora.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.systemfailed.calculadora.presentation.components.DisplayScreen
import com.systemfailed.calculadora.presentation.components.KeyScreen

@Composable
fun CalculatorScreen(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Gray)
            .padding(16.dp)
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            DisplayScreen(
                text = "0"
            )
            Row(
                modifier = modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                KeyScreen(
                    number = "AC",
                    modifier = modifier
                        .aspectRatio(2f)
                        .weight(2f)
                ) { }
                KeyScreen(
                    number = "C",
                    modifier = modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) { }
                KeyScreen(
                    number = "/",
                    modifier = modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) { }
            }
            Row(
                modifier = modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                KeyScreen(
                    number = "7",
                    modifier = modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) { }
                KeyScreen(
                    number = "8",
                    modifier = modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) { }
                KeyScreen(
                    number = "9",
                    modifier = modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) { }
                KeyScreen(
                    number = "X",
                    modifier = modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) { }
            }
            Row(
                modifier = modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                KeyScreen(
                    number = "4",
                    modifier = modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) { }
                KeyScreen(
                    number = "5",
                    modifier = modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) { }
                KeyScreen(
                    number = "6",
                    modifier = modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) { }
                KeyScreen(
                    number = "-",
                    modifier = modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) { }
            }
            Row(
                modifier = modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                KeyScreen(
                    number = "1",
                    modifier = modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) { }
                KeyScreen(
                    number = "2",
                    modifier = modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) { }
                KeyScreen(
                    number = "3",
                    modifier = modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) { }
                KeyScreen(
                    number = "+",
                    modifier = modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) { }
            }
            Row(
                modifier = modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                KeyScreen(
                    number = "0",
                    modifier = modifier
                        .aspectRatio(2f)
                        .weight(2f)
                ) { }
                KeyScreen(
                    number = ".",
                    modifier = modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) { }
                KeyScreen(
                    number = "=",
                    modifier = modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) { }
            }
        }
    }
}