package eu.vmpay.algotests

import org.junit.Assert.*
import org.junit.Test

class P5Test {

    @Test
    fun areEquallyStrongTest() {
        assertFalse(P5.areEquallyStrong(2,3,1,2))
        assertFalse(P5.areEquallyStrong(5,3,5,2))
        assertFalse(P5.areEquallyStrong(11,1,1,8))
        assertTrue(P5.areEquallyStrong(5,5,5,5))
        assertTrue(P5.areEquallyStrong(2,3,3,2))
    }

    @Test
    fun arrayMaximalAdjacentDifferenceTest() {
        assertEquals(-1, P5.arrayMaximalAdjacentDifference(mutableListOf()))
        assertEquals(-1, P5.arrayMaximalAdjacentDifference(mutableListOf(3)))
        assertEquals(12, P5.arrayMaximalAdjacentDifference(mutableListOf(3, 6, -2, -5, 7, 3)))
        assertEquals(0, P5.arrayMaximalAdjacentDifference(mutableListOf(-2, -2, -2)))
        assertEquals(0, P5.arrayMaximalAdjacentDifference(mutableListOf(2, 2, 2)))
        assertEquals(0, P5.arrayMaximalAdjacentDifference(mutableListOf(0, 0)))
        assertEquals(2001, P5.arrayMaximalAdjacentDifference(mutableListOf(8, -5, 100, 1021, 1996, 3)))
    }

    @Test
    fun isIPv4AddressTest() {
        assertTrue(P5.isIPv4Address("255.255.255.255"))
        assertTrue(P5.isIPv4Address("0.0.0.0"))
        assertTrue(P5.isIPv4Address("69.89.31.226"))
        assertFalse(P5.isIPv4Address("89.31.226"))
        assertFalse(P5.isIPv4Address("89.31.226.50.50"))
        assertFalse(P5.isIPv4Address("89.31.226.256"))
        assertFalse(P5.isIPv4Address("89.31.226.-2"))
        assertTrue(P5.isIPv4Address("126.81.44.20"))
        assertFalse(P5.isIPv4Address("126"))
    }

    @Test
    fun avoidObstaclesTest() {
        assertEquals(2, P5.avoidObstacles(mutableListOf(1)))
        assertEquals(3, P5.avoidObstacles(mutableListOf(2)))
        assertEquals(3, P5.avoidObstacles(mutableListOf(1,2)))
        assertEquals(2, P5.avoidObstacles(mutableListOf(3)))
        assertEquals(5, P5.avoidObstacles(mutableListOf(3,4)))
        assertEquals(2, P5.avoidObstacles(mutableListOf(101)))
        assertEquals(4, P5.avoidObstacles(mutableListOf(102)))
        assertEquals(6, P5.avoidObstacles(mutableListOf(2,3,4,5)))
        assertEquals(11, P5.avoidObstacles(mutableListOf(40320)))
        assertEquals(1, P5.avoidObstacles(mutableListOf()))
        assertEquals(3, P5.avoidObstacles(mutableListOf(2,13,55,103)))
        assertEquals(13, P5.avoidObstacles(mutableListOf(2,3,4,5,6,7,8,9,10,12,22)))
        assertEquals(12, P5.avoidObstacles(mutableListOf(2,3,4,5,6,7,8,9,10,13,14,15,16,17,18,19,20,21,22)))
        assertEquals(11, P5.avoidObstacles(mutableListOf(2,3,4,5,6,7,8,9,10,23,34,45,56,67,78,89,100)))
    }

    @Test
    fun boxBlurTest(){
        assertEquals(arrayListOf(arrayListOf(0)),
            P5.boxBlur(arrayListOf(
              arrayListOf(0,0,0),
              arrayListOf(0,0,0),
              arrayListOf(0,0,0)
            )))

        assertEquals(arrayListOf(arrayListOf(9)),
            P5.boxBlur(arrayListOf(
                arrayListOf(9,9,9),
                arrayListOf(9,9,9),
                arrayListOf(9,9,9)
            )))

        assertEquals(arrayListOf(
            arrayListOf(5,4),
            arrayListOf(4,4)),
            P5.boxBlur(arrayListOf(
                arrayListOf(7,4,0,1),
                arrayListOf(5,6,2,2),
                arrayListOf(6,10,7,8),
                arrayListOf(1,4,2,0)
            )))

        assertEquals(arrayListOf(
            arrayListOf(40,30)),
            P5.boxBlur(arrayListOf(
                arrayListOf(36,0,18,9),
                arrayListOf(27,54,9,0),
                arrayListOf(81,63,72,45)
            )))

    }

    @Test
    fun minesweeperTest(){
        assertEquals(arrayListOf(
            arrayListOf(3, 5, 3),
            arrayListOf(5, 8, 5),
            arrayListOf(3, 5, 3)),
            P5.minesweeper(arrayListOf(
                arrayListOf(true, true, true),
                arrayListOf(true, true, true),
                arrayListOf(true, true, true))))

        assertEquals(arrayListOf(
            arrayListOf(0, 0, 0),
            arrayListOf(0, 0, 0),
            arrayListOf(0, 0, 0)),
            P5.minesweeper(arrayListOf(
                arrayListOf(false, false, false),
                arrayListOf(false, false, false),
                arrayListOf(false, false, false))))

        assertEquals(arrayListOf(
            arrayListOf(0, 2, 0),
            arrayListOf(2, 4, 2),
            arrayListOf(0, 2, 0)),
            P5.minesweeper(arrayListOf(
                arrayListOf(true, false, true),
                arrayListOf(false, false, false),
                arrayListOf(true, false, true))))

        assertEquals(arrayListOf(
            arrayListOf(1, 2, 2, 2, 1),
            arrayListOf(1, 4, 3, 4, 2),
            arrayListOf(2, 3, 2, 2, 0)),
            P5.minesweeper(arrayListOf(
                arrayListOf(false, false, false, true, true),
                arrayListOf(true, false, true, false, false),
                arrayListOf(false, true, true, false, false))))

        assertEquals(arrayListOf(
            arrayListOf(1, 2, 1, 0, 0),
            arrayListOf(2, 2, 2, 1, 0),
            arrayListOf(1, 2, 2, 2, 1),
            arrayListOf(0, 1, 2, 2, 2),
            arrayListOf(0, 0, 1, 2, 1)),
            P5.minesweeper(arrayListOf(
                arrayListOf(true, false, false, false, false),
                arrayListOf(false, true, false, false, false),
                arrayListOf(false, false, true, false, false),
                arrayListOf(false, false, false, true, false),
                arrayListOf(false, false, false, false, true))))
    }
}