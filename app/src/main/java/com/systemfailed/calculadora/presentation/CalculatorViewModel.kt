package com.systemfailed.calculadora.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.systemfailed.calculadora.domain.model.CalculateAction
import com.systemfailed.calculadora.domain.model.CalculateOperation
import com.systemfailed.calculadora.domain.model.CalculatorState
import com.systemfailed.calculadora.domain.usecase.CalculatorUseCase
import kotlinx.coroutines.launch

class CalculatorViewModel(
    private val calculatorUseCase: CalculatorUseCase
) : ViewModel() {

    var state by mutableStateOf(
        CalculatorState()
    )
        private set

    fun onAction(calculateAction: CalculateAction) {
        when (calculateAction) {
            is CalculateAction.Calculate -> calculate()
            is CalculateAction.Clear -> state = CalculatorState()
            is CalculateAction.Decimal -> enterDecimal()
            is CalculateAction.Delete -> delete()
            is CalculateAction.Number -> enterNumber(calculateAction.number)
            is CalculateAction.Operation -> enterOperation(calculateAction.calculateOperation)
        }
    }

    private fun enterOperation(operation: CalculateOperation) {
        if (state.number1.isNotBlank()) {
            state = state.copy(
                operation = operation
            )
        }
    }

    private fun enterNumber(number: Int) {
        if (state.operation == null) {
            if (state.number1.length >= MAX_NUM_LENGTH) {
                return
            }
            state = state.copy(
                number1 = state.number1 + number
            )
            return
        }
        if (state.number2.length >= MAX_NUM_LENGTH) {
            return
        }
        state = state.copy(
            number2 = state.number2 + number
        )
    }

    private fun delete() {
        when {
            state.number1.isNotBlank() -> state = state.copy(
                number1 = state.number1.dropLast(1)
            )

            state.number2.isNotBlank() -> state = state.copy(
                number2 = state.number2.dropLast(1)
            )

            state.operation != null -> state = state.copy(
                operation = null
            )
        }
    }

    private fun enterDecimal() {
        if (state.operation == null && !state.number1.contains(".") && state.number1.isNotBlank()) {
            state = state.copy(
                number1 = state.number1 + "."
            )
            return
        } else if (!state.number2.contains(".") && state.number2.isNotBlank()) {
            state = state.copy(
                number2 = state.number2 + "."
            )
        }
    }

    private fun calculate() {
        viewModelScope.launch {
            val number1 = state.number1.toDoubleOrNull()
            val number2 = state.number2.toDoubleOrNull()


            if (number1 != null && number2 != null) {
                state.operation?.let { operation ->
                    calculatorUseCase(number1, number2, operation)
                        .onSuccess { result ->
                            state = state.copy(
                                number1 = result.toString(),
                                number2 = "",
                                operation = null
                            )
                        }
                        .onFailure { error ->
                            state = state.copy(
                                number1 = error.message ?: "",
                                number2 = "",
                                operation = null
                            )
                        }
                }
            }
        }

    }

    companion object {
        private const val MAX_NUM_LENGTH = 8
    }

}