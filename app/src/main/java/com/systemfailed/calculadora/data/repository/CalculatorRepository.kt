package com.systemfailed.calculadora.data.repository

import com.systemfailed.calculadora.domain.model.CalculateOperation
import com.systemfailed.calculadora.domain.repository.ICalculatorRepository

class CalculatorRepository : ICalculatorRepository {
    override suspend fun calculate(
        number1: Double,
        number2: Double,
        operation: CalculateOperation
    ): Double {
        if (operation == CalculateOperation.Divide && number2 == 0.0) {
            throw IllegalArgumentException("Division by zero")
        }
        return when (operation) {
            CalculateOperation.Add -> number1 + number2
            CalculateOperation.Subtract -> number1 - number2
            CalculateOperation.Multiply -> number1 * number2
            CalculateOperation.Divide -> number1 / number2
        }
    }
}