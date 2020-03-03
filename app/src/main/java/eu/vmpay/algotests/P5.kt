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
class Bakery{
     val name="piekarnia"
}
enum class Topping(val price: Double){
    EMPTY( 0.0),
    truskawkowy(3.0),
    jagodowy(2.0)
}
enum class Donutsize(val price: Double){
    duzy(3.0),
    maly(1.0)
}

class Order(val topping: Topping, val donutsize: Donutsize){
    fun getPrice()= donutsize.price+topping.price
}
class Donut(topping: Topping, donutsize: Donutsize){
    val size=donutsize
    val top=topping
}
