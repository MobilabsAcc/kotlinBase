package eu.vmpay.algotests

import org.junit.Assert.assertEquals
import org.junit.Test

class P6Test {
    @Test
    fun arrayReplaceTest() {
        assertEquals(
            mutableListOf(1, 2, 3, 4, 1),
            P6.arrayReplace(mutableListOf(1, 2, 3, 4, 5), 5, 1)
        )
        assertEquals(
            mutableListOf(1, 2, 3, 4),
            P6.arrayReplace(mutableListOf(1, 2, 3, 4), 0, 1)
        )
        assertEquals(
            mutableListOf(1, 1, 1, 1, 1),
            P6.arrayReplace(mutableListOf(3, 3, 3, 3, 3), 3, 1)
        )
        assertEquals(
            mutableListOf(11, 115, 15, 21, 56),
            P6.arrayReplace(mutableListOf(11, 115, 15, 21, 12), 12, 56)
        )
        assertEquals(
            mutableListOf(2, 2, 2, 2, 2, 2),
            P6.arrayReplace(mutableListOf(1, 2, 1, 2, 1, 2), 1, 2)
        )
        assertEquals(
            mutableListOf(-1, -1, -1, 11, -1),
            P6.arrayReplace(mutableListOf(-1, 1, 1, 11, -1), 1, -1)
        )
    }

    @Test
    fun evenDigitsOnlyTest() {
        assertEquals(true, P6.evenDigitsOnly(68))
        assertEquals(true, P6.evenDigitsOnly(-42))
        assertEquals(true, P6.evenDigitsOnly(246808))
        assertEquals(true, P6.evenDigitsOnly(0))
        assertEquals(false, P6.evenDigitsOnly(13))
        assertEquals(false, P6.evenDigitsOnly(22221))
        assertEquals(false, P6.evenDigitsOnly(15799))
        assertEquals(false, P6.evenDigitsOnly(2457680))
    }

    @Test
    fun variableName() {
        assertEquals(true, P6.variableName("some_name"))
        assertEquals(true, P6.variableName("name234"))
        assertEquals(true, P6.variableName("r2__an2d5om"))
        assertEquals(true, P6.variableName("_"))
        assertEquals(true, P6.variableName("a5"))
        assertEquals(false, P6.variableName("not good"))
        assertEquals(false, P6.variableName(":("))
        assertEquals(false, P6.variableName("4almost_good"))
        assertEquals(false, P6.variableName("kmd-=34_"))
    }

    @Test
    fun alphabeticShiftTest() {
        assertEquals("bcde", P6.alphabeticShift("abcd"))
        assertEquals("AZYX", P6.alphabeticShift("ZYXW"))
        assertEquals("nnn", P6.alphabeticShift("mmm"))
        assertEquals(" <<", P6.alphabeticShift(" <<"))
        assertEquals("Ofyu Uftu", P6.alphabeticShift("Next Test"))
        assertEquals("", P6.alphabeticShift(""))
    }

    @Test
    fun chessBoardCellColorTest() {
        assertEquals(true, P6.chessBoardCellColor("a1", "c3"))
        assertEquals(true, P6.chessBoardCellColor("a1", "c1"))
        assertEquals(true, P6.chessBoardCellColor("a2", "f3"))
        assertEquals(true, P6.chessBoardCellColor("g6", "g6"))
        assertEquals(false, P6.chessBoardCellColor("g6", "g7"))
        assertEquals(false, P6.chessBoardCellColor("a3", "f5"))
        assertEquals(false, P6.chessBoardCellColor("g6", "h2"))
    }



}