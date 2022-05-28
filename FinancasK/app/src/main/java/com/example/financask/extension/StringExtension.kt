package com.example.financask.extension

fun String.limitaEmAte(caracteres: Int): String {
    if (this.length > caracteres) {
        val caracterInicio = 0
        return "${this.substring(caracterInicio, caracteres)}..."
    }
    return this
}