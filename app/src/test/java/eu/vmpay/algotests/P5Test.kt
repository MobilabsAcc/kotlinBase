package eu.vmpay.algotests

import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import org.junit.Test
class P5Test {

    @Test
     fun mineSweeper() {
        assertEquals(mutableListOf<MutableList<Int>>(mutableListOf(1,2,2,2,2,2,1)),P5.minesweeper(mutableListOf<MutableList<Boolean>>(mutableListOf(true,true,true,true,true,true,true))))
        assertEquals(mutableListOf<MutableList<Int>>(mutableListOf(0)),P5.minesweeper(mutableListOf<MutableList<Boolean>>(mutableListOf(true))))
        assertEquals(mutableListOf<MutableList<Int>>(
            mutableListOf(2,2,4,1),
            mutableListOf(3,2,4,1))
            ,P5.minesweeper(mutableListOf<MutableList<Boolean>>(
                mutableListOf(true,true,false,true)
                ,mutableListOf(false,true,false,true)
            )))
        assertEquals(mutableListOf<MutableList<Int>>(
            mutableListOf(2,2,4,1),
            mutableListOf(4,4,5,2),
            mutableListOf(1,3,2,2))
            ,P5.minesweeper(mutableListOf<MutableList<Boolean>>(
                mutableListOf(true,true,false,true),
                mutableListOf(false,true,false,true),
                mutableListOf(true,false,true,false)
            )))

        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}