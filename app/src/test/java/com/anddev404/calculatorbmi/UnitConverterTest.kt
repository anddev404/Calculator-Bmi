package com.anddev404.calculatorbmi

import com.anddev404.calculatorbmi.data.model.HeightUnit
import com.anddev404.calculatorbmi.data.model.WeightUnit
import com.anddev404.calculatorbmi.tools.UnitConverter
import org.junit.Assert.assertEquals
import org.junit.Test

class UnitConverterTest {

    @Test
    fun convertWeight() {

        assertEquals("0.0 kg", UnitConverter.convertWeight(0f, WeightUnit.KG))
        assertEquals("0.01 kg", UnitConverter.convertWeight(0.01f, WeightUnit.KG))
        assertEquals("0.1 kg", UnitConverter.convertWeight(0.1f, WeightUnit.KG))
        assertEquals("1.0 kg", UnitConverter.convertWeight(1.0f, WeightUnit.KG))
        assertEquals("10.0 kg", UnitConverter.convertWeight(10f, WeightUnit.KG))
        assertEquals("10.1 kg", UnitConverter.convertWeight(10.1f, WeightUnit.KG))
        assertEquals("100.0 kg", UnitConverter.convertWeight(100f, WeightUnit.KG))

        assertEquals("0 lb", UnitConverter.convertWeight(0f, WeightUnit.LB))
        assertEquals("0 lb", UnitConverter.convertWeight(0.01f, WeightUnit.LB))
        assertEquals("0 lb", UnitConverter.convertWeight(0.1f, WeightUnit.LB))
        assertEquals("2 lb", UnitConverter.convertWeight(1f, WeightUnit.LB))
        assertEquals("22 lb", UnitConverter.convertWeight(10f, WeightUnit.LB))
        assertEquals("220 lb", UnitConverter.convertWeight(100f, WeightUnit.LB))

        assertEquals("0 st 0 lb", UnitConverter.convertWeight(0f, WeightUnit.ST_LB))
        assertEquals("0 st 0 lb", UnitConverter.convertWeight(0.01f, WeightUnit.ST_LB))
        assertEquals("0 st 0 lb", UnitConverter.convertWeight(0.1f, WeightUnit.ST_LB))
        assertEquals("0 st 2 lb", UnitConverter.convertWeight(1f, WeightUnit.ST_LB))
        assertEquals("1 st 8 lb", UnitConverter.convertWeight(10f, WeightUnit.ST_LB))
        assertEquals("15 st 10 lb", UnitConverter.convertWeight(100f, WeightUnit.ST_LB))

    }

    @Test
    fun convertHeight() {

        assertEquals("0.0 cm", UnitConverter.convertHeight(0f, HeightUnit.CM))
        assertEquals("0.01 cm", UnitConverter.convertHeight(0.01f, HeightUnit.CM))
        assertEquals("0.1 cm", UnitConverter.convertHeight(0.1f, HeightUnit.CM))
        assertEquals("1.0 cm", UnitConverter.convertHeight(1.0f, HeightUnit.CM))
        assertEquals("10.0 cm", UnitConverter.convertHeight(10f, HeightUnit.CM))
        assertEquals("10.1 cm", UnitConverter.convertHeight(10.1f, HeightUnit.CM))
        assertEquals("100.0 cm", UnitConverter.convertHeight(100f, HeightUnit.CM))

        assertEquals("0 in", UnitConverter.convertHeight(0f, HeightUnit.IN))
        assertEquals("0 in", UnitConverter.convertHeight(0.01f, HeightUnit.IN))
        assertEquals("0 in", UnitConverter.convertHeight(0.1f, HeightUnit.IN))
        assertEquals("0 in", UnitConverter.convertHeight(1f, HeightUnit.IN))
        assertEquals("4 in", UnitConverter.convertHeight(10f, HeightUnit.IN))
        assertEquals("39 in", UnitConverter.convertHeight(100f, HeightUnit.IN))

        assertEquals("0 ft 0 in", UnitConverter.convertHeight(0f, HeightUnit.FT_IN))
        assertEquals("0 ft 0 in", UnitConverter.convertHeight(0.01f, HeightUnit.FT_IN))
        assertEquals("0 ft 0 in", UnitConverter.convertHeight(0.1f, HeightUnit.FT_IN))
        assertEquals("0 ft 0 in", UnitConverter.convertHeight(1f, HeightUnit.FT_IN))
        assertEquals("0 ft 4 in", UnitConverter.convertHeight(10f, HeightUnit.FT_IN))
        assertEquals("3 ft 3 in", UnitConverter.convertHeight(100f, HeightUnit.FT_IN))

    }

    @Test
    fun lbToKg() {

        assertEquals(0f, UnitConverter.lbToKg(0), 0.1f)
        assertEquals(0.4f, UnitConverter.lbToKg(1), 0.1f)
        assertEquals(4.5f, UnitConverter.lbToKg(10), 0.1f)
        assertEquals(45.3f, UnitConverter.lbToKg(100), 0.1f)
    }

    @Test
    fun stoneToKg() {

        assertEquals(0f, UnitConverter.stoneToKg(0), 0.1f)
        assertEquals(6.3f, UnitConverter.stoneToKg(1), 0.1f)
        assertEquals(63.5f, UnitConverter.stoneToKg(10), 0.1f)
        assertEquals(635.0f, UnitConverter.stoneToKg(100), 0.1f)
    }

    @Test
    fun stoneAndLbToKg() {

        assertEquals(0f, UnitConverter.stoneAndLbToKg(0, 0), 0.1f)
        assertEquals(6.3f, UnitConverter.stoneAndLbToKg(1, 0), 0.1f)
        assertEquals(0.4f, UnitConverter.stoneAndLbToKg(0, 1), 0.1f)
        assertEquals(6.8f, UnitConverter.stoneAndLbToKg(1, 1), 0.1f)
        assertEquals(68.0f, UnitConverter.stoneAndLbToKg(10, 10), 0.1f)
        assertEquals(680.3f, UnitConverter.stoneAndLbToKg(100, 100), 0.1f)
    }

    @Test
    fun inchesToCm() {

        assertEquals(0f, UnitConverter.inchesToCm(0), 0.1f)
        assertEquals(2.54f, UnitConverter.inchesToCm(1), 0.1f)
        assertEquals(25.4f, UnitConverter.inchesToCm(10), 0.1f)
        assertEquals(254.0f, UnitConverter.inchesToCm(100), 0.1f)
    }

    @Test
    fun feetToCm() {

        assertEquals(0f, UnitConverter.feetToCm(0), 0.1f)
        assertEquals(30.5f, UnitConverter.feetToCm(1), 0.1f)
        assertEquals(304.8f, UnitConverter.feetToCm(10), 0.1f)
        assertEquals(3048f, UnitConverter.feetToCm(100), 0.1f)
    }

    @Test
    fun feetAndInchesToCm() {

        assertEquals(0f, UnitConverter.feetAndInchesToCm(0, 0), 0.1f)
        assertEquals(30.5f, UnitConverter.feetAndInchesToCm(1, 0), 0.1f)
        assertEquals(2.5f, UnitConverter.feetAndInchesToCm(0, 1), 0.1f)
        assertEquals(33.0f, UnitConverter.feetAndInchesToCm(1, 1), 0.1f)
        assertEquals(330.2f, UnitConverter.feetAndInchesToCm(10, 10), 0.1f)
        assertEquals(3302.0f, UnitConverter.feetAndInchesToCm(100, 100), 0.1f)
    }
}