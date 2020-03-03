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

class Engine constructor(val power: Int, private var isWorking: Boolean = false){

    fun start(){
        isWorking = true
    }

    fun stop(){
        isWorking = false
    }

    fun getIsWorking(): Boolean{
        return isWorking
    }


}

abstract class Person(val name:String, val lastName: String, val age: Int)

class Tourist (name:String,lastName: String, age: Int): Person(name, lastName, age){

    private var friends = mutableListOf<Tourist>()

    fun getFreinds(): MutableList<Tourist>{
        return friends
    }

    fun addFreind(friend: Tourist){
        friends.add(friend)
    }

    fun removeFreind(friend: Tourist){
        friends.remove(friend)
    }

    fun showFriends(){
        for(element in friends){
            println("Friend: ${element.name} ${element.lastName}, age ${element.age}")
        }
    }

}

class Crew (name:String,lastName: String, age: Int): Person(name, lastName, age)

abstract class Room(val name:String, val capacity: Int){
    abstract fun addMember(person: Person)
    abstract fun removeMember(person: Person)
    abstract fun showMembers()
}

class Restaurant(name:String, capacity: Int): Room(name, capacity){

    private val members = mutableListOf<Person>()

    fun getMembers(): MutableList<Person>{
        return members
    }

    override fun addMember(person: Person){
        if(members.size < capacity) {
            members.add(person)
            println("Person entered")
        }else{
            println("Restaurant is full")
        }
    }

    override fun removeMember(person: Person){
        members.remove(person)
    }

    override fun showMembers(){
        for(element in members){
            println("In bar : ${element.name} ${element.lastName}, age ${element.age}")
        }
    }
}

class Bar(name:String, capacity: Int): Room(name, capacity){

    private val members = mutableListOf<Person>()

    fun getMembers(): MutableList<Person>{
        return members
    }

    override fun addMember(person: Person){
        if(members.size < capacity){
            if(person.age >= 18){
                members.add(person)
                println("Person entered")
            }else{
                println("Person is too young")
            }
        }else{
            println("Bar is full")
        }
    }

    override fun removeMember(person: Person){
        members.remove(person)
    }

    override fun showMembers(){
        for(element in members){
            println("In bar : ${element.name} ${element.lastName}, age ${element.age}")
        }
    }

}

class Cabin(name:String, capacity: Int): Room(name, capacity){

    private val members = mutableListOf<Person>()

    fun getMembers(): MutableList<Person>{
        return members
    }

    override fun addMember(person: Person){
        if(members.size < capacity){
            members.add(person)
            println("Member added to cabin")
        }else{
            println("Cabin is full")
        }
    }

    override fun removeMember(person: Person){
        members.remove(person)
    }

    override fun showMembers(){
        for(element in members){
            println("Melded in cabin: ${element.name} ${element.lastName}, age ${element.age}")
        }
    }

}

class Ship(private val capacityTourist: Int, private val capacityCrew: Int){
    private val tourists = mutableListOf<Tourist>()
    private val crewMembers = mutableListOf<Crew>()
    private val engine1 = Engine(2)
    private val engine2 = Engine(4)
    val bar1 = Bar("Bar1", 50)
    val bar2 = Bar("Bar2", 50)
    val restaurant1 = Restaurant("Restaurant1", 300)
    val cabins = mutableListOf<Cabin>()

    fun getTourists(): MutableList<Tourist>{
        return tourists
    }

    fun getCrewMembers(): MutableList<Crew>{
        return crewMembers
    }

    fun addTourist(tourist: Tourist){
        if(tourists.size < capacityTourist){
            tourists.add(tourist)
            println("Tourist added to ship")
        }else{
            println("Ship is full")
        }
    }

    fun removeToursit(tourist: Tourist){
        tourists.remove(tourist)
    }

    fun showTourists(){
        for(tourist in tourists){
            println("Tourist: ${tourist.name} ${tourist.lastName}, age ${tourist.age}")
        }
    }

    fun addCrew(crew: Crew){
        if(crewMembers.size < capacityCrew){
            crewMembers.add(crew)
            println("Crew member added to ship")
        }else{
            println("Ship is full")
        }
    }

    fun removeCrew(crew: Crew){
        crewMembers.remove(crew)
    }

    fun showCrew(){
        for(crew in crewMembers){
            println("Tourist: ${crew.name} ${crew.lastName}, age ${crew.age}")
        }
    }
}
