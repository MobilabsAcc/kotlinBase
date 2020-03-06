package eu.vmpay.algotests

import eu.vmpay.algotests.P5.areEquallyStrong
import eu.vmpay.algotests.P5.arrayMaximalAdjacentDifference
import eu.vmpay.algotests.P5.avoidObstacles
import eu.vmpay.algotests.P5.boxBlur
import eu.vmpay.algotests.P5.isIPv4Address
import eu.vmpay.algotests.P5.minesweeper
import junit.framework.TestCase.*

import org.junit.Test

class P5Test {

    @Test
    fun areEquallyStrongTest() {
        assertTrue(areEquallyStrong(10, 3, 5, 10))
        assertTrue(areEquallyStrong(1, 10, 3, 10))
        assertTrue(areEquallyStrong(21, 15, 21, 10))
        assertFalse(areEquallyStrong(1, 3, 3, 10))
        assertFalse(areEquallyStrong(1, 10, 21, 10))
    }

    @Test
    fun arrayMaximalAdjacentDifferenceTest() {
        assertEquals(10, arrayMaximalAdjacentDifference(mutableListOf(-10, -2, 3, -3, 4, 14)))
        assertEquals(12, arrayMaximalAdjacentDifference(mutableListOf(-5, -10, 2, 12, 4, 14)))
        assertEquals(8, arrayMaximalAdjacentDifference(mutableListOf(1, 2, 4, 8, 16)))
        assertEquals(0, arrayMaximalAdjacentDifference(mutableListOf(1, 1, 1, 1, 1, 1)))
        assertEquals(0, arrayMaximalAdjacentDifference(mutableListOf()))
    }

    @Test
    fun isIPv4AddressTest() {
        assertTrue(isIPv4Address("1.1.1.1"))
        assertTrue(isIPv4Address("254.19.22.100"))
        assertTrue(isIPv4Address("255.255.255.255"))
        assertFalse(isIPv4Address("256.10.10.10"))
        assertFalse(isIPv4Address("-10.10.10.10"))
        assertFalse(isIPv4Address("0.10.101"))
        assertFalse(isIPv4Address(""))
    }

    @Test
    fun avoidObstaclesTest() {
        assertEquals(2, avoidObstacles(mutableListOf(1, 3, 5, 7)))
        assertEquals(4, avoidObstacles(mutableListOf(1, 3, 5, 7, 10)))
        assertEquals(4, avoidObstacles(mutableListOf(10, 3, 7, 5, 1)))
        assertEquals(6, avoidObstacles(mutableListOf(1, 2, 3, 4, 5, 7)))
        assertEquals(6, avoidObstacles(mutableListOf(1, 3, 2, 7, 5, 4)))
        assertEquals(1, avoidObstacles(mutableListOf()))
    }

    @Test
    fun boxBlurTest() {
        assertEquals(mutableListOf<MutableList<Int>>(), boxBlur(mutableListOf()))
        assertEquals(
            mutableListOf<MutableList<Int>>(), boxBlur(
                mutableListOf(
                    mutableListOf(2, 3),
                    mutableListOf(3, 2)
                )
            )
        )
        assertEquals(
            mutableListOf<MutableList<Int>>(), boxBlur(
                mutableListOf(
                    mutableListOf(2, 3, 4, 5)
                )
            )
        )
        assertEquals(
            mutableListOf(
                mutableListOf(6, 7)
            ), boxBlur(
                mutableListOf(
                    mutableListOf(2, 3, 4, 5),
                    mutableListOf(4, 6, 2, 9),
                    mutableListOf(10, 4, 21, 9)
                )
            )
        )
        assertEquals(
            mutableListOf(
                mutableListOf(17, 16),
                mutableListOf(16, 17)
            ), boxBlur(
                mutableListOf(
                    mutableListOf(20, 33, 4, 5),
                    mutableListOf(4, 61, 2, 9),
                    mutableListOf(10, 4, 21, 9),
                    mutableListOf(1, 41, 3, 5)
                )
            )
        )
    }

    @Test
    fun minesweeperTest() {
        assertEquals(mutableListOf<MutableList<Int>>(), minesweeper(mutableListOf()))
        assertEquals(
            mutableListOf(mutableListOf(0)),
            minesweeper(mutableListOf(mutableListOf(true)))
        )
        assertEquals(
            mutableListOf(mutableListOf(0)),
            minesweeper(mutableListOf(mutableListOf(false)))
        )
        assertEquals(
            mutableListOf(
                mutableListOf(0, 1),
                mutableListOf(1, 1)
            ), minesweeper(
                mutableListOf(
                    mutableListOf(true, false),
                    mutableListOf(false, false)
                )
            )
        )
        assertEquals(
            mutableListOf(
                mutableListOf(1, 2, 1),
                mutableListOf(2, 1, 1),
                mutableListOf(1, 1, 1)
            ), minesweeper(
                mutableListOf(
                    mutableListOf(true, false, false),
                    mutableListOf(false, true, false),
                    mutableListOf(false, false, false)
                )
            )
        )
    }
}