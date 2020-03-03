package eu.vmpay.algotests

import org.junit.Test

import org.junit.Assert.*

class CabinTest {

    @Test
    fun assignTourist() {
        val cabin = Cabin(2, "a1")
        val tourist1 = Tourist("aaa", "bbb", 19, null ,null)
        val tourist2 = Tourist("aab", "bab", 14, null, null)
        cabin.assignTourist(tourist2)
        assertTrue(cabin.assignTourist(tourist1))
        assertFalse(cabin.assignTourist(tourist2))
    }

    @Test
    fun stay() {
        val cabin = Cabin(2, "a1")
        val tourist1 = Tourist("aaa", "bbb", 19, null ,null)
        cabin.stay(tourist1)
        assertEquals(cabin.cabinId, tourist1.currentLocation)
    }
}