package eu.vmpay.algotests

import eu.vmpay.algotests.Cabin as Cabin

/**
 * Challenge 2 - The cruise ship
 *
 * Four hundred people were traveling on a cruise ship with two engines having power of: 2kHP, 4kHP.
 * Fifty people represented the ship crew while others were tourists. The ship could have both engines
 * operating simultaneously, only one at a time or keep both off depending on the captain command.
 * Every tourist was assigned to a two or four person cabin shared with our tourists, which could be
 * his friends. The ship had a restaurant and a two bars of 300, 50 ,50 people capacity correspondingly.
 * Each tourist could visit one of the attractions or stay and his cabin at a time. Tourists under
 * 18 years were not allowed to enter the bar.
 *
 * Goal: implement the ship, engine, person, restaurant, bar, cabin classes reflecting the above case.
 */

fun main() {
    val captain = Captain(60)
    val touristA = Tourist(14)
    val touristB = Tourist(20)
    val people = mutableListOf<Person>(Crew(42), Crew(25),Crew(65),Crew(54),Crew(32), touristA, touristB)
    val engineA = Engine(2000)
    val engineB = Engine(4000)
    val restaurant = Restaurant("restaurant")
    val barA = Bar("barA")
    val barB = Bar("barB")
    val cabinA = TwoPersonCabin("CabinA")
    val cabinB = FourPersonCabin("CabinB")
    val cabins = mutableListOf<Cabin>()
    val ship = Ship(people, listOf(engineA, engineB), restaurant, barA, barB, cabins)

    captain.turnOnEngine(engineA, ship)
    println(ship.currentPower)

    touristA.goToCabin(cabinA)
    touristB.goToCabin(cabinB)

    println(touristA.currentPlace!!.name)
    println(touristB.currentPlace!!.name)

}

class Engine(var power: Int) {
    var isTurnedOn: Boolean = false

    fun turnOn(): Int {
        return power
    }

    fun turnOff(): Int {
        return -power
    }
}

abstract class Person(val age: Int)

class Tourist(age: Int) : Person(age) {
    var currentPlace: Place? = null

    fun goToBar(bar: Bar) {
        if (age >= 18 && bar.currentNumberOfPeople < bar.capacity) {
            currentPlace = bar
            bar.currentNumberOfPeople++
        } else
            println("cannot enter $bar")
    }

    fun goToRestaurant(restaurant: Restaurant) {
        if (restaurant.currentNumberOfPeople < restaurant.capacity) {
            currentPlace = restaurant
            restaurant.currentNumberOfPeople++
        } else
            println("cannot enter $restaurant")
    }

    fun goToCabin(cabin: Cabin) {
        if (cabin.currentNumberOfPeople < cabin.capacity) {
            currentPlace = cabin
            cabin.currentNumberOfPeople++
        } else
            println("cannot enter $cabin")
    }
}

class Crew(age: Int) : Person(age) {

}

class Captain(age: Int) : Person(age) {
    fun turnOnEngine(engine: Engine, ship: Ship) {
        if (!engine.isTurnedOn) {
            engine.isTurnedOn = true
            ship.currentPower += engine.turnOn()
        }
    }

    fun turnOffEngine(engine: Engine, ship: Ship) {
        if (engine.isTurnedOn) {
            engine.isTurnedOn = false
            ship.currentPower += engine.turnOff()
        }
    }
}

abstract class Place(val name: String) {
    abstract val capacity: Int
    abstract var currentNumberOfPeople: Int
}

abstract class Cabin(name: String) : Place(name)

class Ship(
    val people: List<Person>,
    val engine: List<Engine>,
    val restaurant: Restaurant,
    val barA: Bar,
    val barB: Bar,
    val cabins: List<Cabin>
) {
    var currentPower: Int = 0
}

class Restaurant(name: String) : Place(name) {
    override val capacity: Int = 300
    override var currentNumberOfPeople = 0
}

class Bar(name: String) : Place(name) {
    override val capacity: Int = 50
    override var currentNumberOfPeople = 0
}

class TwoPersonCabin(name: String) : Cabin(name) {
    override val capacity: Int = 2
    override var currentNumberOfPeople = 0
}

class FourPersonCabin(name: String) : Cabin(name) {
    override val capacity: Int = 4
    override var currentNumberOfPeople = 0

}