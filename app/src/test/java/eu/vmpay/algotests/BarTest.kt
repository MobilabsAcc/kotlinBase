package eu.vmpay.algotests

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class BarTest {

    @Test
    fun enter() {
        val bar = Bar()
        val adult = Tourist("test", 19)
        assertTrue(adult.enterRoom(bar))
    }

    @Test
    fun enterFail() {
        val bar = Bar()
        val kid = Tourist("test", 17)
        assertFalse(kid.enterRoom(bar))
    }
}