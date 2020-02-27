//Kowalczyk, Stasiak, Jurga

package eu.vmpay.algotests

import java.util.*

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

fun main() {
    var bakery = Bakery("ACC")

    var order = Order(Donut(Type.STANDARD), mutableListOf(Topping.BLUEBERRY, Topping.CRANBERRY, Topping.NUTELLA))

    bakery.makeOrder(Order(Donut(Type.STANDARD), mutableListOf(Topping.BLUEBERRY, Topping.CRANBERRY, Topping.NUTELLA)))
    bakery.makeOrder(Order(Donut(Type.EXTRA_LARGE), mutableListOf(Topping.BLUEBERRY, Topping.CRANBERRY, Topping.NUTELLA)))
    bakery.makeOrder(Order(Donut(Type.STANDARD), mutableListOf(Topping.BLUEBERRY, Topping.CRANBERRY, Topping.NUTELLA)))
    bakery.makeOrder(Order(Donut(Type.STANDARD), mutableListOf(Topping.BLUEBERRY, Topping.CRANBERRY, Topping.NUTELLA)))


    bakery.show()
}

class Bakery(name: String = "Cukiernia bez nazwy"){

    var list = ArrayList<Order>()

    fun makeOrder(order: Order){

        list.add(order)
    }


//    fun avg(): Double{
//
//    }

    fun show(){
     list.forEach { println( it.getPrice()) }
    }

}

enum class Type(val price : Double){
    STANDARD(2.0),
    EXTRA_LARGE(3.5)
}

data class Order(val donut: Donut, val list: List<Topping>){


    fun getPrice() : Double{
        var price = donut.price

        for (i in list){
            price += i.price
        }

        return price
    }

    override fun toString(): String {
        return "Order(donut=$donut, list=$list)"
    }


}

class Donut(){

    var price = 0.0

   constructor( name: Type) : this() {
       if(name == Type.STANDARD) price += Type.STANDARD.price
       else if(name == Type.EXTRA_LARGE) price += Type.EXTRA_LARGE.price

   }

}

enum class Topping(val price: Double){
    CRANBERRY(1.0),
    BLUEBERRY(1.0),
    RASPBERRY(1.0),
    STRAWBERRY_JAM(1.0),
    NUTELLA(1.0)
}