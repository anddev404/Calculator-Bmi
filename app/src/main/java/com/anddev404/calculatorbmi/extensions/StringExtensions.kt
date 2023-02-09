package com.anddev404.calculatorbmi.extensions

fun String.toFloatOrZero(): Float {
    return try {
        this.toFloat()
    } catch (nfe: NumberFormatException) {
        0f
    }
}

fun String.toIntOrZero(): Int {
    return try {
        this.toInt()
    } catch (nfe: NumberFormatException) {
        0
    }
}
