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

class Bakery {

    var amountOrders = 0
    var valueOfOrders = 0.0

    fun makeOrder() : Double {
        val donut = Donut(SizeOfDonut.extraLarge, listOf(Topping.strawberry,Topping.blueberry,Topping.nutella))
        amountOrders++
        valueOfOrders += donut.price
       return donut.price
    }

    fun average() = valueOfOrders / amountOrders

}

class Donut constructor(sizeOfDonut: SizeOfDonut, toppings: List<Topping>){
    val price = sizeOfDonut.price + toppings.sumByDouble { it.price }
}

enum class SizeOfDonut(val price: Double){
    standard(2.0),
    extraLarge(3.5),
}

enum class Topping (val price: Double) {
    cranberry(1.0),
    blueberry(1.0),
    raspberry(1.0),
    strawberry(1.0),
    nutella(2.0),
}