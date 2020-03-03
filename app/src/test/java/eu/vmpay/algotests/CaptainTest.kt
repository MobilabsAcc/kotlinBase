package eu.vmpay.algotests

import org.junit.Test

import org.junit.Assert.*

class CaptainTest {

    @Test
    fun turnOnEngine() {
        val captain = Captain(18)
        val engine = Engine(2000)
        val restaurant = Restaurant("a")
        val barA = Bar("b")
        val barB = Bar("a")
        val ship = Ship(listOf(), listOf(engine), restaurant, barA, barB ,listOf())
        assertEquals(0, ship.currentPower)
        captain.turnOnEngine(engine, ship)
        assertEquals(2000,ship.currentPower)
        captain.turnOnEngine(engine, ship)
        assertEquals(2000,ship.currentPower)
    }

    @Test
    fun turnOffEngine() {
        val captain = Captain(18)
        val engine = Engine(2000)
        val restaurant = Restaurant("a")
        val barA = Bar("b")
        val barB = Bar("a")
        val ship = Ship(listOf(), listOf(engine), restaurant, barA, barB ,listOf())
        ship.currentPower = 3000
        engine.isTurnedOn = true
        captain.turnOffEngine(engine, ship)
        assertEquals(1000, ship.currentPower)
        captain.turnOffEngine(engine, ship)
        assertEquals(1000, ship.currentPower)
    }
}