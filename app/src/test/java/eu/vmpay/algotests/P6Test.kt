package eu.vmpay.algotests

import junit.framework.Assert.*

import org.junit.Test

class P6Test {

    @Test
    fun arrayReplace() {
        assertEquals(mutableListOf(4,2,3,4), P6.arrayReplace(mutableListOf(1,2,3,4), 1, 4))
        assertEquals(mutableListOf(1), P6.arrayReplace(mutableListOf(1), 4, 6))
        assertEquals(mutableListOf(1,2,3,4), P6.arrayReplace(mutableListOf(1,2,3,4), 6, 4))
        assertEquals(mutableListOf(0,0,0,0,0), P6.arrayReplace(mutableListOf(1,1,1,1,1), 1, 0))
    }

    @Test
    fun evenDigitsOnly() {
        assertTrue(P6.evenDigitsOnly(11111))
        assertTrue(P6.evenDigitsOnly(1))
        assertFalse(P6.evenDigitsOnly(12345))
        assertFalse(P6.evenDigitsOnly(12))
    }

    @Test
    fun variableName() {
        assertTrue(P6.variableName("a"))
        assertTrue(P6.variableName("_string"))
        assertTrue(P6.variableName("_123string"))
        assertTrue(P6.variableName("_"))
        assertTrue(P6.variableName("StRiNg_123"))
        assertFalse(P6.variableName("123"))
        assertFalse(P6.variableName(""))
        assertFalse(P6.variableName(" "))
        assertFalse(P6.variableName("wąż"))
        assertFalse(P6.variableName("1ala"))
    }

    @Test
    fun alphabeticShift() {
        assertEquals("bmb", P6.alphabeticShift("ala"))
        assertEquals("aZ", P6.alphabeticShift("zY"))
        assertEquals("gps", P6.alphabeticShift("for"))
    }

    @Test
    fun chessBoardCellColor() {
        assertTrue(P6.chessBoardCellColor("11", "33"))
        assertTrue(P6.chessBoardCellColor("12", "21"))
        assertTrue(P6.chessBoardCellColor("22", "24"))
        assertFalse(P6.chessBoardCellColor("11", "23"))
        assertFalse(P6.chessBoardCellColor("32", "17"))
        assertFalse(P6.chessBoardCellColor("48", "25"))

    }
}