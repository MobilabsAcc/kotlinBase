package eu.vmpay.algotests

import org.junit.Test

import org.junit.Assert.*

class RestaurantTest {

    @Test
    fun addMember() {
        val restaurant = Restaurant("Restauracja 1", 1)
        val tourist1 = Tourist("Eryk", "Marek", 22)
        val tourist2 = Tourist("Franek", "Miazga", 23)
        restaurant.addMember(tourist1)
        assertEquals(mutableListOf(tourist1), restaurant.getMembers())
        restaurant.addMember((tourist2))
        assertEquals(mutableListOf(tourist1), restaurant.getMembers())
    }

    @Test
    fun removeMember() {
        val restaurant = Restaurant("Restauracja 1", 2)
        val tourist1 = Tourist("Eryk", "Marek", 22)
        val tourist2 = Tourist("Franek", "Miazga", 23)
        restaurant.addMember(tourist1)
        restaurant.addMember(tourist2)
        restaurant.removeMember(tourist1)
        assertEquals(mutableListOf(tourist2), restaurant.getMembers())
    }

    @Test
    fun showMembers() {
    }
}