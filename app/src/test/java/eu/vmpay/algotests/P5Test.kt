package eu.vmpay.algotests

import org.junit.Before
import org.junit.Test

class P5Test {

    private lateinit var bakery: IBakery

    @Before
    fun setUp() {
        bakery = Bakery()
    }

    @Test
    fun day1Test() {
        bakery.payOrder(bakery.makeOrder(Donut.STANDARD, Topping.BLUEBERRY, OrderType.INSIDE))
        bakery.payOrder(bakery.makeOrder(Donut.LARGE, Topping.RASPBERRY, OrderType.INSIDE))
        bakery.payOrder(bakery.makeOrder(Donut.STANDARD, Topping.BLUEBERRY, OrderType.TO_GO))
        bakery.payOrder(bakery.makeOrder(Donut.LARGE, Topping.NUTELLA, OrderType.TO_GO))
        bakery.payOrder(bakery.makeOrder(Donut.STANDARD, Topping.JAM, OrderType.TO_GO))
        println(bakery.getAverageOrderPrice())
    }
}