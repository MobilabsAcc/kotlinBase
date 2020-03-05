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

    class Engine(val power: Double, var isWorking: Boolean = false) {
        fun changeWorkingMode()  {
            isWorking = isWorking.not()
        }
    }

    abstract class Person(val name: String, val surname: String)

    class Tourist(
        name: String,
        surname: String,
        var age: Int,
        var currentLocation: String?,
        var assignedCabin: Cabin?
    ) : Person(name, surname) {
        var friends = mutableListOf<Tourist>()
        fun addFriend(tourist: Tourist): Boolean {
            if (friends.contains(tourist))
                return false
            friends.add(tourist)
            return true
        }
    }

    class Crew(name: String, surname: String, var role: String) : Person(name, surname)

    abstract class Attraction(val name: String, val capacity: Int, var currentOccupation: Int)

    interface UseAttraction {
        fun visit(tourist: Tourist): Boolean
    }

    class Bar(name: String, capacity: Int = 50, currentOccupation: Int = 0) :
        Attraction(name, capacity, currentOccupation), UseAttraction {
        override fun visit(tourist: Tourist): Boolean {
            if (tourist.age < 18 || currentOccupation >= capacity)
                return false
            currentOccupation++
            tourist.currentLocation = name
            return true
        }
    }

    class Restaurant(name: String, capacity: Int = 300, currentOccupation: Int = 0) :
        Attraction(name, capacity, currentOccupation), UseAttraction {
        override fun visit(tourist: Tourist): Boolean {
            if (currentOccupation >= capacity)
                return false
            currentOccupation++
            tourist.currentLocation = name
            return true
        }
    }

    class Cabin(val size: Int, val cabinId: String) {
        var assignedTourists = mutableListOf<Tourist>()
        fun assignTourist(tourist: Tourist): Boolean {
            if (tourist.assignedCabin == null && assignedTourists.size < size) {
                tourist.assignedCabin = this
                assignedTourists.add(tourist)
                return true
            }
            return false
        }

        fun stay(tourist: Tourist) {
            tourist.currentLocation = cabinId
        }
    }

    class Ship(val touristCapacity: Int = 350, var sizeOfCrew: Int = 50) {
        var tourists = mutableListOf<Tourist>()
        var crew = mutableListOf<Crew>()
        val cabins = mutableListOf<Cabin>()
        val engines = listOf(Engine(2.0), Engine(4.0))
        var bars = mutableListOf<Bar>()
        var restaurants = mutableListOf<Restaurant>()

        fun changeEngineMode(crew: Crew, engine: Engine): Boolean {
            if (crew.role != "Captain")
                return false
            engine.changeWorkingMode()
            return true
        }

        fun boardTourist(tourist: Tourist): Boolean {
            if (tourists.size >= touristCapacity)
                return false
            tourists.add(tourist)
            return true
        }

        fun boardCrew(crew: Crew): Boolean {
            if (this.crew.size >= sizeOfCrew)
                return false
            this.crew.add(crew)
            return true
        }
    }
