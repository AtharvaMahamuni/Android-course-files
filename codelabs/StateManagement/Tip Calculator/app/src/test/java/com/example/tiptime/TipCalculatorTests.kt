package com.example.tiptime

import org.junit.Assert
import org.junit.Test
import java.text.NumberFormat

class TipCalculatorTests {

    @Test
    fun calculateTip_20PercentNoRoundup() {
        val amount = 10.00
        val tipPercent = 20.00

        val expectedValue = NumberFormat.getCurrencyInstance().format(2)
        val actualValue = calculateTip(amount, tipPercent, false)

        Assert.assertEquals(expectedValue, actualValue)
    }
}