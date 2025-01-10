package com.systemfailed.calculadora.domain.usecase

import com.systemfailed.calculadora.domain.model.CalculateOperation
import com.systemfailed.calculadora.domain.repository.ICalculatorRepository

class CalculatorUseCase(
    private val repository: ICalculatorRepository
) {
    suspend operator fun invoke(
        first: Double,
        second: Double,
        operation: CalculateOperation
    ): Result<Double> = try {
        Result.success(repository.calculate(first, second, operation))
    } catch (e: Exception) {
        Result.failure(e)
    }
}