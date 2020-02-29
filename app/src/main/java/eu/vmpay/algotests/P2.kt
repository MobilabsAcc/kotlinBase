package eu.vmpay.algotests

object P2 {

    /**
     * Given an array of integers, find the pair of adjacent elements that has the largest product
     * and return that product.
     * For inputArray = [3, 6, -2, -5, 7, 3], the output should be
     * adjacentElementsProduct(inputArray) = 21. 7 and 3 produce the largest product.
     */
    fun adjacentElementsProduct(inputArray: MutableList<Int>): Int {
        var max = Int.MIN_VALUE

        for (i in 0..inputArray.lastIndex) {
            if (i < inputArray.lastIndex) {
                max =
                    if ((inputArray[i] * inputArray[i + 1]) > max) (inputArray[i] * inputArray[i + 1]) else max
            }

        }
        return max
        TODO("not implemented")
    }

    /**
     * Below we will define an n-interesting polygon. Your task is to find the area of a polygon
     * for a given n. A 1-interesting polygon is just a square with a side of length 1. An n-interesting
     * polygon is obtained by taking the n - 1-interesting polygon and appending 1-interesting polygons
     * to its rim, side by side. You can see the 1-, 2-, 3- and 4-interesting polygons in the picture below.
     * For n = 2, the output should be shapeArea(n) = 5;
     * For n = 3, the output should be shapeArea(n) = 13.
     *                                 *
     *                  *            * * *
     *          *     * * *        * * * * *
     *                  *            * * *
     *                                 *
     *          1       2              3
     */
    fun shapeArea(n: Int): Int {
        var m = 2 * n - 1
        for (i in 1 until 2 * n - 1 step 2) {
            m += 2 * i
        }
        return m
        TODO("not implemented")
    }

    /**
     * Ratiorg got statues of different sizes as a present from CodeMaster for his birthday,
     * each statue having an non-negative integer size. Since he likes to make things perfect,
     * he wants to arrange them from smallest to largest so that each statue will be bigger than
     * the previous one exactly by 1. He may need some additional statues to be able to accomplish
     * that. Help him figure out the minimum number of additional statues needed.
     * For statues = [6, 2, 3, 8], the output should be makeArrayConsecutive2(statues) = 3.
     * Ratiorg needs statues of sizes 4, 5 and 7.
     */
    fun makeArrayConsecutive2(statues: MutableList<Int>): Int {
        val x = statues.max()
        val y = statues.min()
        var z: Int = 0

        if (x != null && y != null) {
            z = x - y
        }
        return z - statues.size + 1


        TODO("not implemented")
    }

    /**
     * Given a sequence of integers as an array, determine whether it is possible to obtain a strictly
     * increasing sequence by removing no more than one element from the array.
     * Note: sequence a0, a1, ..., an is considered to be a strictly increasing if a0 < a1 < ... < an.
     * Sequence containing only one element is also considered to be strictly increasing.
     * For sequence = [1, 3, 2, 1], the output should be almostIncreasingSequence(sequence) = false.
     * There is no one element in this array that can be removed in order to get a strictly increasing sequence.
     * For sequence = [1, 3, 2], the output should be almostIncreasingSequence(sequence) = true.
     * You can remove 3 from the array to get the strictly increasing sequence [1, 2]. Alternately,
     * you can remove 2 to get the strictly increasing sequence [1, 3].
     */
    fun almostIncreasingSequence(sequence: MutableList<Int>): Boolean {
        var count = 0
        if( sequence.toSet().size == 1) return true
        if(sequence.toSet().size  <= sequence.size - 2) return false

        val tmp = sequence.dropLast(1).toMutableList()
        val x = sequence.max()
        if(x != null){
            tmp.add(0, x)
        }
        if(almostIncreasingSequence(tmp)) return true

        while (sequence.size > 0) {
            val max = sequence.max()
            val index = sequence.lastIndexOf(max)

            sequence.removeAt(index)

            if (index  != sequence.size) count++
            if (count >= 2) return false
        }
        return true
        TODO("not implemented")
    }

    /**
     * After becoming famous, the CodeBots decided to move into a new building together.
     * Each of the rooms has a different cost, and some of them are free, but there's a rumour that
     * all the free rooms are haunted! Since the CodeBots are quite superstitious, they refuse to stay
     * in any of the free rooms, or any of the rooms below any of the free rooms. Given matrix,
     * a rectangular matrix of integers, where each value represents the cost of the room,
     * your task is to return the total sum of all rooms that are suitable for the CodeBots
     * (ie: add up all the values that don't appear below a 0).
     * For
     * matrix = [[0, 1, 1, 2],
     * [0, 5, 0, 0],
     * [2, 0, 3, 3]]
     * the output should be matrixElementsSum(matrix) = 9.
     * There are several haunted rooms, so we'll disregard them as well as any rooms beneath them.
     * Thus, the answer is 1 + 5 + 1 + 2 = 9.
     * For matrix = [[1, 1, 1, 0],
     * [0, 5, 0, 1],
     * [2, 1, 3, 10]]
     * the output should be matrixElementsSum(matrix) = 9.
     * Note that the free room in the final column makes the full column unsuitable for bots
     * (not just the room directly beneath it). Thus, the answer is 1 + 1 + 1 + 5 + 1 = 9.
     */
    fun matrixElementsSum(matrix: MutableList<MutableList<Int>>): Int {
        var sum = 0
        val tmp = mutableListOf<Int>()
        for(i in 0 until matrix[0].size){
            tmp.add(i, 1)
        }
        for (i in 0 until matrix.size) {
            for (j in 0 until matrix[i].size) {
                if(matrix[i][j] == 0){
                    tmp[j] = 0
                }
                if( tmp[j] != 0){
                    sum += matrix[i][j]
                }
            }
        }
        return sum

        TODO("not implemented")

    }

}