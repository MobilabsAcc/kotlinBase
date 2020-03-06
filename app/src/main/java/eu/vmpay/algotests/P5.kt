package eu.vmpay.algotests

import kotlin.math.max
import kotlin.math.min

object P5 {
    /**
     * Call two arms equally strong if the heaviest weights they each are able to lift are equal.
     * Call two people equally strong if their strongest arms are equally strong (the strongest arm
     * can be both the right and the left), and so are their weakest arms. Given your and your
     * friend's arms' lifting capabilities find out if you two are equally strong.
     */
    fun areEquallyStrong(
        yourLeft: Int,
        yourRight: Int,
        friendsLeft: Int,
        friendsRight: Int
    ): Boolean {
        if (max(yourLeft, yourRight) == max(friendsLeft, friendsRight) && min(
                yourLeft,
                yourRight
            ) == min(friendsLeft, friendsRight)
        ) return true
        return false
        TODO("not implemented")
    }

    /**
     * Given an array of integers, find the maximal absolute difference between any two of its adjacent elements.
     */
    fun arrayMaximalAdjacentDifference(inputArray: MutableList<Int>): Int {
        var high = 0
        for (item in 0 until inputArray.size) {
            high =
                if (Math.abs((inputArray[item] - inputArray[item + 1])) > high) Math.abs((inputArray[item] - inputArray[item + 1])) else high
        }
        return high
        TODO("not implemented")
    }

    /**
     * An IP address is a numerical label assigned to each device (e.g., computer, printer)
     * participating in a computer network that uses the Internet Protocol for communication.
     * There are two versions of the Internet protocol, and thus two versions of addresses.
     * One of them is the IPv4 address. Given a string, find out if it satisfies the IPv4 address naming rules.
     */
    fun isIPv4Address(inputString: String): Boolean {
        TODO("not implemented")
    }

    /**
     * You are given an array of integers representing coordinates of obstacles situated on a straight line.
     * Assume that you are jumping from the point with coordinate 0 to the right. You are allowed only
     * to make jumps of the same length represented by some integer. Find the minimal length of the jump
     * enough to avoid all the obstacles.
     */
    fun avoidObstacles(inputArray: MutableList<Int>): Int {
        var minLen = if (inputArray.size != 0) 2 else return 0
        for (item in inputArray) {
            while (item % minLen == 0) {
                minLen++
            }
            return minLen
        }
        TODO("not implemented")
    }

    /**
     * Last night you partied a little too hard. Now there's a black and white photo of you that's
     * about to go viral! You can't let this ruin your reputation, so you want to apply the box blur
     * algorithm to the photo to hide its content. The pixels in the input image are represented as
     * integers. The algorithm distorts the input image in the following way: Every pixel x in the
     * output image has a value equal to the average value of the pixel values from the 3 × 3 square
     * that has its center at x, including x itself. All the pixels on the border of x are then removed.
     * Return the blurred image as an integer, with the fractions rounded down.
     */
    fun boxBlur(image: MutableList<MutableList<Int>>): MutableList<MutableList<Int>> {
        TODO("not implemented")
    }

    /**
     * In the popular Minesweeper game you have a board with some mines and those cells that don't
     * ontain a mine have a number in it that indicates the total number of mines in the neighboring cells.
     * Starting off with some arrangement of mines we want to create a Minesweeper game setup.
     * Example
     * For
     * matrix = [[true, false, false],
     * [false, true, false],
     * [false, false, false]]
     * the output should be
     * minesweeper(matrix) = [[1, 2, 1],
     * [2, 1, 1],
     * [1, 1, 1]]
     */
    fun minesweeper(matrix: MutableList<MutableList<Boolean>>): MutableList<MutableList<Int>> {
        val newList = mutableListOf<MutableList<Int>>()
        for (i in 0 until matrix.size) {
            newList.add(mutableListOf<Int>())
            for (j in 0 until matrix[i].size) {
                var tmp = 0
                if (j - 1 >= 0) {
                    if (i - 1 >= 0) {
                        if (matrix[i - 1][j - 1]) tmp++
                    }
                    if (i + 1 < matrix.size) {
                        if (matrix[i + 1][j - 1]) tmp++
                    }
                    if (matrix[i][j - 1]) tmp++
                }
                if (j + 1 < matrix[i].size) {
                    if (i - 1 >= 0) {
                        if (matrix[i - 1][j + 1]) tmp++
                    }
                    if (i + 1 < matrix.size) {
                        if (matrix[i + 1][j + 1]) tmp++
                    }
                    if (matrix[i][j + 1]) tmp++
                }
                if (i - 1 >= 0) {
                    if (matrix[i - 1][j]) tmp++
                }
                if (i + 1 < matrix.size) {
                    if (matrix[i + 1][j])tmp++
                }
                newList[i].add(tmp)
            }
        }
        return newList
    }


}