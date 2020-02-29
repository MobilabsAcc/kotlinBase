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

fun main(){
    var ship = Ship(350, 50)

    var tourist1 = Tourist("Kasia", "Kowalczyk", 20)
    var tourist2 = Tourist("Asia", "Basia", 12)
    var tourist3 = Tourist("A", "B", 32)

    var crew1 = MemberOfCrew("AisaK", "Kyzclawok", 42, Crew.CAPTAIN)
    var crew2 = MemberOfCrew("Aisa", "Kyzclawok", 22, Crew.ORDINARY_EMPOLOYEE)

    ship.takeCrew(crew1) ; ship.takeCrew(crew2)

    ship.takeTourists(tourist1) ; ship.takeTourists(tourist2) ; ship.takeTourists(tourist3)

    var cabin1 = Cabin(Capacity.BIG)
    var cabin2 = Cabin(Capacity.SMALL)
    var cabin3 = Cabin(Capacity.BIG)

    var restaurant = Restaurant(300)
    var bar1 = Bar(50, 18)
    var bar2 = Bar(50, 18)


    println(tourist1)
    tourist1.goSomewhere(restaurant)
    tourist1.whatImDoing()

    println(tourist2)
    tourist2.goSomewhere(bar1)
    tourist2.whatImDoing()
    tourist2.goToRoom()
    tourist2.whatImDoing()

    println(tourist3)
    tourist3.goSomewhere(bar1)
    tourist3.whatImDoing()

    tourist1.bookRoom(cabin2)
    tourist2.bookRoom(cabin2)
    tourist3.bookRoom(cabin2)

    println(crew1)
    crew1.turnOnEngine(ship.getEngine1())
    crew1.turnOffEngine(ship.getEngine1())

    println(crew2)
    crew2.turnOnEngine(ship.getEngine2())
    crew2.turnOffEngine(ship.getEngine2())


}

class Bar(capacity: Int, var ageLimit: Int) : Restaurant(capacity){

    override fun takeASeat(tourist: Tourist) : Boolean = if (tourist.age < ageLimit) {
        println("${tourist.name} Youre under $ageLimit. You cannot go to bars")
        false
    } else super.takeASeat(tourist)

    override fun whereAmI(): String {
        return "Bar"
    }
}

open class Restaurant(var capacity: Int){

    private var guestsList = ArrayList<Tourist>()

    private fun hasFreeTables() : Boolean{
        return guestsList.size < capacity
    }

    open fun takeASeat(tourist: Tourist) : Boolean = if (hasFreeTables())    {
        guestsList.add(tourist)
        println("${tourist.name} Please, take a seat")
        true
    } else                    {
        println("${tourist.name} There is no seats")
        false
    }

    open fun leave(tourist: Tourist){
        guestsList.remove(tourist)
    }

    open fun whereAmI(): String{
        return "Restaurant"
    }

}

enum class Capacity(var howManyBeds: Int){
    SMALL(2),
    BIG(4)
}

class Cabin(var capacity: Capacity){
    var list = ArrayList<Tourist>()

    private fun hasFreeBed(): Boolean{
        return list.size < capacity.howManyBeds
    }

    fun makeABook(tourist: Tourist){
        if(hasFreeBed()){
            list.add(tourist)
            println("${tourist.name} This is your new cabin")
        }
        else
            println("${tourist.name} There is no free beds")
    }
}


abstract class Person(var name: String, var surname: String, var age: Int){

    override fun toString(): String {
        return "My name is $name $surname, Im $age. Im "
    }
}

class MemberOfCrew(name: String, surname: String, age: Int,var crew: Crew) : Person(name, surname, age){


    override fun toString(): String {
        return super.toString() + "working here as a $crew"
    }

    fun turnOnEngine(engine: Engine){

        if(crew.equals(Crew.CAPTAIN))   engine.turnOn()
        else                            println("You dont have permission")

    }

    fun turnOffEngine(engine: Engine){

        if(crew.equals(Crew.CAPTAIN))   engine.turnOff()
        else                            println("You dont have permission")
    }

}

class Tourist(name: String, surname: String, age: Int) : Person(name, surname, age){

    private var action = "$name: Im doing nothing"

    private var currentPosition : Restaurant? = null

    fun goSomewhere(restaurant: Restaurant){

        currentPosition?.leave(this)

        action = if(restaurant.takeASeat(this))
            "$name: Im at the " + restaurant.whereAmI()
        else
            "$name: Im doing nothing"
    }

    fun goToRoom(){

        currentPosition?.leave(this)

        action = "$name: Im at the cabin"
    }

    fun whatImDoing(){
        println(action)
    }

    fun bookRoom(cabin: Cabin){
        cabin.makeABook(this)
    }

    override fun toString(): String {
        return super.toString() + "here for fun"
    }
}


enum class Crew{
    ORDINARY_EMPOLOYEE,
    CAPTAIN
}

class Ship(var capacityOfTourist: Int, var capacityOfCrew: Int){

    private var listOfCrew = ArrayList<MemberOfCrew>()
    private var listOfTourist = ArrayList<Tourist>()

    private var engineOne : Engine? = null
    private var engineTwo : Engine? = null

    init {
        println("Ship has started the journey")
         engineOne = Engine(2.0)
         engineTwo = Engine(4.0)

    }

    fun takeTourists(tourist: Tourist){
        if (listOfTourist.size < capacityOfTourist) listOfTourist.add(tourist)
        else                                        println("Sorry, ship is full")
    }

    fun takeCrew(crew: MemberOfCrew){
        if (listOfCrew.size < capacityOfCrew)       listOfCrew.add(crew)
        else                                        println("Sorry, ship is full")
    }

    fun getEngine1(): Engine{
        return engineOne as Engine
    }

    fun getEngine2(): Engine{
        return engineTwo as Engine
    }
}

class Engine(){

    var power = 0.0
    var working = false

    constructor(pow: Double) : this() {
       power = pow
    }

    fun isWorking() : Boolean{
        return working
    }

    fun turnOn(){
        if (working)    println("Engine is working already")
        else{
            working = true
            println("Engine is turned on")
        }

    }

    fun turnOff(){

        if(!working)    println("Engine is turned off already")
        else            {
            working = false
            println("Engine is turned off")
        }
    }

    override fun toString(): String {
        return "Engine: power=$power kHP"
    }


}