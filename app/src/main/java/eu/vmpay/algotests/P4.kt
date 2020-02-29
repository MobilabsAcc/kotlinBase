package eu.vmpay.algotests

import java.lang.StringBuilder

object P4 {
    /**
     * Several people are standing in a row and need to be divided into two teams.
     * The first person goes into team 1, the second goes into team 2, the third goes into team 1 again,
     * the fourth into team 2, and so on. You are given an array of positive integers - the weights of
     * the people. Return an array of two integers, where the first element is the total weight of
     * team 1, and the second element is the total weight of team 2 after the division is complete.
     */
    fun alternatingSums(a: MutableList<Int>): MutableList<Int> {
        val sum = mutableListOf(0, 0)

        for (i in a.indices)
            if (i.rem(2) == 0)
                sum[0] += a[i]
            else
                sum[1] += a[i]

        return sum
    }

    /**
     * Given a rectangular matrix of characters, add a border of asterisks(*) to it.
     */
    fun addBorder(picture: MutableList<String>): MutableList<String> {
        val width = picture[0].length + 1

        val ret = mutableListOf<String>()

        val builder = StringBuilder()
        for (i in 0..width)
            builder.append("*")
        ret.add(builder.toString())
        builder.clear()

        for (j in picture.indices) {
            builder.append("*")
            builder.append(picture[j])
            builder.append("*")
            ret.add(builder.toString())
            builder.clear()
        }

        for (i in 0..width)
            builder.append("*")
        ret.add(builder.toString())

        return ret
    }

    /**
     * Two arrays are called similar if one can be obtained from another by swapping at most one
     * pair of elements in one of the arrays. Given two arrays a and b, check whether they are similar.
     */
    fun areSimilar(a: MutableList<Int>, b: MutableList<Int>): Boolean {
        var firstPos = 0
        var secondPos = 0
        if (a.size != b.size)
            return false

        var counter = 0
        for (i in a.indices)
            if (a[i] != b[i]) {
                when (counter) {
                    0 -> {
                        firstPos = i
                        counter++
                    }
                    1 -> {
                        secondPos = i
                        counter++
                    }
                    else -> return false
                }
            }
        return a[firstPos] == b[secondPos] && a[secondPos] == b[firstPos]
    }

    /**
     * You are given an array of integers. On each move you are allowed to increase exactly one of
     * its element by one. Find the minimal number of moves required to obtain a strictly
     * increasing sequence from the input.
     */
    fun arrayChange(inputArray: MutableList<Int>): Int {
        var counter = 0
        for (i in 0 until inputArray.indices.last) {
            while (inputArray[i] >= inputArray[i + 1]) {
                inputArray[i + 1]++
                counter++
            }
        }
        return counter
    }

    /**
     * Given a string, find out if its characters can be rearranged to form a palindrome.
     */
    fun palindromeRearranging(inputString: String): Boolean {
        val numberOfLetters = Array('z' - 'a' + 1) { 0 }

        for (i in inputString.indices)
            numberOfLetters[(inputString[i].toInt() - 'a'.toInt())]++

        var isOdd = false
        if (inputString.length.rem(2) == 1) {
            for (i in numberOfLetters.indices)
                if (numberOfLetters[i].rem(2) == 1)
                    if (!isOdd)
                        isOdd = true
                    else
                        return false
        } else {
            for (i in numberOfLetters.indices)
                if (numberOfLetters[i].rem(2) == 1)
                    return false
        }

        return true
    }

}
