package eu.vmpay.algotests

import org.junit.Assert.assertEquals
import org.junit.Test

class P5Test {

    @Test
    fun areEquallyStrongTest() {
        assertEquals(true, P5.areEquallyStrong(0, 3, 3, 3))
        assertEquals(true, P5.areEquallyStrong(8, 8, 2, 8))
        assertEquals(true, P5.areEquallyStrong(0, 5, 5, 4))
        assertEquals(false, P5.areEquallyStrong(1, 4, 10, 9))
        assertEquals(false, P5.areEquallyStrong(6, 5, 10, 6))
        assertEquals(false, P5.areEquallyStrong( 6, 1, 11, 3))
    }

    @Test
    fun arrayMaximalAdjacentDifferenceTest() {
        assertEquals(1, P5.arrayMaximalAdjacentDifference(mutableListOf(1, 2, 3)))
        assertEquals(1, P5.arrayMaximalAdjacentDifference(mutableListOf(0, 1, 2, 1, 0, 1, 2, 1)))
        assertEquals(15, P5.arrayMaximalAdjacentDifference(mutableListOf(100, 88, 75, 60)))
        assertEquals(51, P5.arrayMaximalAdjacentDifference(mutableListOf(0, -51, -20, 26))
        )
        assertEquals(0, P5.arrayMaximalAdjacentDifference(mutableListOf(1, 1, 1, 1, 1)))
        assertEquals(0, P5.arrayMaximalAdjacentDifference(mutableListOf(5)))
    }

    @Test
    fun isIPv4AddressTest() {
        assertEquals(true, P5.isIPv4Address("234.33.13.43"))
        assertEquals(true, P5.isIPv4Address("0.0.0.0"))
        assertEquals(true, P5.isIPv4Address("255.25.15.255"))
        assertEquals(true, P5.isIPv4Address("1.0.1.2"))
        assertEquals(false, P5.isIPv4Address("...."))
        assertEquals(false, P5.isIPv4Address("..11.123"))
        assertEquals(false, P5.isIPv4Address("..."))
        assertEquals(false, P5.isIPv4Address("256.34.34.34"))
        assertEquals(false, P5.isIPv4Address("-14.34.34.9"))
    }

    @Test
    fun avoidObstaclesTest() {
        assertEquals(5, P5.avoidObstacles(mutableListOf(2, 3, 4)))
        assertEquals(4, P5.avoidObstacles(mutableListOf(1, 5, 6, 7)))
        assertEquals(2, P5.avoidObstacles(mutableListOf(1, 13, 25, 77, 99)))
        assertEquals(3, P5.avoidObstacles(mutableListOf( 4, 5, 7, 10)))
        assertEquals(2, P5.avoidObstacles(mutableListOf(1, 101)))
        assertEquals(3, P5.avoidObstacles(mutableListOf(16, 97, 9973, 9974)))
        assertEquals(1, P5.avoidObstacles(mutableListOf()))
    }

    @Test
    fun blurBoxTest() {
        assertEquals(
            mutableListOf(mutableListOf(1)), P5.boxBlur(
                mutableListOf(
                    mutableListOf(1, 1, 1),
                    mutableListOf(1, 2, 1),
                    mutableListOf(1, 1, 1)
                )
            )
        )
        assertEquals(
            mutableListOf(
                mutableListOf(1, 0)
            ), P5.boxBlur(
                mutableListOf(
                    mutableListOf(0, 3, 0, 1),
                    mutableListOf(0, 1, 0, 1),
                    mutableListOf(8, 0, 0, 1)
                )
            )
        )
        assertEquals(
            mutableListOf(
                mutableListOf(4, 3),
                mutableListOf(4, 3)
            ), P5.boxBlur(
                mutableListOf(
                    mutableListOf(4, 4, 4, 1),
                    mutableListOf(4, 4, 4, 1),
                    mutableListOf(4, 4, 4, 1),
                    mutableListOf(7, 6, 5, 3)
                )
            )
        )
        assertEquals(
            mutableListOf(
                mutableListOf(0, 2),
                mutableListOf(16, 10)
            ), P5.boxBlur(
                mutableListOf(
                    mutableListOf(-3, 8, 4, 27),
                    mutableListOf(3, -8, 0, -14),
                    mutableListOf(5, -5, -4, 13),
                    mutableListOf(33, 22, 99, -11)
                )
            )
        )
    }

    @Test
    fun minesweeperTest() {
        assertEquals(
            mutableListOf(
                mutableListOf(1, 1, 1),
                mutableListOf(1, 0, 1),
                mutableListOf(1, 1, 1)
            ),
            P5.minesweeper(
                mutableListOf(
                    mutableListOf(false, false, false),
                    mutableListOf(false, true, false),
                    mutableListOf(false, false, false)
                )
            )
        )
        assertEquals(
            mutableListOf(
                mutableListOf(0, 0, 0),
                mutableListOf(0, 0, 0),
                mutableListOf(0, 0, 0)
            ),
            P5.minesweeper(
                mutableListOf(
                    mutableListOf(false, false, false),
                    mutableListOf(false, false, false),
                    mutableListOf(false, false, false)
                )
            )
        )
        assertEquals(
            mutableListOf(
                mutableListOf(3, 5, 3),
                mutableListOf(5, 8, 5),
                mutableListOf(4, 6, 4),
                mutableListOf(3, 3, 3)
            ),
            P5.minesweeper(
                mutableListOf(
                    mutableListOf(true, true, true),
                    mutableListOf(true, true, true),
                    mutableListOf(true, true, true),
                    mutableListOf(false, true, false)
                )
            )
        )
        assertEquals(
            mutableListOf(
                mutableListOf(3, 5, 5, 3),
                mutableListOf(5, 8, 8, 5),
                mutableListOf(5, 8, 8, 5),
                mutableListOf(3, 5, 5, 3)
            ),
            P5.minesweeper(
                mutableListOf(
                    mutableListOf(true, true, true, true),
                    mutableListOf(true, true, true, true),
                    mutableListOf(true, true, true, true),
                    mutableListOf(true, true, true, true)
                )
            )
        )
    }



}