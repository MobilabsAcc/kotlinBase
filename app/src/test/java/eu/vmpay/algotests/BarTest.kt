package eu.vmpay.algotests

import org.junit.Test

import org.junit.Assert.*

class BarTest {

    @Test
    fun visit() {
        val bar = Bar("bar", 1,0)
        val tourist1 = Tourist("aaa", "bbb", 19, null ,null)
        val tourist2 = Tourist("aab", "bab", 14, null, null)
        assertTrue(bar.visit(tourist1))
        assertFalse(bar.visit(tourist2))
        assertFalse(bar.visit(tourist1))
    }
}