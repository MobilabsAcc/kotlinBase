package eu.vmpay.algotests
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import org.junit.Test
class P6Test {
    @Test
     fun arrayReplace() {
        assertEquals(mutableListOf(1,2,2,3),P6.arrayReplace(mutableListOf(1,4,4,3),4,2))
        assertEquals(mutableListOf(1,2,2,3),P6.arrayReplace(mutableListOf(1,4,4,3),4,2))

    }

    @Test
    fun variableName() {
        assertTrue(P6.variableName("_12gfd"))
        assertFalse(P6.variableName("1g_"))
        assertFalse(P6.variableName("1g_."))
        assertTrue(P6.variableName("q12dgbBBBBNxm______h"))
    }


    @Test
    fun evenDigitsOnlyTest() {
        assertEquals(true, P6.evenDigitsOnly(2468))
        assertEquals(true, P6.evenDigitsOnly(-2222))
        assertEquals(true, P6.evenDigitsOnly(42426))
        assertEquals(true, P6.evenDigitsOnly(0))
        assertEquals(false, P6.evenDigitsOnly(111))
        assertEquals(false, P6.evenDigitsOnly(10001))
        assertEquals(false, P6.evenDigitsOnly(13579))
        assertEquals(false, P6.evenDigitsOnly(245680))
    }


    @Test
    fun alphabeticShiftTest() {
        assertEquals("ccccc", P6.alphabeticShift("bbbbb"))
        assertEquals("eeeeec", P6.alphabeticShift("dddddb"))
        assertEquals("cccccdfg", P6.alphabeticShift("bbbbbcef"))
        assertEquals("AAA", P6.alphabeticShift("ZZZ"))

    }

    @Test
    fun chessBoardCellColorTest() {
        assertEquals(true, P6.chessBoardCellColor("a1", "b2"))
        assertEquals(true, P6.chessBoardCellColor("b6", "e1"))
        assertEquals(true, P6.chessBoardCellColor("a2", "h3"))
        assertEquals(true, P6.chessBoardCellColor("c1", "c5"))
        assertEquals(false, P6.chessBoardCellColor("a5", "c6"))
        assertEquals(false, P6.chessBoardCellColor("g7", "d5"))
        assertEquals(false, P6.chessBoardCellColor("c6", "h2"))
    }
}