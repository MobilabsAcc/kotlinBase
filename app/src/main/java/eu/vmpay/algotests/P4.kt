package eu.vmpay.algotests

object P4 {
    /**
     * Several people are standing in a row and need to be divided into two teams.
     * The first person goes into team 1, the second goes into team 2, the third goes into team 1 again,
     * the fourth into team 2, and so on. You are given an array of positive integers - the weights of
     * the people. Return an array of two integers, where the first element is the total weight of
     * team 1, and the second element is the total weight of team 2 after the division is complete.
     */
    fun alternatingSums(a: MutableList<Int>): MutableList<Int> {
        var sumTeam1 = 0
        var sumTeam2 = 0
        for (index in 0 until a.size step 2)
            sumTeam1 += a[index]
        for (index in 1 until a.size step 2)
            sumTeam2 += a[index]
        return mutableListOf(sumTeam1, sumTeam2)
    }

    /**
     * Given a rectangular matrix of characters, add a border of asterisks(*) to it.
     */
    fun addBorder(picture: MutableList<String>): MutableList<String> {
        var returnList = mutableListOf<String>()
        var startAndEnd: String = ""
        for (index in 0 until picture[0].length+2)
            startAndEnd += '*'
        returnList.add(startAndEnd)
        for(element in picture){
            returnList.add("*$element*")
        }
        returnList.add(startAndEnd)
        return returnList
    }

    /**
     * Two arrays are called similar if one can be obtained from another by swapping at most one
     * pair of elements in one of the arrays. Given two arrays a and b, check whether they are similar.
     */
    fun areSimilar(a: MutableList<Int>, b: MutableList<Int>): Boolean {
        var differenceIndexes = mutableListOf<Int>()
        for(i in 0 until a.size) {
            when {
                a[i] != b[i] -> differenceIndexes.add(i)
            }
        }
        when{
            differenceIndexes.size == 0 -> return true
            differenceIndexes.size != 2 -> return false
            else -> {
                var tmp = b[differenceIndexes[0]]
                b[differenceIndexes[0]] = b[differenceIndexes[1]]
                b[differenceIndexes[1]] = tmp
            }
        }
        for(i in 0 until a.size){
            when{
                a[i] != b[i] -> return false
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
        var sum = 0
        for(i in 1 until inputArray.size){
            when{
                inputArray[i-1] >= inputArray[i] -> {
                    sum += inputArray[i-1]+1 - inputArray[i]
                    inputArray[i] = inputArray[i-1]+1
                }
            }
        }
        return sum
    }

    /**
     * Given a string, find out if its characters can be rearranged to form a palindrome.
     */
    fun palindromeRearranging(inputString: String): Boolean {
        val characters = inputString.filter{ it in inputString}
            .groupingBy { it }
            .eachCount()
        var odd = 0
        var even = 0
        for(i in characters.values){
            when{
                i % 2 == 0 -> even++
                else -> odd++
            }
        }
        return when{
            (odd == 1 && inputString.length % 2 == 1) || odd == 0 -> true
            else -> false
        }
    }

}
