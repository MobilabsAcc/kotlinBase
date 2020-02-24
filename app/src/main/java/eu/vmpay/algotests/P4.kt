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
        var weight = 0
        a.forEachIndexed { i, t -> if (i % 2 == 0) weight += t }
        return mutableListOf(weight, a.sum() - weight)
    }

    /**
     * Given a rectangular matrix of characters, add a border of asterisks(*) to it.
     */
    fun addBorder(picture: MutableList<String>): MutableList<String> {
        val bordered = picture.map { "*$it*" }.toMutableList()
        val starRow: String = "*".repeat(bordered[0].length)
        bordered.add(0, starRow)
        bordered.add(starRow)
        return bordered
    }

    /**
     * Two arrays are called similar if one can be obtained from another by swapping at most one
     * pair of elements in one of the arrays. Given two arrays a and b, check whether they are similar.
     */
    fun areSimilar(a: MutableList<Int>, b: MutableList<Int>): Boolean {
        val temp = mutableListOf<Int>()
        a.forEachIndexed { i, t -> if (t != b[i]) temp.add(i) }
        return when (temp.size) {
            0 -> true
            1 -> false
            2 -> a[temp[0]] == b[temp[1]] && a[temp[1]] == b[temp[0]]
            else -> false
        }
    }

    /**
     * You are given an array of integers. On each move you are allowed to increase exactly one of
     * its element by one. Find the minimal number of moves required to obtain a strictly
     * increasing sequence from the input.
     */
    fun arrayChange(inputArray: MutableList<Int>): Int {
        var moves = 0
        for (i in 1 until inputArray.size) {
            if (inputArray[i] <= inputArray[i - 1]) {
                moves += inputArray[i - 1] - inputArray[i] + 1
                inputArray[i] += inputArray[i - 1] - inputArray[i] + 1
            }
        }
        return moves
    }

    /**
     * Given a string, find out if its characters can be rearranged to form a palindrome.
     */
    fun palindromeRearranging(inputString: String): Boolean {
        val set = mutableSetOf<Char>()
        inputString.forEach { if (set.contains(it)) set.remove(it) else set.add(it) }
        return set.size < 2
    }

}
