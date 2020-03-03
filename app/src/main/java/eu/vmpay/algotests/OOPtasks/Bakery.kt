package eu.vmpay.algotests.OOPtasks

/**
 * Challenge 1 - The bakery
 *
 * The Warsaw bakery called "Cukiernia - ACC" is famous of it's donuts. It has 2 different kinds of
 * those (standard - 2zł, extra large - 3.5zł) and each can be served with a different topping
 * (cranberry/blueberry/raspberry/strawberry - 1zł and jam, nutella - 1.5zł) or without it.
 * The overall price of the donut equals to the price of donut itself + the price of topping
 * (can be more than one). Due limited number of exclusive donuts the bakery can sell one donut at a time.
 *
 * Goal: implement the bakery, donut, topping, order abstractions reflecting the above case.
 */
enum class Donut(val price: Double) {
    STANDARD(2.0),
    LARGE(3.5)
}

enum class Topping(val price: Double) {
    CRANBERRY(1.0),
    BLUEBERRY(1.0),
    RASPBERRY(1.0),
    STRAWBERRY(1.0),
    JAM(1.5),
    NUTELLA(1.5),
    EMPTY(0.0)
}

enum class OrderType(val price: Double) {
    TO_GO(0.5),
    INSIDE(0.0)
}

data class Order(
    val donut: Donut,
    val topping: Topping,
    val orderType: OrderType
) {
    fun getPrice() = donut.price + topping.price + orderType.price
}

interface IBakery {

    fun makeOrder(donut: Donut, topping: Topping, orderType: OrderType): Double?

    fun payOrder(price: Double?): Order?

    fun getAverageOrderPrice(): Double
}

class Bakery : IBakery {

    private var order: Order? = null
    private var revenue: Double = 0.0
    private var orderCount = 0

    override fun makeOrder(donut: Donut, topping: Topping, orderType: OrderType): Double? =
            if (order == null) {
                Order(donut, topping, orderType).let {
                    order = it
                    it.getPrice()
                }
            } else {
                null
            }

    override fun payOrder(price: Double?): Order? =
            if (order != null && price != null && order?.getPrice() == price) {
                revenue += price
                orderCount++
                order.also { order = null }
            } else {
                null
            }

    override fun getAverageOrderPrice(): Double = if (orderCount == 0) 0.0 else revenue / orderCount
}
