package eu.vmpay.algotests

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


class Bakery(var numberOfDonuts: Int) {
    val orders = mutableListOf<Order>()

    fun makeOrder(donut: Donut, time: String): String {
        if (numberOfDonuts == 0)
            return "Out of donuts"
        orders.add(Order(donut, time))
        numberOfDonuts--

        return "Have a nice day"
    }

    fun showOrders() {
        for (i in 0..orders.lastIndex)
            println(orders[i].price.toString() + orders[i].time)
    }
}

class Donut(val size: SizeOfDonut, val toppings: List<Topping>) {}

class Order(donut: Donut, val time: String) {
    val price = donut.size.price + donut.toppings.sumByDouble { it.price }
}


enum class SizeOfDonut(val price: Double) {
    standard(2.0),
    extraLarge(3.5),
}

enum class Topping(val price: Double) {
    cranberry(1.0),
    blueberry(1.0),
    raspberry(1.0),
    strawberry(1.0),
    jam(1.0),
    nutella(2.0),
}
