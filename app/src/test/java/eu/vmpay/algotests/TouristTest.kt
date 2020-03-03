package eu.vmpay.algotests

import org.junit.Assert.*
import org.junit.Test

class TouristTest {

    @Test
    fun setMyCabin() {
        val tourist = Tourist("test", 18)
        val cabin = Cabin(CabinCapacity.FOUR)
        tourist.myCabin = cabin
        assertEquals(tourist.myCabin, cabin)
        assertTrue(cabin.residents.contains(tourist))
        tourist.myCabin = null
        assertNull(tourist.myCabin)
        assertFalse(cabin.residents.contains(tourist))

    }

    @Test
    fun addFriend() {
        val tourist = Tourist("test", 18)
        val friend = Tourist("test2", 18)
        tourist.addFriend(friend)
        assertTrue(tourist.friends.contains(friend))
    }

    @Test
    fun testToString() {
        val tourist = Tourist("test", 18)
        assertEquals("test 18", tourist.toString())
    }
}