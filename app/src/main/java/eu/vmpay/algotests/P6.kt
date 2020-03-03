package eu.vmpay.algotests

import kotlin.random.Random

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
const val TOTAL_CAPACITY = 400
const val CREW_CAPACITY = 50

data class Engine(
        val power: Int,
        var isLaunched: Boolean = false
) {
    fun start() {
        isLaunched = true
    }

    fun stop() {
        isLaunched = false
    }
}

class Ship {
    private val engineA = Engine(2)
    private val engineB = Engine(4)
    private val barA: Bar = Bar()
    private val barB: Bar = Bar()
    private val restaurant = Restaurant()
    private val cabins: List<Cabin>
    private val crew: List<CrewMember>
    private val guests: List<Tourist>

    init {
        // Build the ship
        var totalCapacity = 0
        val cabinList = mutableListOf<Cabin>()
        while (totalCapacity < TOTAL_CAPACITY) {
            cabinList.add(Cabin(if (Random.nextInt(2) == 0) 2 else 4).also { totalCapacity += it.capacity })
        }
        cabins = cabinList
        println("${cabins.size} cabins set up")

        // Recruit the crew
        val candidates = mutableListOf<CrewMember>()
        repeat(CREW_CAPACITY) { candidates.add(CrewMember(it.toLong())) }
        crew = candidates
        println("${crew.size} crew members recruited")

        // Invite guests
        val tourists = mutableListOf<Tourist>()
        for (id in CREW_CAPACITY until TOTAL_CAPACITY) {
            val guest = Tourist(id.toLong(), Random.nextInt(1, 99))
            tourists.add(guest)
            if (!guest.goToPlace(barA) || !guest.goToPlace(barB) || !guest.goToPlace(restaurant)) {
                cabins.firstOrNull { !it.isFull() }?.run { guest.goToPlace(this) }
            }
        }
        guests = tourists
        println("${guests.size} guests invited")
    }

    fun setEnginePower(enginePower: EnginePower) {
        println("Set engine power ${enginePower.name}")
        when (enginePower) {
            EnginePower.MAX -> {
                engineA.start()
                engineB.start()
            }
            EnginePower.HIGH -> {
                engineA.stop()
                engineB.start()
            }
            EnginePower.LOW -> {
                engineA.start()
                engineB.stop()
            }
            EnginePower.ZERO -> {
                engineA.stop()
                engineB.stop()
            }
        }
    }

    fun getEnginePowerConsumption(): Int {
        val engineA = if (engineA.isLaunched) engineA.power else 0
        val engineB = if (engineB.isLaunched) engineB.power else 0
        return engineA + engineB
    }
}

enum class EnginePower {
    MAX,
    HIGH,
    LOW,
    ZERO
}

abstract class Person {
    abstract val id: Long
}

class Tourist(
        override val id: Long,
        val age: Int,
        var currentPlace: Place? = null
) : Person() {

    fun goToPlace(place: Place): Boolean {
        return if (place.enter(this)) {
            currentPlace = place
            true
        } else {
            false
        }
    }
}

class CrewMember(override val id: Long) : Person()

abstract class Place {
    abstract val capacity: Int
    abstract val isUnder18Allowed: Boolean
    abstract val guests: MutableList<Person>

    fun enter(tourist: Tourist): Boolean {
        return if (guests.size < capacity) {
            if (isUnder18Allowed || (!isUnder18Allowed && tourist.age > 17)) {
                guests.add(tourist)
                true
            } else {
                false
            }
        } else {
            false
        }
    }

    fun isFull() = capacity >= guests.size
}

class Bar : Place() {
    override val capacity: Int = 50
    override val isUnder18Allowed: Boolean = false
    override val guests: MutableList<Person> = mutableListOf()
}

class Restaurant : Place() {
    override val capacity: Int = 300
    override val isUnder18Allowed: Boolean = true
    override val guests: MutableList<Person> = mutableListOf()
}

class Cabin(override val capacity: Int) : Place() {
    override val isUnder18Allowed: Boolean = true
    override val guests: MutableList<Person> = mutableListOf()
}
