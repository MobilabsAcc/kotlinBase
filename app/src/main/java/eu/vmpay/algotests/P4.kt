package eu.vmpay.algotests

import java.util.*

object P4 {
    /**
     * Several people are standing in a row and need to be divided into two teams.
     * The first person goes into team 1, the second goes into team 2, the third goes into team 1 again,
     * the fourth into team 2, and so on. You are given an array of positive integers - the weights of
     * the people. Return an array of two integers, where the first element is the total weight of
     * team 1, and the second element is the total weight of team 2 after the division is complete.
     */
    fun alternatingSums(a: MutableList<Int>): MutableList<Int> {
        val finalValue: MutableList<Int> = arrayListOf(0,0)
        for (i in 0 until a.size) if(i%2 == 0) finalValue[0]+= a[i] else finalValue[1]+= a[i]
        return finalValue
    }

    /**
     * Given a rectangular matrix of characters, add a border of asterisks(*) to it.
     */
    fun addBorder(picture: MutableList<String>): MutableList<String> {
        val firstBoxSide = picture[0].length + 2
        val point = "*"

        val border: MutableList<String> = arrayListOf(point.repeat(firstBoxSide))
        for(i in 0 until picture.size) border.add(point+picture[i]+point)
        border.add(point.repeat(firstBoxSide))

        return border
    }

    /**
     * Two arrays are called similar if one can be obtained from another by swapping at most one
     * pair of elements in one of the arrays. Given two arrays a and b, check whether they are similar.
     */
    fun areSimilar(a: MutableList<Int>, b: MutableList<Int>): Boolean {
        var swapped = 0
        for(i in 0 until b.size){
            if(a[i]!= b[i] && swapped >= 1) return false

            if(a[i]!= b[i]){
                for(j in 0 until b.size){
                    if(a[i] == b[j] && b[i] == a[j]){
                        val current = b[i]
                        val temp = b[j]
                        b[i] = temp
                        b[j] = current
                        swapped++
                    }
                }
            if(swapped == 0) return false
            }
        }
    return true
    }

    /**
     * You are given an array of integers. On each move you are allowed to increase exactly one of
     * its element by one. Find the minimal number of moves required to obtain a strictly
     * increasing sequence from the input.
     */
    fun arrayChange(inputArray: MutableList<Int>): Int {
        var i = 0
        var count = 0

        while(true){
            if (inputArray[i]>= inputArray[i + 1]){
                ++inputArray[i+1]
                ++count
            } else ++i
            if (i == inputArray.size - 1) break
        }
        return count
    }


    /**
     * Given a string, find out if its characters can be rearranged to form a palindrome.
     */
    fun palindromeRearranging(inputString: String): Boolean {
        val occurrences = inputString.filter{ it in inputString}
            .groupingBy { it }
            .eachCount().toList()
        var odd = 0

        for (i in 0 until occurrences.size){
            val value:Int = occurrences[i].toList()[1].toString().toInt()
            if(value%2 != 0 ) odd++
            if (odd > 1) return false
        }
        return true
    }

}
