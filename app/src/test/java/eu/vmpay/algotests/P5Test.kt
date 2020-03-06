package eu.vmpay.algotests

import junit.framework.TestCase.assertEquals
import org.junit.Test

class P5Test {

    @Test
    fun mineSweeper() {
        assertEquals(
            mutableListOf<MutableList<Int>>(mutableListOf(1, 2, 2, 2, 2, 2, 1)),
            P5.minesweeper(
                mutableListOf<MutableList<Boolean>>(
                    mutableListOf(
                        true,
                        true,
                        true,
                        true,
                        true,
                        true,
                        true
                    )
                )
            )
        )
        assertEquals(
            mutableListOf<MutableList<Int>>(mutableListOf(0)),
            P5.minesweeper(mutableListOf<MutableList<Boolean>>(mutableListOf(true)))
        )
        assertEquals(
            mutableListOf<MutableList<Int>>(
                mutableListOf(2, 2, 4, 1),
                mutableListOf(3, 2, 4, 1)
            )
            , P5.minesweeper(
                mutableListOf<MutableList<Boolean>>(
                    mutableListOf(true, true, false, true)
                    , mutableListOf(false, true, false, true)
                )
            )
        )
        assertEquals(
            mutableListOf<MutableList<Int>>(
                mutableListOf(2, 2, 4, 1),
                mutableListOf(4, 4, 5, 2),
                mutableListOf(1, 3, 2, 2)
            )
            , P5.minesweeper(
                mutableListOf<MutableList<Boolean>>(
                    mutableListOf(true, true, false, true),
                    mutableListOf(false, true, false, true),
                    mutableListOf(true, false, true, false)
                )
            )
        )
    }

    @Test
    fun areEquallyStrongTest() {
        assertEquals(true, P5.areEquallyStrong(1, 2, 1, 2))
        assertEquals(true, P5.areEquallyStrong(2, 2, 2, 2))
        assertEquals(false, P5.areEquallyStrong(20, 2, 3, 20))
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
    fun avoidObstaclesTest() {
        assertEquals(7, P5.avoidObstacles(mutableListOf(1, 2, 3, 4, 5, 6)))
        assertEquals(4, P5.avoidObstacles(mutableListOf(1, 2, 3, 5, 6, 7, 9, 13)))
        assertEquals(2, P5.avoidObstacles(mutableListOf(1, 3, 5, 7, 9, 11, 19)))
        assertEquals(5, P5.avoidObstacles(mutableListOf(2, 4, 6, 8, 9)))
        assertEquals(2, P5.avoidObstacles(mutableListOf(1, 999)))
        assertEquals(2, P5.avoidObstacles(mutableListOf(1, 999999999)))
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
                mutableListOf(4)
            ), P5.boxBlur(
                mutableListOf(
                    mutableListOf(7, 1, 4),
                    mutableListOf(8, 1, 3),
                    mutableListOf(9, 1, 4)
                )
            )
        )
        assertEquals(
            mutableListOf(
                mutableListOf(40)
            ), P5.boxBlur(
                mutableListOf(
                    mutableListOf(-7, 8, 4),
                    mutableListOf(82, 61, 73),
                    mutableListOf(95, 61, -12)
                )
            )
        )
    }


    @Test
    fun isIPv4AddressTest() {
        assertEquals(true, P5.isIPv4Address("1.111111.1.1"))
        assertEquals(false, P5.isIPv4Address("0.1.0.0.0"))
        assertEquals(false, P5.isIPv4Address("255.255.255.255.."))
        assertEquals(true, P5.isIPv4Address("125.123.123.2"))
        assertEquals(false, P5.isIPv4Address(""))
        assertEquals(false, P5.isIPv4Address("...123123"))
    }
}