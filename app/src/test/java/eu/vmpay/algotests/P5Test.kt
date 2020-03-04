package eu.vmpay.algotests

import org.junit.Assert.assertEquals
import org.junit.Test

class P5Test {

    @Test
    fun areEquallyStrongTest() {
        assertEquals(true, P5.areEquallyStrong(1, 2, 1, 2))
        assertEquals(true, P5.areEquallyStrong(2, 2, 2, 2))
        assertEquals(true, P5.areEquallyStrong(20, 2, 3, 20))
        assertEquals(false, P5.areEquallyStrong(3, 4, 5, 6))
        assertEquals(false, P5.areEquallyStrong(3, 5, 3, 6))
        assertEquals(false, P5.areEquallyStrong(0, 1, 0, 3))
    }

    @Test
    fun arrayMaximalAdjacentDifferenceTest() {
        assertEquals(1, P5.arrayMaximalAdjacentDifference(mutableListOf(1, 2, 3, 4, 5, 6, 7)))
        assertEquals(1, P5.arrayMaximalAdjacentDifference(mutableListOf(0, 1, 0, 1, 0, 1)))
        assertEquals(99, P5.arrayMaximalAdjacentDifference(mutableListOf(100, 99, 0, 1, 0, -1)))
        assertEquals(
            101,
            P5.arrayMaximalAdjacentDifference(mutableListOf(100, 0, -101, -33, 25, 86))
        )
        assertEquals(0, P5.arrayMaximalAdjacentDifference(mutableListOf(9, 9, 9, 9, 9)))
        assertEquals(0, P5.arrayMaximalAdjacentDifference(mutableListOf(1)))
        assertEquals(349, P5.arrayMaximalAdjacentDifference(mutableListOf(125, -125, 0, -234, 115)))
    }

    @Test
    fun isIPv4AddressTest() {
        assertEquals(true, P5.isIPv4Address("123.123.123.123"))
        assertEquals(true, P5.isIPv4Address("0.0.0.0"))
        assertEquals(true, P5.isIPv4Address("255.255.255.255"))
        assertEquals(true, P5.isIPv4Address("125.0.1.2"))
        assertEquals(false, P5.isIPv4Address(""))
        assertEquals(false, P5.isIPv4Address("...123123"))
        assertEquals(false, P5.isIPv4Address("..."))
        assertEquals(false, P5.isIPv4Address("1234.34.34.34"))
        assertEquals(false, P5.isIPv4Address("1234.34.34"))
    }

    @Test
    fun avoidObstaclesTest() {
        assertEquals(7, P5.avoidObstacles(mutableListOf(1, 2, 3, 4, 5, 6)))
        assertEquals(4, P5.avoidObstacles(mutableListOf(1, 2, 3, 5, 6, 7)))
        assertEquals(2, P5.avoidObstacles(mutableListOf(1, 3, 5, 7, 9)))
        assertEquals(5, P5.avoidObstacles(mutableListOf(2, 4, 6, 8)))
        assertEquals(2, P5.avoidObstacles(mutableListOf(1, 999)))
        assertEquals(2, P5.avoidObstacles(mutableListOf(1, 977, 9975, 99985)))
        assertEquals(11, P5.avoidObstacles(mutableListOf(3, 5, 8, 9, 10, 12, 13, 14, 15)))
        assertEquals(6, P5.avoidObstacles(mutableListOf(7, 8, 9, 13, 14, 15, 16, 17)))
        assertEquals(1, P5.avoidObstacles(mutableListOf()))
    }

    @Test
    fun minesweeperTest() {
        assertEquals(
            mutableListOf(
                mutableListOf(1, 2, 1),
                mutableListOf(2, 1, 1),
                mutableListOf(1, 1, 1)
            ),
            P5.minesweeper(
                mutableListOf(
                    mutableListOf(true, false, false),
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
                mutableListOf(3, 5, 3)
            ),
            P5.minesweeper(
                mutableListOf(
                    mutableListOf(true, true, true),
                    mutableListOf(true, true, true),
                    mutableListOf(true, true, true)
                )
            )
        )
        assertEquals(
            mutableListOf(
                mutableListOf(3, 4, 2, 1),
                mutableListOf(5, 7, 6, 3),
                mutableListOf(3, 4, 3, 1)
            ),
            P5.minesweeper(
                mutableListOf(
                    mutableListOf(true, true, true, false),
                    mutableListOf(true, true, false, false),
                    mutableListOf(true, true, true, true)
                )
            )
        )
    }

    @Test
    fun blurBoxTest() {
        assertEquals(
            mutableListOf(mutableListOf(2)), P5.boxBlur(
                mutableListOf(
                    mutableListOf(1, 2, 3),
                    mutableListOf(1, 2, 3),
                    mutableListOf(1, 2, 3)
                )
            )
        )
        assertEquals(
            mutableListOf(
                mutableListOf(0, 0)
            ), P5.boxBlur(
                mutableListOf(
                    mutableListOf(0, 1, 0, 1),
                    mutableListOf(0, 1, 0, 1),
                    mutableListOf(0, 1, 0, 1)
                )
            )
        )
        assertEquals(
            mutableListOf(
                mutableListOf(4, 1),
                mutableListOf(4, 2)
            ), P5.boxBlur(
                mutableListOf(
                    mutableListOf(7, 1, 4, 1),
                    mutableListOf(8, 1, 3, 1),
                    mutableListOf(9, 1, 4, 1),
                    mutableListOf(9, 6, 3, 1)
                )
            )
        )
        assertEquals(
            mutableListOf(
                mutableListOf(40, 25),
                mutableListOf(61, 26)
            ), P5.boxBlur(
                mutableListOf(
                    mutableListOf(-7, 8, 4, 78),
                    mutableListOf(82, 61, 73, -91),
                    mutableListOf(95, 61, -12, 43),
                    mutableListOf(94, 62, 39, -1)
                )
            )
        )
    }

}