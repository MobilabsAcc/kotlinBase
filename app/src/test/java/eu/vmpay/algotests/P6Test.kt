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
}