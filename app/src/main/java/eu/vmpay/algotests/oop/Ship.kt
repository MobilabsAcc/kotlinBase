package eu.vmpay.algotests

import android.annotation.SuppressLint

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

abstract class Person(
    val name: String,
    val surname: String,
    val age: Int
)


interface Announcement {
    fun announcement(): String
}


class Engine(val power: Int, private var status: Boolean = false) : Announcement {
    override fun announcement(): String {
        return "Status has been changed to "
    }

    fun startEngine() {
        status = true
        println(announcement() + "active")
    }

    fun stopEngine() {
        status = false
        println(announcement() + "idle")
    }

    fun getStatus(): String {
        val currentStatus = if (status) "active" else "idle"
        return power.toString() + "kHP engine is now " + currentStatus
    }
}


class Crew(private val occupation: String, name: String, surname: String, age: Int) :
    Person(name, surname, age) {
    @SuppressLint("DefaultLocale")
    fun beCaptain() {
        if (occupation.toLowerCase() == "captain") {
            println("I AM THE CAPTAIN NOW")
        }
    }

    @SuppressLint("DefaultLocale")
    fun beStaff() {
        if (occupation.toLowerCase() == "staff") {
            println("Serving stuff")
        }
    }

    fun getOccupation(): String {
        return occupation
    }

    fun getInfo(): String {
        return "$occupation - $name $surname $age"
    }

}


class Tourist(name: String, surname: String, age: Int) : Person(name, surname, age), Announcement {
    var friendsList = mutableListOf<Tourist>()

    override fun announcement(): String {
        return "Friend has been "
    }

    fun addFriend(friend: Tourist) {
        friendsList.add(friend)
        println(announcement() + "added:)")
    }

    fun removeFriend(friend: Tourist) {
        friendsList.remove(friend)
        println(announcement() + "has been removed :(")
    }

    fun printFriendList() {
        for (item in friendsList) {
            println("""${item.name} ${item.surname}""")
        }
    }
}


class Cabin(var size: Int) {
    var passengersList = mutableListOf<Tourist>()
    var presentPeople = mutableListOf<Tourist>()

    fun addPassenger(passenger: Tourist) {
        if (size > passengersList.size) {
            passengersList.add(passenger)
        } else {
            println("Cabin is full")
        }
    }

    fun removePasseneger(passenger: Tourist) {
        if (passengersList.size != 0) {
            passengersList.remove(passenger)
            println("""${passenger.name} has been removed""")
        }
    }

    fun enterCabin(enterist: Tourist) {
        presentPeople.add(enterist)
        println("""${enterist.name} has entered""")
    }

    fun leaveCabin(leaveist: Tourist) {
        presentPeople.remove(leaveist)
        println("""${leaveist.name} has left""")
    }
}


class Bar(val number:Int){
    var presentList = mutableListOf<Tourist>()


    fun enterBar(passenger: Tourist){
        if(presentList.size >= 50){
            println("Sorry, but bar number $number is fully occupied")
            return
        }
        if(passenger.age < 18){
            println("Sorry, but you are underage mate")
            return
        }
        presentList.add(passenger)
        println("""${passenger.name} has entered the bar number $number""")
    }

    fun leaveBar(passenger: Tourist){
        if(presentList.size != 0){
            presentList.remove(passenger)
            println("""${passenger.name} has left the bar number $number""")
        }
    }
}


class Restaurant(){
    var presentList = mutableListOf<Tourist>()
    var staffList = mutableListOf<Crew>()

    fun addStaff(staff:Crew){
        if(staff.getOccupation() == "Staff"){
            staffList.add(staff)
        }
        else{
            println("Wrong occupation")
        }
    }

    fun enterRestaurant(passenger: Tourist){
        if(presentList.size >= 300){
            println("Sorry, but restaurant is fully occupied")
            return
        }

        presentList.add(passenger)
        println("""${passenger.name} has entered the restaurant""")
    }

    fun leaveRestaurant(passenger: Tourist){
        if(presentList.size != 0){
            presentList.remove(passenger)
            println("""${passenger.name} has left the restaurant""")
        }
    }
}


class Ship(val name:String,val destination:String){

    var passengerList = mutableListOf<Tourist>()
    var crewList = mutableListOf<Crew>()

    val engine1 = Engine(2)
    val engine2 = Engine(4)

    val bar1 = Bar(1)
    val bar2 = Bar(2)

    val restaurant = Restaurant()

    val cabinList = mutableListOf<Cabin>()

    fun addPassenger(passenger: Tourist){
        if(passengerList.size < 300){
            passengerList.add(passenger)
            println("""${passenger.name} ${passenger.surname} has been added""")
        }
        else{
            println("Ship's full")
        }
    }

    fun removePassenger(passenger: Tourist){
        if(passengerList.size != 0 ){
            passengerList.remove(passenger)
            println("""${passenger.name} ${passenger.surname} has been removed""")
        }
    }

    fun printPassengerList(){
        for(item in passengerList){
            println(item.name + " "+ item.surname)
        }
    }

    fun addCrew(crew:Crew){
        if(crewList.size < 50){
            crewList.add(crew)
            println("""${crew.name} ${crew.surname} has been added""")
        }
        else{
            println("Ship's full")
        }
    }

    fun removeCrew(crew:Crew){
        if(crewList.size != 0 ){
            crewList.remove(crew)
            println("""${crew.name} ${crew.surname} has been removed""")
        }
    }

    fun printCrew(){
        for (item in crewList){
            println(item.getInfo())
        }
    }


    fun addCabin(cabin:Cabin){
        cabinList.add(cabin)
        println("Cabin has been added")
    }
}


fun main() {
    val one = Tourist("Kamil", "Brzoz", 12)
    val two = Tourist("Marek", "Brzez", 13)
    one.addFriend(two)
    one.printFriendList()

    val three = Crew("Captain", "Kapitan", "Bomba", 99)
    three.beCaptain()

    val four = Cabin(4)

    val ship = Ship("Black Pearl","World's end")
    ship.addCrew(three)
    ship.addPassenger(one)
    ship.addPassenger(two)
    ship.addCabin(four)

    ship.cabinList[0].addPassenger(one)
    ship.cabinList[0].addPassenger(two)

    ship.bar1.enterBar(ship.passengerList[0])
    ship.restaurant.enterRestaurant(one)
    ship.cabinList[0].enterCabin(two)

    ship.engine1.startEngine()
    ship.engine2.startEngine()
