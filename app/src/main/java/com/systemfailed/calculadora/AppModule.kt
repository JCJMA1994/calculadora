package com.systemfailed.calculadora

import com.systemfailed.calculadora.data.repository.CalculatorRepository
import com.systemfailed.calculadora.domain.repository.ICalculatorRepository
import com.systemfailed.calculadora.domain.usecase.CalculatorUseCase
import com.systemfailed.calculadora.presentation.CalculatorViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import  org.koin.dsl.module

val appModule = module {

    single<ICalculatorRepository> { CalculatorRepository() }

    single { CalculatorUseCase(get()) }

    viewModelOf  (::CalculatorViewModel)
}