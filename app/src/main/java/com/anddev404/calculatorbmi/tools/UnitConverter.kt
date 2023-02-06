package com.anddev404.calculatorbmi.tools

import com.anddev404.calculatorbmi.data.model.HeightUnit
import com.anddev404.calculatorbmi.data.model.WeightUnit
import kotlin.math.roundToInt

class UnitConverter {

    companion object {

        //region weight
        fun convertWeight(kg: Float, unit: WeightUnit): String {

            return when (unit) {
                WeightUnit.KG -> "$kg kg"
                WeightUnit.LB -> "${
                    kgToLb(kg).roundToInt()
                } lb"
                WeightUnit.ST_LB -> "${kgToStone(kg)} st ${
                    kgToLb(restFromKgToStone(kg)).roundToInt()
                } lb"
            }
        }

        fun kgToStone(kg: Float): Int {
            return (kg * 0.1575f).toInt()
        }

        fun restFromKgToStone(kg: Float): Float {
            return kg % 6.35029318f
        }

        fun kgToLb(kg: Float): Float {
            return kg * 2.20462262f
        }
        //endregion

        //region height
        fun convertHeight(cm: Float, unit: HeightUnit): String {

            return when (unit) {
                HeightUnit.CM -> "$cm cm"
                HeightUnit.IN -> "${
                    cmToInches(cm).roundToInt()
                } in"
                HeightUnit.FT_IN -> "${cmToFeet(cm)} ft ${
                    cmToInches(restFromCmToFeet(cm)).roundToInt()
                } in"
            }
        }

        fun cmToFeet(cm: Float): Int {
            return (cm * 0.032808399).toInt()
        }

        fun restFromCmToFeet(cm: Float): Float {
            return cm % 30.48f
        }

        fun cmToInches(cm: Float): Float {
            return cm * 0.3937007874f
        }
        //endregion
    }
}