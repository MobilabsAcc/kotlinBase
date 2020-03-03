package eu.vmpay.algotests

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class EngineTest {

    @Test
    fun start() {
        val engine = Engine(2)
        engine.start()
        assertTrue(engine.isRunning)
    }

    @Test
    fun stop() {
        val engine = Engine(2)
        engine.stop()
        assertFalse(engine.isRunning)
    }
}