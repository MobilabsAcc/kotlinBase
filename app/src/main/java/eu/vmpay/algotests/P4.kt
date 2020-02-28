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
        val sums =  mutableListOf(0, 0)
        var i = 0
        while(i < a.size){
            when{
                i.rem(2) == 0 -> sums[0] += a[i]
                else -> sums[1] += a[i]
            }
            i++
        }
        return sums
    }

    /**
     * Given a rectangular matrix of characters, add a border of asterisks(*) to it.
     */
    fun addBorder(picture: MutableList<String>): MutableList<String> {
        val result = mutableListOf<String>()
        var border = "**"
        for(char in picture[0]){
            border += '*'
        }
        result.add(border)
        for(string in picture){
            result.add("*$string*")
        }
        result.add(border)
        return result
    }

    /**
     * Two arrays are called similar if one can be obtained from another by swapping at most one
     * pair of elements in one of the arrays. Given two arrays a and b, check whether they are similar.
     */
    fun areSimilar(a: MutableList<Int>, b: MutableList<Int>): Boolean {
        if(a.size != b.size)
            return false
        var i = 0
        val toSwap = mutableListOf<Int>()
        while(i < a.size){
            if(a[i] != b[i])
                toSwap.add(i)
            i++
        }
        if(toSwap.size == 0)
            return true
        if(toSwap.size != 2)
            return false
        val temp = a[toSwap[0]]
        a[toSwap[0]] = a[toSwap[1]]
        a[toSwap[1]] = temp
        if(a[toSwap[0]] != b[toSwap[0]] || a[toSwap[1]] != b[toSwap[1]])
            return false
        return true
    }

    /**
     * You are given an array of integers. On each move you are allowed to increase exactly one of
     * its element by one. Find the minimal number of moves required to obtain a strictly
     * increasing sequence from the input.
     */
    fun arrayChange(inputArray: MutableList<Int>): Int {
        var i = 1
        var moves = 0
        while(i < inputArray.size){
            while(inputArray[i-1] >= inputArray[i]){
                inputArray[i]++
                moves++
            }
            i++
        }
        return moves
    }

    /**
     * Given a string, find out if its characters can be rearranged to form a palindrome.
     */
    fun palindromeRearranging(inputString: String): Boolean {
        return inputString
            .toCharArray()
            .distinct()
            .map{val that = it
                    inputString.count { it == that }}
            .filter { it.rem(2) == 1 }
            .count() < 2
    }
}
