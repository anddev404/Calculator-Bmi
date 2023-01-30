package com.anddev404.calculatorbmi

import com.anddev404.calculatorbmi.extensions.FloatExtension.Companion.roundToInt
import com.anddev404.calculatorbmi.extensions.FloatExtension.Companion.roundToOneDecimal
import com.anddev404.calculatorbmi.extensions.FloatExtension.Companion.roundToTwoDecimal

import org.junit.Assert
import org.junit.Test

class FloatExtensionTest {

    @Test
    fun roundToInt() {

        Assert.assertEquals(0, 0f.roundToInt())

        Assert.assertEquals(0, 0.0f.roundToInt())
        Assert.assertEquals(0, 0.00f.roundToInt())
        Assert.assertEquals(0, 0.000f.roundToInt())

        Assert.assertEquals(0, 0.1f.roundToInt())
        Assert.assertEquals(0, 0.11f.roundToInt())
        Assert.assertEquals(0, 0.111f.roundToInt())

        Assert.assertEquals(1, 1.1f.roundToInt())
        Assert.assertEquals(1, 1.11f.roundToInt())
        Assert.assertEquals(1, 1.111f.roundToInt())

        Assert.assertEquals(1, 0.5f.roundToInt())
        Assert.assertEquals(1, 0.55f.roundToInt())
        Assert.assertEquals(0, 0.055f.roundToInt())

        Assert.assertEquals(2, 1.5f.roundToInt())
        Assert.assertEquals(1, 1.15f.roundToInt())

        Assert.assertEquals(12, 11.6f.roundToInt())
        Assert.assertEquals(11, 11.15f.roundToInt())

    }

    @Test
    fun roundToOneDecimal() {

        //region round down
        Assert.assertEquals(0.0f, 0f.roundToOneDecimal())

        Assert.assertEquals(0.0f, 0.0f.roundToOneDecimal())
        Assert.assertEquals(0.0f, 0.00f.roundToOneDecimal())
        Assert.assertEquals(0.0f, 0.000f.roundToOneDecimal())

        Assert.assertEquals(0.1f, 0.1f.roundToOneDecimal())
        Assert.assertEquals(0.1f, 0.11f.roundToOneDecimal())
        Assert.assertEquals(0.1f, 0.111f.roundToOneDecimal())

        Assert.assertEquals(1.1f, 1.1f.roundToOneDecimal())
        Assert.assertEquals(1.1f, 1.11f.roundToOneDecimal())
        Assert.assertEquals(1.1f, 1.111f.roundToOneDecimal())
        //endregion

        //region round up
        Assert.assertEquals(0.1f, 0.05f.roundToOneDecimal())
        Assert.assertEquals(0.0f, 0.005f.roundToOneDecimal())

        Assert.assertEquals(0.2f, 0.15f.roundToOneDecimal())
        Assert.assertEquals(0.1f, 0.115f.roundToOneDecimal())

        Assert.assertEquals(1.2f, 1.16f.roundToOneDecimal())
        Assert.assertEquals(1.1f, 1.115f.roundToOneDecimal())
        //endregion

    }

    @Test
    fun roundToTwoDecimal() {

        //region round down
        Assert.assertEquals(0.00f, 0f.roundToTwoDecimal())

        Assert.assertEquals(0.00f, 0.0f.roundToTwoDecimal())
        Assert.assertEquals(0.00f, 0.00f.roundToTwoDecimal())
        Assert.assertEquals(0.00f, 0.000f.roundToTwoDecimal())

        Assert.assertEquals(0.10f, 0.1f.roundToTwoDecimal())
        Assert.assertEquals(0.11f, 0.11f.roundToTwoDecimal())
        Assert.assertEquals(0.11f, 0.111f.roundToTwoDecimal())

        Assert.assertEquals(1.10f, 1.1f.roundToTwoDecimal())
        Assert.assertEquals(1.11f, 1.11f.roundToTwoDecimal())
        Assert.assertEquals(1.11f, 1.111f.roundToTwoDecimal())
        //endregion

        //region round up
        Assert.assertEquals(0.05f, 0.05f.roundToTwoDecimal())
        Assert.assertEquals(0.01f, 0.006f.roundToTwoDecimal())

        Assert.assertEquals(0.15f, 0.15f.roundToTwoDecimal())
        Assert.assertEquals(0.12f, 0.115f.roundToTwoDecimal())

        Assert.assertEquals(1.15f, 1.15f.roundToTwoDecimal())
        Assert.assertEquals(1.12f, 1.115f.roundToTwoDecimal())
        //endregion

    }
}