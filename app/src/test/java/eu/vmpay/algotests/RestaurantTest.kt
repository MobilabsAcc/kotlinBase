package eu.vmpay.algotests

import org.junit.Test

import org.junit.Assert.*

class RestaurantTest {

    @Test
    fun visit() {
        val restaurant = Restaurant("restaurant", 1,0)
        val tourist1 = Tourist("aaa", "bbb", 19, null ,null)
        val tourist2 = Tourist("aab", "bab", 14, null, null)
        assertTrue(restaurant.visit(tourist1))
        assertFalse(restaurant.visit(tourist2))
    }
}