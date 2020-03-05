package eu.vmpay.algotests

import org.junit.Assert.*
import org.junit.Test

class P6Test {
    @Test
    fun arrayReplace() {
        assertEquals(mutableListOf(1 ,2 ,3 ,2, 4, 5), P6.arrayReplace(mutableListOf(1 ,0 ,3, 0, 4, 5), 0, 2))
        assertEquals(mutableListOf<Int>(), P6.arrayReplace(mutableListOf(), 0, 2))
    }

    @Test
    fun evenDigitsOnly() {
        assertTrue(P6.evenDigitsOnly(111111))
        assertFalse(P6.evenDigitsOnly(222111))
        assertFalse(P6.evenDigitsOnly(1212121))
        assertTrue(P6.evenDigitsOnly(2222))
        assertTrue(P6.evenDigitsOnly(0))
    }

    @Test
    fun variableName() {
        assertTrue(P6.variableName("test"))
        assertTrue(P6.variableName("Test"))
        assertTrue(P6.variableName("testTest"))
        assertTrue(P6.variableName("test_test"))
        assertTrue(P6.variableName("test01234"))
        assertTrue(P6.variableName("_private"))
        assertFalse(P6.variableName("0test"))
        assertFalse(P6.variableName("test()"))
        assertFalse(P6.variableName("_test()"))
    }

    @Test
    fun alphabeticShift() {
        assertEquals("bcdefg", P6.alphabeticShift("abcdef"))
        assertEquals("aaabce", P6.alphabeticShift("zzzabd"))
    }

    @Test
    fun chessBoardCellColor() {
        assertTrue(P6.chessBoardCellColor("A1", "H8"))
        assertTrue(P6.chessBoardCellColor("H1", "A8"))
        assertTrue(P6.chessBoardCellColor("A3", "H4"))
        assertTrue(P6.chessBoardCellColor("D5", "D5"))
        assertFalse(P6.chessBoardCellColor("D5", "C5"))
        assertFalse(P6.chessBoardCellColor("D5", "E5"))
        assertFalse(P6.chessBoardCellColor("D5", "D4"))
        assertFalse(P6.chessBoardCellColor("D5", "D6"))
    }
}