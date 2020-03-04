package eu.vmpay.algotests

import eu.vmpay.algotests.oop.Bakery
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class BakeryTest {

    @Test
    fun getAveragePrice() {
        assertTrue(2 + 2 == 4)
    }

    @Test
    fun getAveragePriceFail() {
        val bakery = Bakery()
        val actual = bakery.getAveragePrice()
        assertEquals(0.0, actual, 0.01)
    }
}