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
        val firstTeam: MutableList<Int> = ArrayList<Int>()
        val secondTeam: MutableList<Int> = ArrayList<Int>()

        for (i in 0 until a.size step 2){
            firstTeam.add(a[i])
        }

        for (i in 1 until a.size step 2){
            secondTeam.add(a[i])
        }

        var sum1 = 0
        var sum2 = 0
        val result: MutableList<Int> = ArrayList<Int>()

        for(i in firstTeam){
            sum1 += i
        }

        for(i in secondTeam){
            sum2 += i
        }
        result.add(sum1)
        result.add(sum2)

        return result
    }

    /**
     * Given a rectangular matrix of characters, add a border of asterisks(*) to it.
     */
    fun addBorder(picture: MutableList<String>): MutableList<String> {
        val result: MutableList<String> = ArrayList<String>()
        var asterisks = ""

        for (i in 0 until picture[0].length + 2){
            asterisks += '*'
        }

        result.add(asterisks)

        for (string in picture){
            result.add("*${string}*")
        }

        result.add(asterisks)
        return result
    }

    /**
     * Two arrays are called similar if one can be obtained from another by swapping at most one
     * pair of elements in one of the arrays. Given two arrays a and b, check whether they are similar.
     */
    fun areSimilar(a: MutableList<Int>, b: MutableList<Int>): Boolean {
        var isSimilar = false

        fun swipe(input: MutableList<Int>, firstIndex: Int, lastIndex: Int): MutableList<Int>{
            val swipedArray = input
            swipedArray[firstIndex] = input[lastIndex]
            swipedArray[lastIndex] = input[firstIndex]
            return swipedArray
        }

        if(a == b){
            return true
        }else{
            for(i in 0 until a.size){
                for(j in 0 until b.size){
                    if(a[i] == b[j]){
                        isSimilar = true
                    }
                }
            }
        }
        return isSimilar
    }

    /**
     * You are given an array of integers. On each move you are allowed to increase exactly one of
     * its element by one. Find the minimal number of moves required to obtain a strictly
     * increasing sequence from the input.
     */
    fun arrayChange(inputArray: MutableList<Int>): Int {
        var result = 0

        for(i in 1 until inputArray.size){
            while (inputArray[i] <= inputArray[i-1]){
                inputArray[i]++
                result++
            }
        }
        return result
    }

    /**
     * Given a string, find out if its characters can be rearranged to form a palindrome.
     */
    fun palindromeRearranging(inputString: String): Boolean {
        val numberOfChars: HashMap<Char, Int> = HashMap()

        var c: Char
        var counter: Int

        for(i in inputString.indices){
            c = inputString[i]
            counter = 0
            for(j in inputString.indices){
                if(inputString[j] == c){
                    counter++
                    numberOfChars[c] = counter
                }
            }
        }

        var isOdd = 0

        for(i in numberOfChars.values){
            if(i.rem(2) == 1){
                isOdd++
            }
        }
        if(isOdd > 1){
            return false
        }
        return true
    }

}
