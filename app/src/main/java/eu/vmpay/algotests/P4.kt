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
        val sum = mutableListOf<Int>(0,0)
        for(i in 0 until a.size){
            if(i%2 == 0 )
                sum[0]+=a[i]
            else
                sum[1]+=a[i]
        }
        return sum
    }

    /**
     * Given a rectangular matrix of characters, add a border of asterisks(*) to it.
     */
    fun addBorder(picture: MutableList<String>): MutableList<String> {
        val outputString = mutableListOf<String>()
        val stars = "*".repeat(picture[0].length+2)
        for(i in 0 until picture.size + 2){
            if(i == 0 || i == picture.size+1)
                outputString.add(stars)
            else
                outputString.add("*".plus(picture[i-1]).plus("*"))
        }
        return outputString
    }

    /**
     * Two arrays are called similar if one can be obtained from another by swapping at most one
     * pair of elements in one of the arrays. Given two arrays a and b, check whether they are similar.
     */
    fun areSimilar(a: MutableList<Int>, b: MutableList<Int>): Boolean {
        if( a.size != b.size)
            return false
        val indexes = mutableListOf<Int>()
        for(i in 0 until a.size){
            if(a[i] != b[i])
                indexes.add(i)
        }
        if(indexes.size == 0 || (indexes.size == 2 && a[indexes[0]] == b[indexes[1]] && a[indexes[1]] == b[indexes[0]]))
            return true
        return false
    }

    /**
     * You are given an array of integers. On each move you are allowed to increase exactly one of
     * its element by one. Find the minimal number of moves required to obtain a strictly
     * increasing sequence from the input.
     */
    fun arrayChange(inputArray: MutableList<Int>): Int {
        var steps = 0
        val outputArray = inputArray
        for(i in 1 until inputArray.size){
            if(outputArray[i] <= outputArray[i-1]){
                steps+=outputArray[i-1]-outputArray[i]+1
                outputArray[i] += outputArray[i-1]-outputArray[i]+1
            }
        }
        return steps
    }

    /**
     * Given a string, find out if its characters can be rearranged to form a palindrome.
     */
    fun palindromeRearranging(inputString: String): Boolean {
        val characterList = mutableListOf<Char>()
        val charCount= mutableListOf<Int>()
        for(i in inputString) {
            if(characterList.contains(i))
                charCount[characterList.indexOf(i)] +=1
            else {
                characterList.add(i)
                charCount.add(1)
            }
        }
        if(charCount.filter { it%2 ==1 }.size > 1)
            return false
        return true
    }

}
