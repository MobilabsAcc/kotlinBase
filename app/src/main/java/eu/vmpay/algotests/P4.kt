package eu.vmpay.algotests
import kotlin.math.abs

import kotlin.math.abs


object P4 {
    /**
     * Several people are standing in a row and need to be divided into two teams.
     * The first person goes into team 1, the second goes into team 2, the third goes into team 1 again,
     * the fourth into team 2, and so on. You are given an array of positive integers - the weights of
     * the people. Return an array of two integers, where the first element is the total weight of
     * team 1, and the second element is the total weight of team 2 after the division is complete.
     */
    fun alternatingSums(a: MutableList<Int>): MutableList<Int> {
        val output = mutableListOf(0,0)
        for( i in 0..a.lastIndex){
            if(i%2 == 0)
                output[0] += a[i]
            else
                output[1]+= a[i]
        }
        return output
    }

    /**
     * Given a rectangular matrix of characters, add a border of asterisks(*) to it.
     */
    fun addBorder(picture: MutableList<String>): MutableList<String>{
        val output = mutableListOf<String>()
        val firstAndLast = mutableListOf<Char>()
        for(i in 0..picture[0].length+1){
            firstAndLast.add('*')
        }
        output.add(String(firstAndLast.toCharArray()))

        for(i in 0..picture.lastIndex)
            output.add( '*' + picture[i] + '*')
        output.add(String(firstAndLast.toCharArray()))

        return output

    }

    /**
     * Two arrays are called similar if one can be obtained from another by swapping at most one
     * pair of elements in one of the arrays. Given two arrays a and b, check whether they are similar.
     */
    fun areSimilar(a: MutableList<Int>, b: MutableList<Int>): Boolean {
        var counter = 0
        for (i in 0..a.lastIndex)
            if(!(a.count { it == a[i] } == b.count{it == a[i]}))
                return false

        for(j in 0..a.lastIndex){
            if(a[j] != b[j])
                counter++
            if(counter == 3)
                return false
        }
        return true
    }

    /**
     * You are given an array of integers. On each move you are allowed to increase exactly one of
     * its element by one. Find the minimal number of moves required to obtain a strictly
     * increasing sequence from the input.
     */
    fun arrayChange(inputArray: MutableList<Int>): Int {
        var counter = 0
        for(i in 1..inputArray.lastIndex){
            if(inputArray[i] <= inputArray[i-1]) {
                val moves = abs(inputArray[i] - inputArray[i - 1]) + 1
                counter += moves
                inputArray[i] += moves
            }
        }
        return counter
    }

    /**
     * Given a string, find out if its characters can be rearranged to form a palindrome.
     */
    fun palindromeRearranging(inputString: String): Boolean {
        val distinctChars = inputString.toCharArray().distinct()
        var counter = 0
        for(i in 0..distinctChars.lastIndex){
            if(inputString.count{it == distinctChars[i]} %2 != 0 )
                counter++
            if (counter == 2)
                return false
        }
        return true
    }

}