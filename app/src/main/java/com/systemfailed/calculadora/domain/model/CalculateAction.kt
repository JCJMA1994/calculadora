package com.systemfailed.calculadora.domain.model


sealed class CalculateAction {
    data class Number(val number: Int) : CalculateAction()
    data object Clear : CalculateAction()
    data object Delete : CalculateAction()
    data class Operation(val calculateOperation:  CalculateOperation) : CalculateAction()
    data object Calculate : CalculateAction()
    data object Decimal : CalculateAction()
}