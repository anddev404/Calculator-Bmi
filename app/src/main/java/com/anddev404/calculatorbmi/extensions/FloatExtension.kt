package com.anddev404.calculatorbmi.extensions

class FloatExtension {

    companion object {

        fun Float.roundToIntWithDelta(): Int {
            return (this + 0.1).toInt()
        }

        fun Float.roundToOneDecimal(): Float {
            return String.format("%.1f", this).replace(",", ".").toFloat()
        }

        fun Float.roundToTwoDecimal(): Float {
            return String.format("%.2f", this).replace(",", ".").toFloat()
        }
    }
}