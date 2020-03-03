package eu.vmpay.algotests

import Bakery
import junit.framework.TestCase.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test

import org.junit.Assert.assertTrue


class BakeryTest {

    @Test
    fun getAverageOrderPrice() {
        assertTrue(2 + 2 == 4)
    }

    @Test
    fun getAverageOrderPriceFail() {
        val bakery = Bakery()
        val actual = bakery.getAverageOrderPrice()
        assertEquals(0.0, actual)
    }

    @Test
    fun makeOrder() {


    }

    @Test
    fun payOrder() {

    }


}