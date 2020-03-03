package eu.vmpay.algotests

import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertTrue
import org.junit.Test


class BakeryTest {

    @Test
    fun makeOrder() {
    }

    @Test
    fun payOrder() {
    }

    @Test
    fun getAverageOrderPrice() {
        assertTrue(2 + 2 == 4)
    }

    @Test
    fun getAverageOrderPriceFail() {
        val bakery: IBakery = Bakery()
        val actual = bakery.getAverageOrderPrice()
        assertEquals(0.0, actual)
    }
}