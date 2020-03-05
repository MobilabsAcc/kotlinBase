package eu.vmpay.algotests

import junit.framework.Assert.assertEquals
import org.junit.Test

class P5Test {
    @Test
    fun areEquallyStrong(){
        assertEquals(true, P5.areEquallyStrong(10,30,30,10))
        assertEquals(false, P5.areEquallyStrong(5,30,30,10))
    }
    @Test
    fun arrayMaximalAdjacentDifference(){
        assertEquals(1,P5.arrayMaximalAdjacentDifference(mutableListOf(1)))
        assertEquals(3,P5.arrayMaximalAdjacentDifference(mutableListOf(1,4,6,4)))
    }
    @Test
    fun avoidObstacles(){
        assertEquals(4,P5.avoidObstacles(mutableListOf(5,3,6,7,9)))
        assertEquals(6,P5.avoidObstacles(mutableListOf(5, 8, 9, 13, 14)))
    }
    @Test
    fun boxBlur(){
        assertEquals((mutableListOf(mutableListOf(),mutableListOf(2),mutableListOf())),P5.boxBlur(mutableListOf(mutableListOf(1,2,3),mutableListOf(1,2,3),mutableListOf(1,2,3))))
        assertEquals((mutableListOf(mutableListOf(1,2,3,10),mutableListOf(10,2,3,1),mutableListOf(4,1,2,3))),P5.boxBlur(mutableListOf(mutableListOf(1,2,3,10),mutableListOf(10,2,3,1),mutableListOf(4,1,2,3))))
    }

}