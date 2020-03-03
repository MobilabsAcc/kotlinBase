package eu.vmpay.algotests

import org.junit.Test

import org.junit.Assert.*

class EngineTest {

    @Test
    fun changeWorkingMode() {
        val engine = Engine(2.0)
        engine.changeWorkingMode()
        assertEquals(true, engine.isWorking)
    }
}