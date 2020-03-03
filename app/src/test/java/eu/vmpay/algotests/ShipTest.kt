package eu.vmpay.algotests

import org.junit.Assert.*
import org.junit.Test

class ShipTest {

    @Test
    fun getEngines() {
        val ship = Ship()
        assertEquals(ship.engines, listOf(Engine(2), Engine(4)))
    }

    @Test
    fun getRooms() {
        val ship = Ship()
        assertEquals(ship.rooms, mutableListOf(Restaurant(), Bar(), Bar(),
            Cabin(CabinCapacity.FOUR), Cabin(CabinCapacity.FOUR), Cabin(CabinCapacity.TWO),
            Cabin(CabinCapacity.TWO), Cabin(CabinCapacity.TWO), Cabin(CabinCapacity.TWO))
        )
    }

    @Test
    fun startEngine() {
        val ship = Ship()
        assertTrue(ship.startEngine(0))
        assertTrue(ship.startEngine(1))
    }

    @Test
    fun startEngineFail() {
        val ship = Ship()
        assertFalse(ship.startEngine(2))
    }

    @Test
    fun stopEngine() {
        val ship = Ship()
        assertTrue(ship.stopEngine(0))
        assertTrue(ship.stopEngine(1))
    }

    @Test
    fun stopEngineFail() {
        val ship = Ship()
        assertFalse(ship.stopEngine(2))
    }

    @Test
    fun addPerson() {
        val ship = Ship()
        val newPerson = Tourist("test", 18)
        ship.addPerson(newPerson)
        assertEquals(ship.people, listOf(newPerson))
    }

    @Test
    fun addPeople() {
        val ship = Ship()
        val newPerson1 = Tourist("test1", 18)
        val newPerson2 = Tourist("test2", 18)
        ship.addPeople(listOf(newPerson1, newPerson2))
        assertEquals(ship.people, listOf(newPerson1, newPerson2))
    }
}