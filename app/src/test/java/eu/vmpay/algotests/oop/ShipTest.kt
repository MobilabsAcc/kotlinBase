package eu.vmpay.algotests.oop

import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test

class ShipTest {

    private lateinit var ship: Ship

    @Before
    fun setUp() {
        ship = Ship()
    }

    @Test
    fun setEnginePowerTest() {
        ship.setEnginePower(EnginePower.MAX)
        ship.setEnginePower(EnginePower.HIGH)
        ship.setEnginePower(EnginePower.LOW)
        ship.setEnginePower(EnginePower.ZERO)
    }

    @Test
    fun getEnginePowerConsumptionTest() {
        assertEquals(0, ship.getEnginePowerConsumption())
        ship.setEnginePower(EnginePower.MAX)
        assertEquals(6, ship.getEnginePowerConsumption())
    }
}