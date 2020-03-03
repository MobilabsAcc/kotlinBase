package eu.vmpay.algotests

import org.junit.Test

import org.junit.Assert.*

class ShipTest {

    @Test
    fun getTourists() {
        val x=5
        val t=tourist()
        val actual= t.bar(x)
        assertEquals(0,actual )
    }
}