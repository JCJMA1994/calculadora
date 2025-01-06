package com.systemfailed.calculadora.domain.model

data class CalculatorState(
    val number1: String = "",
    val number2: String = "",
    val calculatorOperation: CalculatorOperation? = null,
)


sealed class CalculatorOperation(val symbol: String) {
    data object Add : CalculatorOperation("+")
    data object Subtract : CalculatorOperation("-")
    data object Multiply : CalculatorOperation("x")
    data object Divide : CalculatorOperation("/")
}