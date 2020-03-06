package eu.vmpay.algotests

import org.junit.Assert.*
import org.junit.Test

class P6Test {

    @Test
    fun arrayReplaceTest() {
        assertEquals(arrayListOf(3, 5, 5), P6.arrayReplace(arrayListOf(3, 4, 5), 4, 5))
        assertEquals(arrayListOf(2, 120, 13, 2, 2), P6.arrayReplace(arrayListOf(2, 120, 15, 2 , 2), 15, 13))
        assertEquals(arrayListOf(1, 120, 15, 1, 1), P6.arrayReplace(arrayListOf(2, 120, 15, 2 , 2), 2, 1))
        assertEquals(arrayListOf(2 , 2), P6.arrayReplace(arrayListOf(2, 2), 2, 2))
    }

    @Test
    fun evenDigitsOnlyTest() {
        assertFalse(P6.evenDigitsOnly(555))
        assertFalse(P6.evenDigitsOnly(14500))
        assertTrue(P6.evenDigitsOnly(22222))
        assertTrue(P6.evenDigitsOnly(20000000))
    }

    @Test
    fun variableNameTest() {
        assertFalse(P6.variableName("1Kappa"))
        assertTrue(P6.variableName("_Kappa1"))
        assertFalse(P6.variableName("[]Kappa1"))
        assertFalse(P6.variableName("_Kappa-"))
        assertTrue(P6.variableName("Kappa"))
        assertTrue(P6.variableName("test"))
        assertFalse(P6.variableName("13Piw"))
    }

    @Test
    fun alphabeticShiftTest() {
        assertEquals("bcd", P6.alphabeticShift("abc"))
        assertEquals("aaa", P6.alphabeticShift("zzz"))
        assertEquals("deghbid", P6.alphabeticShift("cdfgahc"))
        assertEquals("Bojb", P6.alphabeticShift("Ania"))
    }

    @Test
    fun chessBoardCellColor() {
        assertTrue(P6.chessBoardCellColor("A2", "H7"))
        assertTrue(P6.chessBoardCellColor("A1", "H8"))
        assertFalse(P6.chessBoardCellColor("C3", "F5"))
        assertTrue(P6.chessBoardCellColor("D6", "G3"))
    }
}