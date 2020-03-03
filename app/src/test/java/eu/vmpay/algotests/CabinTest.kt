package eu.vmpay.algotests

import org.junit.Test

import org.junit.Assert.*

class CabinTest {

    @Test
    fun addMember() {
        val cabin = Cabin("Kabina jezioro", 2)
        val tourist1 = Tourist("Eryk", "Marek", 22)
        val tourist2 = Tourist("Franek", "Miazga", 15)
        val tourist3 = Tourist("Janek", "Jankowski", 15)
        cabin.addMember(tourist1)
        cabin.addMember(tourist2)
        cabin.addMember(tourist3)
        assertEquals(mutableListOf(tourist1, tourist2), cabin.getMembers())
    }

    @Test
    fun removeMember() {
        val cabin = Cabin("Kabina jezioro", 3)
        val tourist1 = Tourist("Eryk", "Marek", 22)
        val tourist2 = Tourist("Franek", "Miazga", 15)
        cabin.addMember(tourist1)
        cabin.addMember(tourist2)
        cabin.removeMember(tourist1)
        assertEquals(mutableListOf(tourist2), cabin.getMembers())
    }

    @Test
    fun showMembers() {
    }
}