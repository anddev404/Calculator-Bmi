package com.anddev404.calculatorbmi.tools

import com.anddev404.calculatorbmi.data.model.HeightUnit
import com.anddev404.calculatorbmi.data.model.WeightUnit
import com.anddev404.calculatorbmi.extensions.FloatExtension.Companion.roundToIntWithDelta
import com.anddev404.calculatorbmi.extensions.FloatExtension.Companion.roundToOneDecimal

class UnitConverter {

    companion object {

        //region weight
        fun convertWeight(kg: Float, unit: WeightUnit): String {

            return when (unit) {
                WeightUnit.KG -> "${kg.roundToOneDecimal()} kg"
                WeightUnit.LB -> "${
                    kgToLb(kg)
                } lb"
                WeightUnit.ST_LB -> "${kgToStone(kg)} st ${
                    kgToLb(restFromKgToStone(kg))
                } lb"
            }
        }

        fun kgToStone(kg: Float): Int {
            return (kg * 0.1575f).roundToIntWithDelta()
        }

        fun restFromKgToStone(kg: Float): Float {
            return kg % 6.35029318f
        }

        fun kgToLb(kg: Float): Int {
            return (kg * 2.20462262f).roundToIntWithDelta()
        }

        fun stoneToKg(stones: Int): Float {
            return stones * 6.35029318f
        }

        fun lbToKg(lb: Int): Float {
            return lb * 0.45359237f
        }

        fun stoneAndLbToKg(stones: Int, lb: Int): Float {
            return stoneToKg(stones) + lbToKg(lb)
        }
        //endregion

        //region height
        fun convertHeight(cm: Float, unit: HeightUnit): String {

            return when (unit) {
                HeightUnit.CM -> "${cm.roundToOneDecimal()} cm"
                HeightUnit.IN -> "${
                    cmToInches(cm)
                } in"
                HeightUnit.FT_IN -> "${cmToFeet(cm)} ft ${
                    cmToInches(restFromCmToFeet(cm))
                } in"
            }
        }

        fun cmToFeet(cm: Float): Int {
            return (cm * 0.032808399f).roundToIntWithDelta()
        }

        fun restFromCmToFeet(cm: Float): Float {
            return cm % 30.48f
        }

        fun cmToInches(cm: Float): Int {
            return (cm * 0.3937007874f).roundToIntWithDelta()
        }

        fun feetToCm(feet: Int): Float {
            return feet * 30.48f
        }

        fun inchesToCm(inches: Int): Float {
            return inches * 2.54f
        }

        fun feetAndInchesToCm(feet: Int, inches: Int): Float {
            return feetToCm(feet) + inchesToCm(inches)
        }
        //endregion
    }
}