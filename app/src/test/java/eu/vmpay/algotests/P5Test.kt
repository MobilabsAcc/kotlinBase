package eu.vmpay.algotests


import org.junit.Assert.*
import org.junit.Test

class P5Test {

    @Test
    fun areEquallyStrongTest() {
        assertTrue(P5.areEquallyStrong(3, 5, 5, 3))
        assertTrue(P5.areEquallyStrong(3, 5, 3, 5))
        assertFalse(P5.areEquallyStrong(3, 5, 4, 5))
        assertFalse(P5.areEquallyStrong(3, 5, 5, 4))
    }

    @Test
    fun arrayMaximalAdjacentDifferenceTest() {
        assertEquals(1, P5.arrayMaximalAdjacentDifference(mutableListOf(1, 2, 3, 4, 5)))
        assertEquals(11, P5.arrayMaximalAdjacentDifference(mutableListOf(1, -2, 3, -4, 5, -6)))
        assertEquals(0, P5.arrayMaximalAdjacentDifference(mutableListOf(1)))
    }

    @Test
    fun isIPv4AddressTest() {
        assertTrue(P5.isIPv4Address("192.168.0.1"))
        assertTrue(P5.isIPv4Address("127.0.0.1"))
        assertFalse(P5.isIPv4Address("192.168.0"))
        assertFalse(P5.isIPv4Address("192.168.0.1.1"))
        assertFalse(P5.isIPv4Address("192.168.0.1.a"))
        assertFalse(P5.isIPv4Address("a.a.a.a"))
        assertFalse(P5.isIPv4Address("testString"))
    }

    @Test
    fun avoidObstaclesTest() {
        assertEquals(4, P5.avoidObstacles(mutableListOf(5, 3, 6, 7, 9)))
        assertEquals(7, P5.avoidObstacles(mutableListOf(1 ,4, 10, 6, 2)))
        assertEquals(4, P5.avoidObstacles(mutableListOf(2, 3)))
        assertEquals(2, P5.avoidObstacles(mutableListOf(3, 5, 7)))
    }

    @Test
    fun boxBlurTest() {
        assertEquals(
            mutableListOf(
                mutableListOf(5, 4),
                mutableListOf(4, 4)
            ),
            P5.boxBlur(
                mutableListOf(
                    mutableListOf(7, 4, 0, 1),
                    mutableListOf(5, 6, 2, 2),
                    mutableListOf(6, 10, 7, 8),
                    mutableListOf(1, 4, 2, 0)
                )
            )
        )
        assertEquals(
            mutableListOf(
                mutableListOf(40, 30)
            ),
            P5.boxBlur(
                mutableListOf(
                    mutableListOf(36, 0, 18, 9),
                    mutableListOf(27, 54, 9, 0),
                    mutableListOf(81, 63, 72, 45)
                )
            )
        )
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
                mutableListOf(1, 2, 2, 2, 1),
                mutableListOf(2, 1, 3, 3, 4),
                mutableListOf(2, 2, 4, 3, 3),
                mutableListOf(0, 2, 4, 5, 5),
                mutableListOf(1, 2, 2, 3, 2)
            ),
            P5.minesweeper(
                mutableListOf(
                    mutableListOf(true, false, false, false, true),
                    mutableListOf(false, true, false, true, false),
                    mutableListOf(false, false, false, true, true),
                    mutableListOf(true, false, false, true, false),
                    mutableListOf(false, false, true, true, true)
                )
            )
        )
    }
}