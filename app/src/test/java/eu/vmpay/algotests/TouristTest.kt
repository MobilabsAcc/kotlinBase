package eu.vmpay.algotests

import org.junit.Test

import org.junit.Assert.*

class TouristTest {

    @Test
    fun addFriend() {
        val tourist1 = Tourist("aaa", "bbb", 18, null ,null)
        val tourist2 = Tourist("aab", "bab", 18, null, null)
        assertTrue(tourist1.addFriend(tourist2))
        assertFalse(tourist1.addFriend(tourist2))
    }
}