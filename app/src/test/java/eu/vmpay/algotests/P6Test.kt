package eu.vmpay.algotests

import eu.vmpay.algotests.P6.alphabeticShift
import eu.vmpay.algotests.P6.arrayReplace
import eu.vmpay.algotests.P6.chessBoardCellColor
import eu.vmpay.algotests.P6.evenDigitsOnly
import eu.vmpay.algotests.P6.variableName
import junit.framework.TestCase.*
import org.junit.Test

class P6Test {
    @Test
    fun arrayReplaceTest() {
        assertEquals(
            mutableListOf(1, 2, 3, 5, 5, 6, 7, 8),
            arrayReplace(mutableListOf(1, 2, 3, 5, 5, 6, 7, 8), 4, 5)
        )
        assertEquals(mutableListOf(2, 2, 2, 2, 2), arrayReplace(mutableListOf(1, 1, 1, 1, 1), 1, 2))
        assertEquals(mutableListOf(1, 2, 3), arrayReplace(mutableListOf(1, 2, 3), 4, 5))
    }

    @Test
    fun evenDigitsOnlyTest() {
        assertTrue(evenDigitsOnly(2))
        assertTrue(evenDigitsOnly(24682))
        assertFalse(evenDigitsOnly(1))
        assertFalse(evenDigitsOnly(2468241))
        assertFalse(evenDigitsOnly(12468240))
    }

    @Test
    fun variableNameTest() {
        assertTrue(variableName("afAae_14_"))
        assertTrue(variableName("A"))
        assertFalse(variableName("3"))
        assertFalse(variableName("avmr_a1@"))
        assertFalse(variableName("a]["))
    }

    @Test
    fun alphabetShiftTest() {
        assertEquals("xabcdefg", alphabeticShift("abcdefgx"))
        assertEquals("x", alphabeticShift("x"))
        assertEquals("xyz", alphabeticShift("yzx"))
    }

    @Test
    fun chessBoardCellColorTest() {
        assertTrue(chessBoardCellColor("B2", "G5"))
        assertTrue(chessBoardCellColor("C7", "H8"))
        assertTrue(chessBoardCellColor("B8", "E5"))
        assertFalse(chessBoardCellColor("B8h", "E5"))
        assertFalse(chessBoardCellColor("b8", "E5"))
        assertFalse(chessBoardCellColor("B8", "E9"))
        assertFalse(chessBoardCellColor("A1", "A2"))
        assertFalse(chessBoardCellColor("B1", "H8"))
    }
}