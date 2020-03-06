package eu.vmpay.algotests.oop

import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNull
import org.junit.Before
import org.junit.Test

class BakeryTest {

    private lateinit var bakery: IBakery

    @Before
    fun setUp() {
        bakery = Bakery()
    }

    @Test
    fun payOrderHappyTest() {
        bakery.payOrder(bakery.makeOrder(Donut.STANDARD, Topping.BLUEBERRY, OrderType.INSIDE))
        bakery.payOrder(bakery.makeOrder(Donut.LARGE, Topping.RASPBERRY, OrderType.INSIDE))
        bakery.payOrder(bakery.makeOrder(Donut.STANDARD, Topping.BLUEBERRY, OrderType.TO_GO))
        bakery.payOrder(bakery.makeOrder(Donut.LARGE, Topping.NUTELLA, OrderType.TO_GO))
        bakery.payOrder(bakery.makeOrder(Donut.STANDARD, Topping.JAM, OrderType.TO_GO))
    }

    @Test
    fun payOrderFailTest() {
        assertNull(bakery.payOrder(0.0))
        bakery.payOrder(bakery.makeOrder(Donut.STANDARD, Topping.BLUEBERRY, OrderType.INSIDE))
        assertNull(bakery.payOrder(0.0))
    }

    @Test
    fun makeOrderFailTest() {
        bakery.makeOrder(Donut.LARGE, Topping.NUTELLA, OrderType.TO_GO)
        assertNull(bakery.makeOrder(Donut.LARGE, Topping.BLUEBERRY, OrderType.INSIDE))
    }

    @Test
    fun getAverageOrderPriceHappyTest() {

        bakery.payOrder(bakery.makeOrder(Donut.STANDARD, Topping.BLUEBERRY, OrderType.INSIDE))
        bakery.payOrder(bakery.makeOrder(Donut.LARGE, Topping.RASPBERRY, OrderType.INSIDE))
        assertEquals(3.75, bakery.getAverageOrderPrice())
    }

    @Test
    fun getAverageOrderPriceFailTest() {
        assertEquals(0.0, bakery.getAverageOrderPrice())
    }

    @Test
    fun orderTest() {
        val order = Order(Donut.STANDARD, Topping.NUTELLA, OrderType.TO_GO)
        assertEquals(Donut.STANDARD, order.donut)
        assertEquals(Topping.NUTELLA, order.topping)
        assertEquals(OrderType.TO_GO, order.orderType)
    }
}