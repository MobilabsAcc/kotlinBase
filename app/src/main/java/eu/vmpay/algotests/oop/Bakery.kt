package eu.vmpay.algotests.oop

/**
 * Challenge 1 - The bakery
 *
 * The Warsaw bakery called "Cukiernia - ACC" is famous of it's donuts. It has 2 different kinds of
 * those (standard - 2zł, extra large - 3.5zł) and each can be served with a different topping
 * (cranberry/blueberry/raspberry/strawberry jam, nutella - 1zł). The overall price of the donut equals
 * to the price of donut itself + the price of topping (can be more than one). Due limited number of
 * exclusive donuts the bakery can sell one donut at a time.
 *
 * Goal: implement the bakery, donut, topping, order abstractions reflecting the above case.
 */


/**
 * Team:
 * Paweł Barszcz
 * Ryszard Eggink
 * Marcin Żyżyński
 */
class Bakery {
    val name = "Cukiernia - ACC"

    val orders = mutableListOf<Order>()

    fun make(order: Order): Donut {
        println(order.getPriceWithToppings())
        orders.add(order)
        return Donut(order.donutSize, order.topping)
    }

    fun getAveragePrice(): Double {
        if (orders.size == 0) {
            return 0.0
        }
        return orders.sumByDouble {it.getPriceWithToppings()} / orders.size
    }
}

data class Order(val donutSize: DonutSize, val topping: Topping? = null) {
    fun getPriceWithToppings(): Double {
        return donutSize.price + (topping?.price ?: 0.0)
    }
}

class Donut(private val donutSize: DonutSize, private val topping: Topping?) {

    override fun toString(): String {
        return "$donutSize donut with $topping"
    }
}

enum class DonutSize(val price: Double) {
    STANDARD(2.0),
    EXTRA_LARGE(3.5);
}


enum class Topping(val price: Double) {
    CRANBERRY(1.0),
    BLUEBERRY(1.0),
    RASPBERRY(1.0),
    STRAWBERRY(1.0),
    NUTELLA(1.0);
}


fun main() {
    val bakery = Bakery()

    println(bakery.make(
        Order(
            DonutSize.EXTRA_LARGE,
            Topping.NUTELLA
        )
    ))
    println(bakery.make(
        Order(
            DonutSize.STANDARD,
            Topping.BLUEBERRY
        )
    ))
    println(bakery.make(
        Order(
            DonutSize.STANDARD,
            Topping.STRAWBERRY
        )
    ))
    println(bakery.make(
        Order(
            DonutSize.EXTRA_LARGE,
            Topping.RASPBERRY
        )
    ))
    println(bakery.make(
        Order(
            DonutSize.EXTRA_LARGE,
            Topping.CRANBERRY
        )
    ))

    println("Average price")
    println(bakery.getAveragePrice())
}