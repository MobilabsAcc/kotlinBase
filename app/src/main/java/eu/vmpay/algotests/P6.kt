package eu.vmpay.algotests



import java.lang.Exception
import java.lang.RuntimeException
import java.util.*

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


class Ship(){
    val engines = listOf(Engine.smallerEngine,Engine.biggerEngine)
    val Crew = arrayOfNulls<shipCrewPerson>(50)
    val tourists = arrayOfNulls<Person>(350)
    val places = listOf(Place.Bar,Place.Bar, listOf<Place>())
}

enum class Engine(val power:Int){
    biggerEngine(2),
    smallerEngine(4);
    var work: Boolean = false
}

enum class Place(var capacity :Int){
    smallerCarbin(2),
    biggerCabin(4),
    Bar(50),
    Restaurant(300);
    val people = mutableListOf<Tourist>()

    fun enterPlace(tourist: Tourist) {
        if( capacity == 0)
            throw Exception("this place is full, nobody can enter here")

        if (this == Bar && tourist.age < 18)
            throw Exception("this tourist is not allowed to enter this attraction")
        capacity--
    }
    fun leavePlace(tourist: Tourist){
        people.remove(tourist)
        capacity++
    }
}
open class Person(val name: String, val surname:String){}

class shipCrewPerson(name: String, surname:String, val salary:Int): Person(name,surname){}

class Captain(name: String, surname:String, val ship: Ship): Person(name,surname) {
    fun work(work: Boolean){
        ship.engines.map { it.work = work }
    }
}

class Tourist(name: String, surname:String, val age: Int, frineds: List<Tourist>, var currentPlace: String = ""): Person(name,surname){}