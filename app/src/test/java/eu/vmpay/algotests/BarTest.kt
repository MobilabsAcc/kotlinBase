package eu.vmpay.algotests

import org.junit.Test

import org.junit.Assert.*

class BarTest {

    @Test
    fun addMember() {
        val bar = Bar("Barek pod 1", 5)
        val tourist1 = Tourist("Eryk", "Marek", 22)
        val tourist2 = Tourist("Franek", "Miazga", 15)
        bar.addMember(tourist1)
        bar.addMember(tourist2)
        assertEquals(mutableListOf(tourist1), bar.getMembers())
    }

    @Test
    fun removeMember() {
        val bar = Bar("Barek pod 1", 5)
        val tourist1 = Tourist("Eryk", "Marek", 22)
        val tourist2 = Tourist("Franek", "Miazga", 20)
        bar.addMember(tourist1)
        bar.addMember(tourist2)
        bar.removeMember(tourist1)
        assertEquals(mutableListOf(tourist2), bar.getMembers())
    }

    @Test
    fun showMembers() {
    }
}