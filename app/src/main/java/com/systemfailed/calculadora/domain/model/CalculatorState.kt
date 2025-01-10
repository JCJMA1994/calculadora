package com.systemfailed.calculadora.domain.model

data class CalculatorState(
    val number1: String = "",
    val number2: String = "",
    val operation: CalculateOperation? = null,
)

enum class CalculateOperation {
    ADD, SUBTRACT, MULTIPLY, DIVIDE
}