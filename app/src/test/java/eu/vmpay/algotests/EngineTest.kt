package eu.vmpay.algotests

import org.junit.Test

import org.junit.Assert.*

class EngineTest {

    @Test
    fun turnOn() {
        val engine= Engine(1000)
        val actual = engine.turnOn()
        assertEquals(1000, actual)
    }

    @Test
    fun turnOff() {
        val engine= Engine(1000)
        val actual = engine.turnOff()
        assertEquals(-1000, actual)
    }
}