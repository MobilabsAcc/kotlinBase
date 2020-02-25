package eu.vmpay.algotests

import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import org.junit.Test

class P2Test {

    @Test
    fun adjacentElementsProductTest() {
        assertEquals(21, P2.adjacentElementsProduct(mutableListOf(3, 6, -2, -5, 7, 3)))
        assertEquals(2, P2.adjacentElementsProduct(mutableListOf(-1, -2)))
        assertEquals(6, P2.adjacentElementsProduct(mutableListOf(5, 1, 2, 3, 1, 4)))
        assertEquals(6, P2.adjacentElementsProduct(mutableListOf(1, 2, 3, 0)))
        assertEquals(50, P2.adjacentElementsProduct(mutableListOf(9, 5, 10, 2, 24, -1, -48)))
        assertEquals(30, P2.adjacentElementsProduct(mutableListOf(5, 6, -4, 2, 3, 2, -23)))
        assertEquals(6, P2.adjacentElementsProduct(mutableListOf(4, 1, 2, 3, 1, 5)))
        assertEquals(-12, P2.adjacentElementsProduct(mutableListOf(-23, 4, -3, 8, -12)))
        assertEquals(0, P2.adjacentElementsProduct(mutableListOf(1, 0, 1, 0, 1000)))
    }

    @Test
    fun shapeAreaTest() {
        assertEquals(5, P2.shapeArea(2))
        assertEquals(13, P2.shapeArea(3))
        assertEquals(1, P2.shapeArea(1))
        assertEquals(41, P2.shapeArea(5))
        assertEquals(97986001, P2.shapeArea(7000))
        assertEquals(127984001, P2.shapeArea(8000))
        assertEquals(199940005, P2.shapeArea(9999))
        assertEquals(199900013, P2.shapeArea(9998))
        assertEquals(161946005, P2.shapeArea(8999))
        assertEquals(19801, P2.shapeArea(100))
    }

    @Test
    fun makeArrayConsecutive2Test() {
        assertEquals(3, P2.makeArrayConsecutive2(mutableListOf(6, 2, 3, 8)))
        assertEquals(2, P2.makeArrayConsecutive2(mutableListOf(0, 3)))
        assertEquals(0, P2.makeArrayConsecutive2(mutableListOf(5, 4, 6)))
        assertEquals(2, P2.makeArrayConsecutive2(mutableListOf(6, 3)))
        assertEquals(0, P2.makeArrayConsecutive2(mutableListOf(1)))
    }

    @Test
    fun almostIncreasingSequenceTest() {
        assertFalse(P2.almostIncreasingSequence(mutableListOf(1, 3, 2, 1)))
        assertTrue(P2.almostIncreasingSequence(mutableListOf(1, 3, 2)))
        assertFalse(P2.almostIncreasingSequence(mutableListOf(1, 2, 1, 2)))
        assertFalse(P2.almostIncreasingSequence(mutableListOf(3, 6, 5, 8, 10, 20, 15)))
        assertFalse(P2.almostIncreasingSequence(mutableListOf(1, 1, 2, 3, 4, 4)))
        assertFalse(P2.almostIncreasingSequence(mutableListOf(1, 4, 10, 4, 2)))
        assertTrue(P2.almostIncreasingSequence(mutableListOf(10, 1, 2, 3, 4, 5)))
        assertFalse(P2.almostIncreasingSequence(mutableListOf(1, 1, 1, 2, 3)))
        assertTrue(P2.almostIncreasingSequence(mutableListOf(0, -2, 5, 6)))
        assertFalse(P2.almostIncreasingSequence(mutableListOf(1, 2, 3, 4, 5, 3, 5, 6)))
        assertFalse(P2.almostIncreasingSequence(mutableListOf(40, 50, 60, 10, 20, 30)))
        assertTrue(P2.almostIncreasingSequence(mutableListOf(1, 1)))
        assertTrue(P2.almostIncreasingSequence(mutableListOf(1, 2, 5, 3, 5)))
        assertFalse(P2.almostIncreasingSequence(mutableListOf(1, 2, 5, 5, 5)))
        assertFalse(P2.almostIncreasingSequence(mutableListOf(10, 1, 2, 3, 4, 5, 6, 1)))
        assertTrue(P2.almostIncreasingSequence(mutableListOf(1, 2, 3, 4, 3, 6)))
        assertTrue(P2.almostIncreasingSequence(mutableListOf(1, 2, 3, 4, 99, 5, 6)))
        assertTrue(P2.almostIncreasingSequence(mutableListOf(123, -17, -5, 1, 2, 3, 12, 43, 45)))
        assertTrue(P2.almostIncreasingSequence(mutableListOf(3, 5, 67, 98, 3)))
    }

    @Test
    fun matrixElementsSumTest() {
        assertEquals(9, P2.matrixElementsSum(mutableListOf(
                mutableListOf(0, 1, 1, 2),
                mutableListOf(0, 5, 0, 0),
                mutableListOf(2, 0, 3, 3)
        )))
        assertEquals(9, P2.matrixElementsSum(mutableListOf(
                mutableListOf(1, 1, 1, 0),
                mutableListOf(0, 5, 0, 1),
                mutableListOf(2, 1, 3, 10)
        )))
        assertEquals(18, P2.matrixElementsSum(mutableListOf(
                mutableListOf(1, 1, 1),
                mutableListOf(2, 2, 2),
                mutableListOf(3, 3, 3)
        )))
        assertEquals(0, P2.matrixElementsSum(mutableListOf(
                mutableListOf(0)
        )))
        assertEquals(5, P2.matrixElementsSum(mutableListOf(
                mutableListOf(1, 0, 3),
                mutableListOf(0, 2, 1),
                mutableListOf(1, 2, 0)
        )))
        assertEquals(6, P2.matrixElementsSum(mutableListOf(
                mutableListOf(1),
                mutableListOf(5),
                mutableListOf(0),
                mutableListOf(2)
        )))
        assertEquals(15, P2.matrixElementsSum(mutableListOf(
                mutableListOf(1, 2, 3, 4, 5)
        )))
        assertEquals(17, P2.matrixElementsSum(mutableListOf(
                mutableListOf(2),
                mutableListOf(5),
                mutableListOf(10)
        )))
        assertEquals(15, P2.matrixElementsSum(mutableListOf(
                mutableListOf(4, 0, 1),
                mutableListOf(10, 7, 0),
                mutableListOf(0, 0, 0),
                mutableListOf(9, 1, 2)
        )))
        assertEquals(1, P2.matrixElementsSum(mutableListOf(
                mutableListOf(1)
        )))
    }
}