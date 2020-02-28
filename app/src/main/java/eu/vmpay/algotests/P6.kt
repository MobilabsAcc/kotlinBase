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

abstract class Person(val name: String, val surname: String, val age: Int)

class CrewMember(name: String, surname: String, age: Int, var title: String):
        Person(name, surname, age)

class Tourist(name: String, surname: String, age: Int) : Person(name, surname, age){
    var friends = mutableListOf<Tourist>()
}

class Engine(val power: Int){
    private var working = false
    fun switch(value: Boolean){
        if(!working && value){
            run()
        }else if(working && !value){
            stop()
        }else{
            println("Error, i cant do that!")
        }
    }
    private fun run(){
        working = true
    }
    private fun stop(){
        working = false
    }
}

abstract class Room(capacity: Int)

class Cabin(private val capacity: Int): Room(capacity){
    private val guests = mutableListOf<Person>()
    fun book(person: Person){
        if(guests.size < capacity){
            guests.add(person)
            println("Successfully booked")
        }else{
            println("Cabin already booked!")
        }
    }
    fun cancelReservation(person: Person){
        guests.remove(person)
    }
}
class Restaurant(private val capacity: Int): Room(capacity){
    private val guests = mutableListOf<Person>()
    fun enter(person: Person){
        if(guests.size < 300){
            guests.add(person)
            println("Entered")
        }else{
            println("Too many people, cannot enter")
        }
    }
}

class Bar(private val capacity: Int): Room(capacity){
    private val guests = mutableListOf<Person>()
    fun enter(person: Person){
        if(person.age < 18){
            println("You are too young!")
            return
        }
        if(guests.size < capacity){
            guests.add(person)
            println("Entered")
        }else {
            println("Too many people, cannot enter")
        }
    }
}

class Ship(private val touristCapacity: Int, private val crewCapacity: Int){

    private val guests = mutableListOf<Tourist>()
    private val workers = mutableListOf<CrewMember>()
    private val smallerEngine = Engine(2)
    private val biggerEngine = Engine(4)

    fun manageEngine(crewMember: CrewMember, engine: String, power: Boolean){
        if(crewMember.title != "Captain"){
            println("You dont have permission!")
            return
        }

        when{
            engine.equals("smaller") -> smallerEngine.switch(power)
            engine.equals("bigger") -> biggerEngine.switch(power)
            else -> println("Illegal engine name!")
        }
    }
    fun boardAsTourist(tourist: Tourist){
        if(guests.size < touristCapacity){
            guests.add(tourist)
            println("Boarded")
        }else{
            println("Ship's full!")
        }
    }

    fun boardAsWorker(crewMember: CrewMember){
        if(workers.size < crewCapacity){
            workers.add(crewMember)
            println("Boarded")
        }else{
            println("Ship's full!")
        }
    }
}

