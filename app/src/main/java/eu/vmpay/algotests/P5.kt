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

interface Sellable{
    var name: String
    var priceZlotowki: Int
    var priceGrosze: Int
}

data class Topping(override var name: String,
                   override var priceGrosze: Int,
                    override var priceZlotowki: Int): Sellable

data class TypeOfDonut(override var name: String,
                       override var priceGrosze: Int,
                       override var priceZlotowki: Int): Sellable

data class Donut(var typeOfDonut: TypeOfDonut, var toppings: List<Topping>)

class Bakery{
    private val orderList: MutableList<Donut> = mutableListOf()
    fun order(typeOfDonut: TypeOfDonut, toppings: List<Topping>): Donut{
        println("You bought a donut")
        return Donut(typeOfDonut, toppings)
    }
}

//Made by Mateusz Wasilewski, Karol Puchała, Marcin Rogalski