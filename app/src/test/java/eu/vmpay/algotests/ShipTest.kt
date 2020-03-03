package eu.vmpay.algotests

import org.junit.Test

import org.junit.Assert.*

class ShipTest {

    @Test
    fun addTourist() {
        val ship = Ship(1, 2)
        val tourist1 = Tourist("Eryk", "Marek", 22)
        val tourist2 = Tourist("Franek", "Miazga", 15)
        ship.addTourist(tourist1)
        ship.addTourist(tourist2)
        assertEquals(mutableListOf(tourist1), ship.getTourists())
    }

    @Test
    fun removeToursit() {
        val ship = Ship(2, 2)
        val tourist1 = Tourist("Eryk", "Marek", 22)
        val tourist2 = Tourist("Franek", "Miazga", 15)
        ship.addTourist(tourist1)
        ship.addTourist(tourist2)
        ship.removeToursit(tourist2)
        assertEquals(mutableListOf(tourist1), ship.getTourists())
    }

    @Test
    fun showTourists() {
    }

    @Test
    fun addCrew() {
        val ship = Ship(1, 2)
        val crew1 = Crew("Eryk", "Marek", 22)
        val crew2 = Crew("Franek", "Miazga", 15)
        ship.addCrew(crew1)
        ship.addCrew(crew2)
        assertEquals(mutableListOf(crew1, crew2), ship.getCrewMembers())
    }

    @Test
    fun removeCrew() {
        val ship = Ship(1, 2)
        val crew1 = Crew("Eryk", "Marek", 22)
        val crew2 = Crew("Franek", "Miazga", 15)
        ship.addCrew(crew1)
        ship.addCrew(crew2)
        ship.removeCrew(crew2)
        assertEquals(mutableListOf(crew1), ship.getCrewMembers())
    }

    @Test
    fun showCrew() {
    }
}