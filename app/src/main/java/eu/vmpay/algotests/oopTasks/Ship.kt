package eu.vmpay.algotests.oopTasks

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
    val crewMembers = arrayOfNulls<Crew>(50)
    val captain = Captain("", "", 40, true)
    val tourist = arrayOfNulls<Tourist>(350)
    val places = listOf<Place>(
        Place.BAR,
        Place.BIGGERROOM,
        Place.RESTAURANT,
        Place.SMALLERROOM
    )
}

enum class Engine(val power: Int) {
    MAXPOWER(4),
    MINPOWER(2);
}

enum class Place(var capacity: Int) {
    RESTAURANT(300),
    BAR(50),
    BIGGERROOM(4),
    SMALLERROOM(2);
}

abstract class Person(
    val firstName: String,
    val lastName: String,
    val age: Int,
    val isCrew: Boolean
) {
}

class Crew(firstName: String, lastName: String, age: Int, isCrew: Boolean = true) :
    Person(firstName, lastName, age, isCrew) {
}

class Captain(firstName: String, lastName: String, age: Int, isCrew: Boolean) :
    Person(firstName, lastName, age, isCrew) {
    var isWorking = false

    fun turnOnEngine(type: Engine) {
        isWorking = true
    }

    fun shutDownEngine(type: Engine) {
        isWorking = false
    }
}

class Tourist(firstName: String, lastName: String, age: Int, val currentPlace: Place) :
    Person(firstName, lastName, age, isCrew = false) {
    private val friends = mutableListOf<Person>()

    fun makeFriend(person: Tourist) {
        friends.add(person)
    }

    fun removeFriend(person: Tourist) {
        friends.remove(person)
    }

    fun enterNewPlace(place: Place) {
        if (place.capacity == 0) {
            println("This place is full")
        } else {
            if (place == Place.BAR && age < 18) {
                println("You have to at least 18 years old to enter the bar")
            }
        }
        place.capacity++
    }

    fun leavePlace(place: Place) {
        place.capacity++
    }

    fun changePlaces(from: Place, to: Place) {
        leavePlace(from)
        enterNewPlace(to)
    }

}