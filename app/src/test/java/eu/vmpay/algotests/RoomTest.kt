package eu.vmpay.algotests

import eu.vmpay.algotests.oop.Cabin
import eu.vmpay.algotests.oop.CabinCapacity
import eu.vmpay.algotests.oop.Tourist
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class RoomTest {

    @Test
    fun enter() {
        val room =
            Cabin(CabinCapacity.TWO)
        val person = Tourist("test", 18)
        assertTrue(room.enter(person))
        assertTrue(room.visitor.contains(person))
    }

    @Test
    fun enterFail() {
        val room =
            Cabin(CabinCapacity.TWO)
        val person1 = Tourist("test1", 18)
        val person2 = Tourist("test2", 18)
        val person3 = Tourist("test3", 18)
        assertTrue(room.enter(person1))
        assertTrue(room.enter(person2))
        assertFalse(room.enter(person3))
    }

    @Test
    fun leave() {
        val room =
            Cabin(CabinCapacity.TWO)
        val person = Tourist("test", 18)
        room.enter(person)
        assertTrue(room.visitor.contains(person))
        room.leave(person)
        assertFalse(room.visitor.contains(person))
    }
}