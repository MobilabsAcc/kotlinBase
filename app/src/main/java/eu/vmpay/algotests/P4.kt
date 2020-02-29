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
        var firstTeam = 0
        var secondTeam = 0
        a.forEachIndexed { index, value ->
            if (index % 2 == 0) {
                firstTeam += value
            } else {
                secondTeam += value
            }
        }
        return mutableListOf(firstTeam, secondTeam)
    }

    /**
     * Given a rectangular matrix of characters, add a border of asterisks(*) to it.
     */
    fun addBorder(picture: MutableList<String>): MutableList<String> {
        fun asterixString(n: Int): String {
            return "*".repeat(n)
        }

        val result = mutableListOf(asterixString(picture[0].length + 2))
        for (line in picture) {
            result.add("*${line}*")
        }
        result.add(asterixString(picture[0].length + 2))
        return result
    }

    /**
     * Two arrays are called similar if one can be obtained from another by swapping at most one
     * pair of elements in one of the arrays. Given two arrays a and b, check whether they are similar.
     */
    fun areSimilar(a: MutableList<Int>, b: MutableList<Int>): Boolean {
// 1 2 3     2 1 3
        val pairs = a.zip(b)
        var notMatching = 0
        var notMatchingOne = 0
        var notMatchingTwo = 0
        for ((aa, bb) in pairs) {
            if (aa != bb) {
                notMatching += 1
                if (notMatching == 1) {
                    notMatchingOne = aa
                    notMatchingTwo = bb
                }
                if (notMatching == 2) {
                    if (!((aa == notMatchingOne && bb == notMatchingTwo) || (bb == notMatchingOne && aa == notMatchingTwo))) {
                        return false
                    }
                }
                if (notMatching == 3) {
                    return false
                }
            }
        }
        return notMatching == 0 || notMatching == 2
    }

    /**
     * You are given an array of integers. On each move you are allowed to increase exactly one of
     * its element by one. Find the minimal number of moves required to obtain a strictly
     * increasing sequence from the input.
     */
    fun arrayChange(inputArray: MutableList<Int>): Int {
        var sum = 0
        for (i in 0 until inputArray.size - 1) {
            if (inputArray[i] >= inputArray[i + 1]) {
                val difference = inputArray[i] - inputArray[i + 1] + 1
                sum += difference
                inputArray[i + 1] += difference
            }
        }
        return sum
    }

    /**
     * Given a string, find out if its characters can be rearranged to form a palindrome.
     */
    fun palindromeRearranging(inputString: String): Boolean {
        val map = HashMap<Char, Int>()
        inputString.forEach {
            map[it] = (map[it] ?: 0) + 1
        }
        var odd = false
        for ((_, i) in map) {
            if (i % 2 != 0) {
                if (odd) {
                    return false
                } else {
                    odd = true
                }
            }
        }
        return true
    }

}
