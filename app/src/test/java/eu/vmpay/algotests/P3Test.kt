package eu.vmpay.algotests

import eu.vmpay.algotests.algorithmictasks.P3
import junit.framework.TestCase.*
import org.junit.Test

class P3Test {

    @Test
    fun allLongestStringsTest() {
        assertEquals(listOf("aba", "vcd", "aba"), P3.allLongestStrings(mutableListOf("aba", "aa", "ad", "vcd", "aba")))
        assertEquals(listOf("aa"), P3.allLongestStrings(mutableListOf("aa")))
        assertEquals(listOf("eeee", "abcd"), P3.allLongestStrings(mutableListOf("abc", "eeee", "abcd", "dcd")))
        assertEquals(listOf("zzzzzz", "abcdef", "aaaaaa"),
                P3.allLongestStrings(mutableListOf("a", "abc", "cbd", "zzzzzz", "a", "abcdef", "asasa", "aaaaaa")))
        assertEquals(listOf("varennyky"), P3.allLongestStrings(mutableListOf("enyky", "benyky", "yely", "varennyky")))
        assertEquals(listOf("abacaba"), P3.allLongestStrings(mutableListOf("abacaba", "abacab", "abac", "xxxxxx")))
        assertEquals(listOf("yooooooung", "watermelon"),
                P3.allLongestStrings(mutableListOf("young", "yooooooung", "hot", "or", "not", "come", "on", "fire", "water", "watermelon")))
        assertEquals(listOf("aokbcwthc"), P3.allLongestStrings(mutableListOf("onsfnib", "aokbcwthc", "jrfcw")))
        assertEquals(listOf("lbgwyqkry"), P3.allLongestStrings(mutableListOf("lbgwyqkry")))
        assertEquals(listOf("i"), P3.allLongestStrings(mutableListOf("i")))
    }

    @Test
    fun commonCharacterCountTest() {
        assertEquals(3, P3.commonCharacterCount("aabcc", "adcaa"))
        assertEquals(4, P3.commonCharacterCount("zzzz", "zzzzzzz"))
        assertEquals(3, P3.commonCharacterCount("abca", "xyzbac"))
        assertEquals(0, P3.commonCharacterCount("a", "b"))
        assertEquals(1, P3.commonCharacterCount("a", "aaa"))
    }

    @Test
    fun isLuckyTest() {
        assertTrue(P3.isLucky(1230))
        assertFalse(P3.isLucky(239017))
        assertTrue(P3.isLucky(134008))
        assertFalse(P3.isLucky(10))
        assertTrue(P3.isLucky(11))
        assertTrue(P3.isLucky(1010))
        assertFalse(P3.isLucky(261534))
        assertFalse(P3.isLucky(100000))
        assertTrue(P3.isLucky(999999))
        assertTrue(P3.isLucky(123321))
    }

    @Test
    fun sortByHeightTest() {
        assertEquals(mutableListOf(-1, 150, 160, 170, -1, -1, 180, 190), P3.sortByHeight(mutableListOf(-1, 150, 190, 170, -1, -1, 160, 180)))
        assertEquals(mutableListOf(-1, -1, -1, -1, -1), P3.sortByHeight(mutableListOf(-1, -1, -1, -1, -1)))
        assertEquals(mutableListOf(-1), P3.sortByHeight(mutableListOf(-1)))
        assertEquals(mutableListOf(2, 2, 4, 9, 11, 16), P3.sortByHeight(mutableListOf(4, 2, 9, 11, 2, 16)))
        assertEquals(mutableListOf(1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 2), P3.sortByHeight(mutableListOf(2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1)))
        assertEquals(mutableListOf(1, 3, -1, 23, 43, -1, -1, 54, -1, -1, -1, 77), P3.sortByHeight(mutableListOf(23, 54, -1, 43, 1, -1, -1, 77, -1, -1, -1, 3)))
    }

    @Test
    fun reverseInParenthesesTest() {
        assertEquals("rab", P3.reverseInParentheses("(bar)"))
        assertEquals("foorabbaz", P3.reverseInParentheses("foo(bar)baz"))
        assertEquals("foorabbazmilb", P3.reverseInParentheses("foo(bar)baz(blim)"))
        assertEquals("foobazrabblim", P3.reverseInParentheses("foo(bar(baz))blim"))
        assertEquals("", P3.reverseInParentheses(""))
        assertEquals("", P3.reverseInParentheses("()"))
        assertEquals("cbadgfe", P3.reverseInParentheses("(abc)d(efg)"))
    }
}