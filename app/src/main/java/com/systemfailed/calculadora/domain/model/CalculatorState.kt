package com.systemfailed.calculadora.domain.model

data class CalculatorState(
    val number1: String = "",
    val number2: String = "",
    val operation: CalculateOperation? = null,
)

sealed class CalculateOperation(val symbol: String) {
    data object Add: CalculateOperation("+")
    data object Subtract: CalculateOperation("-")
    data object Multiply: CalculateOperation("*")
    data object Divide: CalculateOperation("/")
}