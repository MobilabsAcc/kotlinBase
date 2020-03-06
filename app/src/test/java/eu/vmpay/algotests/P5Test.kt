package eu.vmpay.algotests

import eu.vmpay.algotests.algorithmictasks.P5
import junit.framework.TestCase.*
import org.junit.Test

class P5Test {

    @Test
    fun areEquallyStrong() {
        assertTrue(P5.areEquallyStrong(10, 15, 15, 10))
        assertTrue(P5.areEquallyStrong(15, 10, 15, 10))
        assertFalse(P5.areEquallyStrong(15, 10, 15, 9))
    }

    @Test
    fun arrayMaximalAdjacentDifference() {
        assertEquals(3, P5.arrayMaximalAdjacentDifference(mutableListOf(2, 4, 1, 0)))
        assertEquals(12, P5.arrayMaximalAdjacentDifference(mutableListOf(-1, 2, -7, 5)))
    }

    @Test
    fun isIPv4Address() {
        assertTrue(P5.isIPv4Address("172.16.254.1"))
        assertFalse(P5.isIPv4Address("172.316.254.1"))
        assertFalse(P5.isIPv4Address(".254.255.0"))
    }

    @Test
    fun avoidObstacles() {

    }

    @Test
    fun boxBlur() {
        assertEquals(
            mutableListOf(mutableListOf(1)),
            P5.boxBlur(
                mutableListOf(
                    mutableListOf(1, 1, 1),
                    mutableListOf(1, 7, 1),
                    mutableListOf(1, 1, 1)
                )
            )
        )
    }

    @Test
    fun minesweeper() {
        assertEquals(
            mutableListOf(mutableListOf(1, 2, 1), mutableListOf(2, 1, 1), mutableListOf(1, 1, 1)),
            P5.minesweeper(
                mutableListOf(
                    mutableListOf(true, false, false),
                    mutableListOf(false, true, false),
                    mutableListOf(false, false, false)
                )
            )
        )
    }

}