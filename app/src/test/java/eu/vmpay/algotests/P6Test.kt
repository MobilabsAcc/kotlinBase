package eu.vmpay.algotests

import eu.vmpay.algotests.algorithmictasks.P6
import junit.framework.TestCase.*
import org.junit.Test

class P6Test {

    @Test
    fun arrayReplace() {
        assertEquals(
            mutableListOf(1, 4, 2, 10, 4),
            P6.arrayReplace(mutableListOf(1, 5, 2, 10, 5), 5, 4)
        )
    }

    @Test
    fun evenDigitsOnly() {
        assertTrue(P6.evenDigitsOnly(24682))
        assertTrue(P6.evenDigitsOnly(22))
        assertTrue(P6.evenDigitsOnly(2082064682))
        assertFalse(P6.evenDigitsOnly(2014))
        assertFalse(P6.evenDigitsOnly(14))
        assertFalse(P6.evenDigitsOnly(1891))
    }

    @Test
    fun variableName() {
        assertTrue(P6.variableName("se_32a"))
        assertFalse(P6.variableName("1se_32a"))
    }

    @Test
    fun alphabeticShift() {
        assertEquals("bcde", P6.alphabeticShift("abcd"))
        assertEquals("gowde", P6.alphabeticShift("fnvcd"))
    }

    @Test
    fun chessBoardCellColor() {
        assertTrue(P6.chessBoardCellColor("A1", "C3"))
        assertFalse(P6.chessBoardCellColor("A1", "H3"))
    }
}