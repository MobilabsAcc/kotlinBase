package eu.vmpay.algotests

import org.junit.Test
import junit.framework.Assert.*

class P5Test {

    @Test
    fun areEquallyStrong() {
        assertTrue(P5.areEquallyStrong(2, 3, 3, 2))
        assertTrue(P5.areEquallyStrong(1, 1, 1, 1))
        assertTrue(P5.areEquallyStrong(3,1, 1, 3))
        assertFalse(P5.areEquallyStrong(1,2,4,3))
        assertFalse(P5.areEquallyStrong(1,1,2,2))
        assertFalse(P5.areEquallyStrong(1,1,1,5))
    }

    @Test
    fun arrayMaximalAdjacentDifference() {
        assertEquals(10, P5.arrayMaximalAdjacentDifference(mutableListOf(1,2,3,4,14)))
        assertEquals(0, P5.arrayMaximalAdjacentDifference(mutableListOf(1,1,1,1)))
        assertEquals(0, P5.arrayMaximalAdjacentDifference(mutableListOf(1)))
        assertEquals(1, P5.arrayMaximalAdjacentDifference(mutableListOf(1,2,3,4)))
    }

    @Test
    fun minesweeper() {
        assertEquals(
            mutableListOf(mutableListOf(1,1,1), mutableListOf(1,0,1), mutableListOf(1,1,1)),
            P5.minesweeper(
                mutableListOf(mutableListOf(false, false, false), mutableListOf(false, true, false), mutableListOf(false, false, false))
            ))

        assertEquals(
            mutableListOf(mutableListOf(3,5,3), mutableListOf(5,8,5), mutableListOf(3,5,3)),
            P5.minesweeper(
                mutableListOf(mutableListOf(true, true, true),
                              mutableListOf(true, true, true),
                              mutableListOf(true, true, true))
            ))

        assertEquals(
            mutableListOf(mutableListOf(2,4,2), mutableListOf(4,8,4), mutableListOf(2,4,2)),
            P5.minesweeper(
                mutableListOf(  mutableListOf(true, true, true),
                                mutableListOf(true, false, true),
                                mutableListOf(true, true, true))
            ))
    }

    @Test
    fun avoidObstacles() {
        assertEquals(4, P5.avoidObstacles(mutableListOf(5,3,6,7,9)))
        assertEquals(8, P5.avoidObstacles(mutableListOf(1,2, 4, 6, 7, 10)))
        assertEquals(5, P5.avoidObstacles(mutableListOf(1,2, 3, 4)))
        assertEquals(2, P5.avoidObstacles(mutableListOf(1)))

    }

    @Test
    fun isIPv4Address() {
        assertTrue(P5.isIPv4Address("123.123.123.123"))
        assertTrue(P5.isIPv4Address("123.254.12.0"))
        assertFalse(P5.isIPv4Address("a"))
        assertFalse(P5.isIPv4Address("255.255.255.255"))
        assertFalse(P5.isIPv4Address("1.1.1.1.1"))
    }

    @Test
    fun boxBlur() {
        assertEquals(mutableListOf(mutableListOf(1)), P5.boxBlur(mutableListOf(mutableListOf(1,1,1), mutableListOf(1,1,1), mutableListOf(1,1,1))))
        assertEquals(mutableListOf(mutableListOf(1, 1), mutableListOf(1,1)), P5.boxBlur(mutableListOf(mutableListOf(1,1,1, 1), mutableListOf(1,1,1, 1), mutableListOf(1,1,1, 1), mutableListOf(1,1,1,1))))
        assertEquals(mutableListOf<MutableList<Int>>(), P5.boxBlur(mutableListOf(mutableListOf(1))))
        assertEquals(mutableListOf<MutableList<Int>>(), P5.boxBlur(mutableListOf(mutableListOf())))
    }
}