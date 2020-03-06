package eu.vmpay.algotests.oop.Ship

import java.lang.Exception

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


class Ship() {
    val engines = listOf(
        Engine.smallerEngine,
        Engine.biggerEngine
    )
    val Crew = arrayOfNulls<shipCrewPerson>(50)
    val tourists = arrayOfNulls<Person>(350)
    val places = listOf(
        Place.Bar,
        Place.Bar, listOf<Place>())
}

enum class Engine(val power: Int) {
    biggerEngine(2),
    smallerEngine(4);

    var work: Boolean = false
}

enum class Place(var capacity: Int) {
    smallerCabin(2),
    biggerCabin(4),
    Bar(50),
    Restaurant(300);

    val people = mutableListOf<Tourist>()

}

open class Person(val name: String, val surname: String) {}

class shipCrewPerson(name: String, surname: String, val salary: Int) : Person(name, surname) {}

class Captain(name: String, surname: String, val ship: Ship) : Person(name, surname) {
    fun work(work: Boolean) {
        ship.engines.map { it.work = work }
    }
}

class Tourist(name: String, surname: String, val age: Int, val currentPlace: Place? = null) : Person(name, surname) {
    val friends = mutableListOf<Person>()

    fun addFriend(tourist: Tourist) {
        friends.add(tourist)
    }

    fun removeFriend(tourist: Tourist) {
        friends.remove(tourist)

    }

    fun move(from: Place, to: Place) {
        if (currentPlace != null)
            leavePlace(from)
        enterPlace(to)
    }

    fun enterPlace(place: Place) {
        if (place.capacity == 0)
            throw Exception("this place is full, nobody can enter here")

        if (place == Place.Bar && age < 18)
            throw Exception("you can't entered here")
        place.capacity--
    }

    fun leavePlace(place: Place) {
        place.capacity++
    }

}