package com.systemfailed.calculadora.data.repository

import com.systemfailed.calculadora.domain.model.CalculateOperation
import com.systemfailed.calculadora.domain.repository.ICalculatorRepository

class CalculatorRepository : ICalculatorRepository {
    override suspend fun calculate(
        number1: Double,
        number2: Double,
        operation: CalculateOperation
    ): Double {
        if (operation == CalculateOperation.DIVIDE && number2 == 0.0) {
            throw IllegalArgumentException("Division by zero")
        }
        return when (operation) {
            CalculateOperation.ADD -> number1 + number2
            CalculateOperation.SUBTRACT -> number1 - number2
            CalculateOperation.MULTIPLY -> number1 * number2
            CalculateOperation.DIVIDE -> number1 / number2
        }
    }
}