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
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.systemfailed.calculadora.domain.model.CalculateAction
import com.systemfailed.calculadora.domain.model.CalculateOperation
import com.systemfailed.calculadora.presentation.components.DisplayScreen
import com.systemfailed.calculadora.presentation.components.KeyScreen
import org.koin.androidx.compose.koinViewModel

@Composable
fun CalculatorScreen(
    modifier: Modifier = Modifier,
    viewModel: CalculatorViewModel = koinViewModel()

) {
    val state = viewModel.state

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp)
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            DisplayScreen(
                state.number1 + (state.operation?.symbol ?: "") + state.number2
            )
            Row(
                modifier = modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                KeyScreen(
                    number = "AC",
                    colorText = Color.Red,
                    modifier = modifier
                        .aspectRatio(2f)
                        .weight(2f)
                ) {
                    viewModel.onAction(CalculateAction.Clear)
                }
                KeyScreen(
                    number = "C",
                    colorText = Color.Red,
                    modifier = modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onAction(CalculateAction.Delete)
                }
                KeyScreen(
                    number = "/",
                    colorText = Color.Blue,
                    modifier = modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onAction(CalculateAction.Operation(CalculateOperation.Divide))
                }
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
                ) {
                    viewModel.onAction(CalculateAction.Number(7))
                }
                KeyScreen(
                    number = "8",
                    modifier = modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onAction(CalculateAction.Number(8))
                }
                KeyScreen(
                    number = "9",
                    modifier = modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onAction(CalculateAction.Number(9))
                }
                KeyScreen(
                    number = "*",
                    colorText = Color.Blue,
                    modifier = modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onAction(CalculateAction.Operation(CalculateOperation.Multiply))
                }
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
                ) {
                    viewModel.onAction(CalculateAction.Number(4))
                }
                KeyScreen(
                    number = "5",
                    modifier = modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onAction(CalculateAction.Number(5))
                }
                KeyScreen(
                    number = "6",
                    modifier = modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onAction(CalculateAction.Number(6))
                }
                KeyScreen(
                    number = "-",
                    colorText = Color.Blue,
                    modifier = modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onAction(CalculateAction.Operation(CalculateOperation.Subtract))
                }
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
                ) {
                    viewModel.onAction(CalculateAction.Number(1))
                }
                KeyScreen(
                    number = "2",
                    modifier = modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onAction(CalculateAction.Number(2))
                }
                KeyScreen(
                    number = "3",
                    modifier = modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onAction(CalculateAction.Number(3))
                }
                KeyScreen(
                    number = "+",
                    colorText = Color.Blue,
                    modifier = modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onAction(CalculateAction.Operation(CalculateOperation.Add))
                }
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
                ) {
                    viewModel.onAction(CalculateAction.Number(0))
                }
                KeyScreen(
                    number = ".",
                    modifier = modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onAction(CalculateAction.Decimal)
                }
                KeyScreen(
                    number = "=",
                    colorText = Color.Blue,
                    modifier = modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    viewModel.onAction(CalculateAction.Calculate)
                }
            }
        }
    }
}