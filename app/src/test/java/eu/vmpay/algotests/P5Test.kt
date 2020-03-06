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
    fun isIPv4Address(){
        assertEquals(true,P5.isIPv4Address("123.12.254.1"))
    }
    @Test
    fun avoidObstacles(){
        assertEquals(4,P5.avoidObstacles(mutableListOf(5,3,6,7,9)))
        assertEquals(6,P5.avoidObstacles(mutableListOf(5, 8, 9, 13, 14)))
    }
    @Test
    fun boxBlur(){
        assertEquals((mutableListOf(mutableListOf(3,3))),P5.boxBlur(mutableListOf(mutableListOf(1,2,3,10),mutableListOf(10,2,3,1),mutableListOf(4,1,2,3))))
        assertEquals((mutableListOf(mutableListOf(2))),P5.boxBlur(mutableListOf(mutableListOf(1,2,3),mutableListOf(1,2,3),mutableListOf(1,2,3))))
    }

    @Test
    fun minesweeper(){
        assertEquals((mutableListOf(mutableListOf(1,2,1),mutableListOf(2,1,1),mutableListOf(1,1,1))), P5.minesweeper(mutableListOf(mutableListOf(true,false,false),mutableListOf(false,true,false),mutableListOf(false,false,false))))
        assertEquals((mutableListOf(mutableListOf(1,2,3,1),mutableListOf(2,1,4,2),mutableListOf(1,1,3,1))), P5.minesweeper(mutableListOf(mutableListOf(true,false,false,true),mutableListOf(false,true,false,true),mutableListOf(false,false,false,true))))
    }

}