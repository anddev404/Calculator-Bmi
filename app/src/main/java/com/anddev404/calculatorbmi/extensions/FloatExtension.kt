package com.anddev404.calculatorbmi.extensions

class FloatExtension {

    companion object {

        fun Float.roundToOneDecimal(): Float {
            return String.format("%.1f", this).replace(",", ".").toFloat()
        }

        fun Float.roundToTwoDecimal(): Float {
            return String.format("%.2f", this).replace(",", ".").toFloat()
        }
    }
}