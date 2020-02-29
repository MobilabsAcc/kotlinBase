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
        var first = 0
        for (item in 0 until a.size step 2) {
            first += a[item]
        }
        return mutableListOf(first, a.sum() - first)
        TODO("not implemented")
    }

    /**
     * Given a rectangular matrix of characters, add a border of asterisks(*) to it.
     */
    fun addBorder(picture: MutableList<String>): MutableList<String> {
        var tmp: String
        val newList = mutableListOf<String>()
        var firstLine = ""
        for (i in 0..picture[0].length + 1) {
            firstLine += "*"
        }
        newList.add(0, firstLine)
        for (item in picture) {
            tmp = "*$item*"
            newList.add(tmp)
        }
        newList.add(firstLine)
        return newList
        TODO("not implemented")
    }

    /**
     * Two arrays are called similar if one can be obtained from another by swapping at most one
     * pair of elements in one of the arrays. Given two arrays a and b, check whether they are similar.
     */
    fun areSimilar(a: MutableList<Int>, b: MutableList<Int>): Boolean {
        var counter = 0
        if(a.sorted() != b.sorted())return false

        for(i in 0..a.lastIndex){
            if(a[i] != b[i])counter++
            if(counter == 3)return false
        }
        return true
        TODO("not implemented")
    }

    /**
     * You are given an array of integers. On each move you are allowed to increase exactly one of
     * its element by one. Find the minimal number of moves required to obtain a strictly
     * increasing sequence from the input.
     */
    fun arrayChange(inputArray: MutableList<Int>): Int {
        var sum = 0
        for(i in 0 until inputArray.lastIndex){
            if(inputArray[i+1] <= inputArray[i] ) {
                sum += inputArray[i] - inputArray[i+1] + 1
                inputArray[i+1] = inputArray[i] + 1
            }
        }
        return sum
        TODO("not implemented")
    }

    /**
     * Given a string, find out if its characters can be rearranged to form a palindrome.
     */
    fun palindromeRearranging(inputString: String): Boolean {
        val newList = inputString.toSet()
        var count = 0
        for (item in newList) {
            if (inputString.count { item == it } % 2 != 0 && inputString.length % 2 != 0) {
                count++
            }
            if ((inputString.length % 2 != 0 && count > 1) || (inputString.count { item == it } % 2 != 0 && inputString.length % 2 == 0)) {
                return false
            }
        }
        return true
        TODO("not implemented")
    }

}
