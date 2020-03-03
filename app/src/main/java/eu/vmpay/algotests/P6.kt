package eu.vmpay.algotests

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

class Ship {

    val engines = listOf(Engine(2), Engine(4))
    val rooms = mutableListOf(Restaurant(), Bar(), Bar(),
        Cabin(CabinCapacity.FOUR), Cabin(CabinCapacity.FOUR), Cabin(CabinCapacity.TWO),
        Cabin(CabinCapacity.TWO), Cabin(CabinCapacity.TWO), Cabin(CabinCapacity.TWO))

    val people = mutableListOf<Person>()


    fun startEngine(engineIdx: Int): Boolean {
        if (engineIdx !in engines.indices) {
            println("Error. No such engine.")
            return false
        }
        engines[engineIdx].start()
        println("Engine $engineIdx started.")
        return true
    }

    fun stopEngine(engineIdx: Int): Boolean {
        if (engineIdx !in engines.indices) {
            println("Error. No such engine.")
            return false
        }
        engines[engineIdx].stop()
        println("Engine $engineIdx stopped.")
        return true
    }

    fun addPerson(person: Person) {
        people.add(person)
    }

    fun addPeople(newPeople: List<Person>) {
        people.addAll(newPeople)
    }
}

data class Engine(val power: Int) {
    var isRunning = false
        private set

    fun start() {
        isRunning = true
    }

    fun stop() {
        isRunning = false
    }
}

abstract class Room(val capacity: Int) {

    val visitor = mutableListOf<Person>()

    open fun enter(person: Person): Boolean {
        return if (visitor.size == capacity) {
            println("${person.name} cannot enter this room, because it's full.")
            false
        } else {
            visitor.add(person)
            true
        }
    }

    fun leave(person: Person) {
        visitor.remove(person)
    }

    override fun equals(other: Any?): Boolean {
        return capacity == (other as Room).capacity
    }
}

abstract class Person(val name: String, val age: Int) {
    var currentRoom: Room? = null

    fun enterRoom(room: Room): Boolean {
        var result = false
        if (currentRoom == null) {
            result = room.enter(this)
            currentRoom = room
        } else {
            println("$name cannot enter this room, because they are already in a different room. Please leave first.")
        }
        return result
    }

    fun leaveRoom(room: Room): Boolean {
        return if (currentRoom == room) {
            room.leave(this)
            currentRoom = null
            true
        } else {
            println("$name cannot leave this room because they're not in it.")
            false
        }
    }
}

class Tourist(name: String, age: Int) : Person(name, age) {
    val friends = mutableListOf<Tourist>()
    var myCabin: Cabin? = null
    set(value) {
        field = if (value == null) {
            myCabin?.removeResident(this)
            null
        } else {
            value.addResident(this)
            value
        }
    }

    fun addFriend(friend: Tourist) {
        friends.add(friend)
    }

    override fun toString(): String {
        return "$name $age"
    }
}

class CrewMember(name: String, age: Int) : Person(name, age) {

}

class Captain(name: String, age: Int, private val ship: Ship) : Person(name, age) {

    fun startEngine(engineIdx: Int) {
        ship.startEngine(engineIdx)
    }

    fun stopEngine(engineIdx: Int) {
        ship.stopEngine(engineIdx)
    }
}

class Restaurant : Room(300) {

}

class Bar : Room(50) {
    override fun enter(person: Person): Boolean {
        val enter = super.enter(person)
        val age = person.age >= 18
        if (!age) {
            println("${person.name} cannot enter this room, because they're underage.")
        }
        return enter && age
    }
}

class Cabin(cabinCapacity: CabinCapacity) : Room(cabinCapacity.capacity) {
    val residents = mutableListOf<Tourist>()

    fun addResident(tourist: Tourist) {
        if (residents.size < capacity) {
            residents.add(tourist)
        }
    }

    fun removeResident(tourist: Tourist) {
        residents.remove(tourist)
    }
}

enum class CabinCapacity(val capacity: Int) {
    TWO(2),
    FOUR(4)
}

fun main() {
    val ship = Ship()
    val captain = Captain("Kirk", 30, ship)
    ship.addPerson(captain)
    captain.startEngine(0)
    val crew = listOf(CrewMember("Scott", 30),
        CrewMember("Spock", 30), CrewMember("McCoy", 30)
    )
    val tourists = listOf(Tourist("Jones", 50), Tourist("Short Round", 14))
    ship.addPeople(crew)
    ship.addPeople(tourists)
    tourists[0].enterRoom(ship.rooms[1])
    tourists[0].addFriend(tourists[1])
    tourists[1].enterRoom(ship.rooms[2])
    tourists[0].leaveRoom(ship.rooms[1])
    tourists[0].myCabin = ship.rooms[3] as Cabin
    tourists[1].myCabin = ship.rooms[3] as Cabin
    println((ship.rooms[3] as Cabin).residents)
}