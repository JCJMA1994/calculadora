package com.systemfailed.calculadora.domain.repository

import com.systemfailed.calculadora.domain.model.CalculateOperation

interface ICalculatorRepository {
    suspend fun calculate(
        number1: Double,
        number2: Double,
        operation: CalculateOperation
    ): Double
}