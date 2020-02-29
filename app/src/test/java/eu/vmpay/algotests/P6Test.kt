package eu.vmpay.algotests

import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import org.junit.Test

class P6Test {
    var ship:Ship = Ship()
    init{
        ship.boardTourist(Tourist("a", "b", 21, null, null))
        ship.boardTourist(Tourist("b", "b", 18, null, null))
        ship.boardTourist(Tourist("c", "b", 13, null, null))
        ship.boardTourist(Tourist("d", "b", 12, null, null))
        ship.boardCrew(Crew("e", "f", "Captain"))
        ship.boardCrew(Crew("e", "f", "Chef"))
        ship.cabins.add(Cabin(2, "1"))
        ship.cabins.add(Cabin(4, "2"))
        ship.bars.add(Bar("First bar"))
        ship.bars.add(Bar("Second bar"))
        ship.restaurants.add(Restaurant("Restaurant"))

    }
    @Test
    fun attractionTest() {
        assertEquals(true, ship.bars[0].visit(ship.tourists[0]))
        assertEquals(true, ship.bars[1].visit(ship.tourists[1]))
        assertEquals(false, ship.bars[1].visit(ship.tourists[2]))
        assertEquals(true, ship.restaurants[0].visit(ship.tourists[3]))
    }

    @Test
    fun EngineTest() {
        assertEquals(true, ship.changeEngineMode(ship.crew[0], ship.engines[0]))
        assertEquals(false, ship.changeEngineMode(ship.crew[1], ship.engines[0]))
        assertEquals(true, ship.changeEngineMode(ship.crew[0], ship.engines[1]))
    }

    @Test
    fun CabinTest() {
        assertEquals(true, ship.cabins[0].assignTourist(ship.tourists[0]))
        assertEquals(false, ship.cabins[0].assignTourist(ship.tourists[0]))
        assertEquals(true, ship.cabins[0].assignTourist(ship.tourists[1]))
        assertEquals(false, ship.cabins[0].assignTourist(ship.tourists[2]))
        assertEquals(true, ship.cabins[1].assignTourist(ship.tourists[2]))
    }

}