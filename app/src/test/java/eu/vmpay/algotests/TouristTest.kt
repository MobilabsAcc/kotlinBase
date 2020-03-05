package eu.vmpay.algotests

import eu.vmpay.algotests.oop.Bar
import eu.vmpay.algotests.oop.Restaurant
import eu.vmpay.algotests.oop.Tourist
import eu.vmpay.algotests.oop.TwoPersonCabin
import org.junit.Test

import org.junit.Assert.*

class TouristTest {

    @Test
    fun goToBar() {
        val barA = Bar("a")
        val touristA = Tourist(14)
        touristA.goToBar(barA)
        assertEquals(null, touristA.currentPlace)

        val barB = Bar("b")
        val touristB = Tourist(19)
        touristB.goToBar(barB)
        assertEquals(barB, touristB.currentPlace)

        val barC = Bar("c")
        val touristC = Tourist(20)
        barC.currentNumberOfPeople = 50
        touristC.goToBar(barC)
        assertEquals(null, touristC.currentPlace)
    }

    @Test
    fun goToRestaurant() {
        val restaurantA = Restaurant("a")
        val touristA = Tourist(14)
        touristA.goToRestaurant(restaurantA)
        assertEquals(restaurantA, touristA.currentPlace)

        val restaurantB = Restaurant("b")
        val touristB = Tourist(20)
        restaurantB.currentNumberOfPeople = 300
        touristB.goToRestaurant(restaurantB)
        assertEquals(null, touristB.currentPlace)
    }

    @Test
    fun goToCabin() {
        val cabinA = TwoPersonCabin("a")
        val touristA = Tourist(20)
        val touristB = Tourist(20)
        val touristC = Tourist(20)
        touristA.goToCabin(cabinA)
        touristB.goToCabin(cabinA)
        touristC.goToCabin(cabinA)
        assertEquals(cabinA, touristA.currentPlace)
        assertEquals(cabinA, touristB.currentPlace)
        assertEquals(null, touristC.currentPlace)

    }

}