package eu.vmpay.algotests

import eu.vmpay.algotests.algorithmictasks.P1
import junit.framework.TestCase.*
import org.junit.Test

class P1Test {

    @Test
    fun addTest() {
        assertEquals(3, P1.add(1, 2))
        assertEquals(1000, P1.add(0, 1000))
        assertEquals(-37, P1.add(2, -39))
        assertEquals(199, P1.add(99, 100))
        assertEquals(0, P1.add(100, -100))
        assertEquals(-2000, P1.add(-1000, -1000))
    }

    @Test
    fun centuryFromYearTest() {
        assertEquals(20, P1.centuryFromYear(1905))
        assertEquals(17, P1.centuryFromYear(1700))
        assertEquals(20, P1.centuryFromYear(1998))
        assertEquals(20, P1.centuryFromYear(2000))
        assertEquals(21, P1.centuryFromYear(2001))
        assertEquals(2, P1.centuryFromYear(200))
        assertEquals(4, P1.centuryFromYear(374))
        assertEquals(1, P1.centuryFromYear(45))
        assertEquals(1, P1.centuryFromYear(8))
    }

    @Test
    fun checkPalindromeTest() {
        assertTrue(P1.checkPalindrome("aabaa"))
        assertFalse(P1.checkPalindrome("abac"))
        assertTrue(P1.checkPalindrome("a"))
        assertFalse(P1.checkPalindrome("az"))
        assertTrue(P1.checkPalindrome("abacaba"))
        assertTrue(P1.checkPalindrome("z"))
        assertFalse(P1.checkPalindrome("aaabaaaa"))
        assertFalse(P1.checkPalindrome("zzzazzazz"))
        assertTrue(P1.checkPalindrome("hlbeeykoqqqqokyeeblh"))
        assertTrue(P1.checkPalindrome("hlbeeykoqqqokyeeblh"))
    }
}