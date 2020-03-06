package eu.vmpay.algotests

import org.junit.Assert.assertEquals
import org.junit.Test

class P6Test {
    @Test
    fun arrayReplaceTest() {
        assertEquals(
            mutableListOf(1, 2, 3, 4, 5, 5),
            P6.arrayReplace(mutableListOf(1, 2, 3, 4, 5, 6), 6, 5)
        )
        assertEquals(
            mutableListOf(1, 2, 3, 4, 5),
            P6.arrayReplace(mutableListOf(1, 2, 3, 4, 5), 7, 8)
        )
        assertEquals(
            mutableListOf(1, 1, 1, 1, 1, 1, 1),
            P6.arrayReplace(mutableListOf(7, 7, 7, 7, 7, 7, 7), 7, 1)
        )
        assertEquals(
            mutableListOf(111, 123, 1233, 12344, 5678),
            P6.arrayReplace(mutableListOf(111, 123, 1233, 12344, 0), 0, 5678)
        )
        assertEquals(
            mutableListOf(1, 2, 1, 2, 1, 2),
            P6.arrayReplace(mutableListOf(1, 3, 1, 3, 1, 3), 3, 2)
        )
        assertEquals(
            mutableListOf(-11, 22, 1123, 298, 0),
            P6.arrayReplace(mutableListOf(-11, 22, 1123, 298, 0), 1, -11)
        )
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
        assertEquals("bcdefgh", P6.alphabeticShift("abcdefg"))
        assertEquals("AbCdEfGh", P6.alphabeticShift("ZaBcDeFg"))
        assertEquals("ccccc", P6.alphabeticShift("bbbbb"))
        assertEquals("AaAaAa", P6.alphabeticShift("ZzZzZz"))
        assertEquals("bmb nb lpub", P6.alphabeticShift("ala ma kota"))
        assertEquals("IFMMP xpsme", P6.alphabeticShift("HELLO world"))
        assertEquals("", P6.alphabeticShift(""))
        assertEquals("  ", P6.alphabeticShift("  "))
    }

    @Test
    fun chessBoardCellColorTest() {
        assertEquals(true, P6.chessBoardCellColor("a1", "b2"))
        assertEquals(true, P6.chessBoardCellColor("a1", "e1"))
        assertEquals(true, P6.chessBoardCellColor("a2", "h3"))
        assertEquals(true, P6.chessBoardCellColor("c5", "c5"))
        assertEquals(false, P6.chessBoardCellColor("a3", "c8"))
        assertEquals(false, P6.chessBoardCellColor("g7", "d5"))
        assertEquals(false, P6.chessBoardCellColor("c6", "h2"))
    }

    @Test
    fun variableName() {
        assertEquals(true, P6.variableName("goodVariableName"))
        assertEquals(true, P6.variableName("good_variable_name"))
        assertEquals(true, P6.variableName("qwerty123"))
        assertEquals(true, P6.variableName("hkjhjkdsa___dsa"))
        assertEquals(true, P6.variableName("____"))
        assertEquals(true, P6.variableName("a12345"))
        assertEquals(false, P6.variableName("true  true"))
        assertEquals(false, P6.variableName("lki>>>"))
        assertEquals(false, P6.variableName("12345___)"))
        assertEquals(false, P6.variableName("1asdfghj"))
    }

}