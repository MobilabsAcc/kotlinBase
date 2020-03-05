package eu.vmpay.algotests



import junit.framework.TestCase.*
import org.junit.Test

import org.junit.Assert.assertTrue


class BakeryTest {

    @Test
    fun getAverageOrderPrice() {
        assertTrue(2+2==4)
    }

    @Test
    fun getAverageOrderPriceFail() {
        val bakery: IBakery = Bakery()
        val actual = bakery.getAverageOrderPrice()
        assertEquals(0.0, actual)
    }

    @Test
    fun payOrder() {
        val bakery: IBakery = Bakery()
        val order = Order(Donut.LARGE, Topping.EMPTY, OrderType.INSIDE)
        assertNull(bakery.payOrder(3.5))
        bakery.makeOrder(Donut.LARGE, Topping.EMPTY, OrderType.INSIDE)
        assertEquals(order, bakery.payOrder(3.5))
    }

    @Test
    fun makeOrder() {
        val bakery = Bakery()
        assertEquals(3.5,bakery.makeOrder(Donut.LARGE, Topping.EMPTY, OrderType.INSIDE))
        assertNull(bakery.makeOrder(Donut.LARGE, Topping.EMPTY, OrderType.INSIDE))
    }
}