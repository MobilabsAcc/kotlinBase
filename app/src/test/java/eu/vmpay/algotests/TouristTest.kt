package eu.vmpay.algotests

import org.junit.Test

import org.junit.Assert.*

class TouristTest {

    @Test
    fun addFreind() {
        val tourist1 = Tourist("Eryk", "Marek", 22)
        val tourist2 = Tourist("Franek", "Miazga", 23)
        tourist1.addFreind(tourist2)
        assertEquals(mutableListOf(tourist2), tourist1.getFreinds())
    }

    @Test
    fun removeFreind() {
        val tourist1 = Tourist("Eryk", "Marek", 22)
        val tourist2 = Tourist("Franek", "Miazga", 23)
        val tourist3 = Tourist("Franek", "Miazga", 23)
        tourist1.addFreind(tourist2)
        tourist1.addFreind(tourist3)
        tourist1.removeFreind(tourist2)
        assertEquals(mutableListOf(tourist3), tourist1.getFreinds())
    }

    @Test
    fun showFriends() {
    }
}