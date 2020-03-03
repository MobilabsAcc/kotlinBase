package eu.vmpay.algotests

import org.junit.Test

import org.junit.Assert.*

class ShipTest {

    @Test
    fun changeEngineMode() {
        val ship = Ship()
        val crew1 = Crew("aa", "bbb", "Captain")
        val crew2 = Crew("awe", "dg", "kf")
        assertTrue(ship.changeEngineMode(crew1, ship.engines[0]))
        assertFalse(ship.changeEngineMode(crew2, ship.engines[0]))

    }

    @Test
    fun boardTourist() {
        val ship = Ship(1)
        val tourist1 = Tourist("aaa", "bbb", 19, null ,null)
        val tourist2 = Tourist("aab", "bab", 14, null, null)
        assertTrue(ship.boardTourist(tourist1))
        assertFalse(ship.boardTourist(tourist2))
    }

    @Test
    fun boardCrew() {
        val ship = Ship(2,1)
        val crew1 = Crew("aa", "bbb", "Captain")
        val crew2 = Crew("awe", "dg", "kf")
        assertTrue(ship.boardCrew(crew1))
        assertFalse(ship.boardCrew(crew2))
    }
}