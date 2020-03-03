package eu.vmpay.algotests

import junit.framework.Assert.assertTrue
import org.junit.Assert.assertFalse
import org.junit.Test

class PersonTest {

    @Test
    fun enterRoom() {
        val room = Cabin(CabinCapacity.TWO)
        val person = Tourist("test", 18)
        assertTrue(person.enterRoom(room))
        assertTrue(room.visitor.contains(person))
        assertTrue(person.currentRoom == room)
    }

    @Test
    fun enterRoomFail() {
        val room1 = Cabin(CabinCapacity.TWO)
        val room2 = Cabin(CabinCapacity.FOUR)
        val person = Tourist("test", 18)
        assertTrue(person.enterRoom(room1))
        assertTrue(person.currentRoom == room1)
        assertFalse(person.enterRoom(room2))
        assertTrue(person.currentRoom == room1)
    }

    @Test
    fun leaveRoom() {
        val room1 = Cabin(CabinCapacity.FOUR)
        val person = Tourist("test", 18)
        person.enterRoom(room1)
        assertTrue(person.leaveRoom(room1))
    }

    @Test
    fun leaveRoomFail() {
        val room1 = Cabin(CabinCapacity.FOUR)
        val person = Tourist("test", 18)
        person.enterRoom(room1)
        assertTrue(person.leaveRoom(room1))
        assertFalse(person.leaveRoom(room1))
    }
}