package eu.vmpay.algotests


import junit.framework.Assert.assertEquals
import org.junit.Test

class P6Test {
    @Test
    fun arrayReplace(){
        assertEquals(mutableListOf(1,2,6,2),P6.arrayReplace(mutableListOf(1,4,6,4),4,2))
    }
    @Test
    fun evenDigitsOnly(){
        assertEquals(true, P6.evenDigitsOnly(2686))
        assertEquals(false, P6.evenDigitsOnly(2786))
    }
    @Test
    fun variableName(){
        assertEquals(false, P6.variableName("2686"))
        assertEquals(true, P6.variableName("d686"))
    }
    @Test
    fun alphabeticShift(){
        assertEquals("a", P6.alphabeticShift("z"))
        assertEquals("acd", P6.alphabeticShift("zbc"))
    }
    @Test
    fun chessBoardCellColor(){
        assertEquals(true,P6.chessBoardCellColor("c5","d6"))
        assertEquals(true,P6.chessBoardCellColor("a1","d6"))
        assertEquals(false,P6.chessBoardCellColor("a2","d6"))
    }
}