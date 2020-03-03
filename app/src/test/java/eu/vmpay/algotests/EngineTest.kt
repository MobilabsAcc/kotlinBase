package eu.vmpay.algotests

import org.junit.Test

import org.junit.Assert.*

class EngineTest {

    @Test
    fun start() {
        val engine = Engine(2, false)
        engine.start()
        val isWorking = engine.getIsWorking()
        assertEquals(true, isWorking)
    }

    @Test
    fun stop() {
        val engine = Engine(2, true)
        engine.stop()
        val isWorking = engine.getIsWorking()
        assertEquals(false, isWorking)
    }

    @Test
    fun getPower() {
        val engine = Engine(8, false)
        assertEquals(8, engine.power)
    }
}