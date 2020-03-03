package eu.vmpay.algotests

import junit.framework.TestCase.assertEquals
import org.junit.Test



class OrderTest {

    @Test
    fun getPrice() {
        val donut = Donut.LARGE
        val topping = Topping.EMPTY
        val orderType = OrderType.INSIDE
        val order = Order(donut, topping, orderType)
        assertEquals(3.5, order.getPrice())
    }
}