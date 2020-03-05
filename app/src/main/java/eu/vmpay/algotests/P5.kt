package eu.vmpay.algotests

import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

object P5 {
    /**
     * Call two arms equally strong if the heaviest weights they each are able to lift are equal.
     * Call two people equally strong if their strongest arms are equally strong (the strongest arm
     * can be both the right and the left), and so are their weakest arms. Given your and your
     * friend's arms' lifting capabilities find out if you two are equally strong.
     */
    fun areEquallyStrong(yourLeft: Int, yourRight: Int, friendsLeft: Int, friendsRight: Int): Boolean {
        return max(yourLeft, yourRight) == max(friendsLeft, friendsRight) &&
                min(yourLeft, yourRight) == min(friendsLeft, friendsRight)
    }

    /**
     * Given an array of integers, find the maximal absolute difference between any two of its adjacent elements.
     */
    fun arrayMaximalAdjacentDifference(inputArray: MutableList<Int>): Int {
        if (inputArray.isEmpty() || inputArray.size == 1) {
            return 0
        }
        return inputArray.zipWithNext().map { (a, b) -> abs(a - b)}.max()!!
    }

    /**
     * An IP address is a numerical label assigned to each device (e.g., computer, printer)
     * participating in a computer network that uses the Internet Protocol for communication.
     * There are two versions of the Internet protocol, and thus two versions of addresses.
     * One of them is the IPv4 address. Given a string, find out if it satisfies the IPv4 address naming rules.
     */
    fun isIPv4Address(inputString: String): Boolean {
        fun String.isNumber(): Boolean {
            return try {
                this.toInt()
                true
            } catch(e: NumberFormatException) {
                false
            }
        }
        val chunks = inputString.split(".")
        if (chunks.size != 4) {
            return false
        }
        val result = chunks.map {
            if (it.length in 1..3 && it.isNumber()) {
                1
            } else {
                0
            }
        }.sum()
        return result == 4
    }

    /**
     * You are given an array of integers representing coordinates of obstacles situated on a straight line.
     * Assume that you are jumping from the point with coordinate 0 to the right. You are allowed only
     * to make jumps of the same length represented by some integer. Find the minimal length of the jump
     * enough to avoid all the obstacles.
     */
    fun avoidObstacles(inputArray: MutableList<Int>): Int {
        outerLoop@ for (i in 2 until inputArray.max()!!) {
            for (item in inputArray) {
                if (item % i == 0) {
                    continue@outerLoop
                }
            }
            return i
        }
        return inputArray.max()!! + 1
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
        fun blurPixel(square: MutableList<MutableList<Int>>): Int {
            return square.flatten().sum() / 9
        }

        val blurImage = mutableListOf<MutableList<Int>>()
        for (rowPointer in 0..image.size - 3) {
            val blurRow = mutableListOf<Int>()
            for (columnPointer in 0..image[0].size - 3) {
                val square = mutableListOf<MutableList<Int>>()
                for (i in rowPointer..(rowPointer + 2)) {
                    val squareRow = mutableListOf<Int>()
                    for (j in columnPointer..(columnPointer + 2)) {
                        squareRow.add(image[i][j])
                    }
                    square.add(squareRow)
                }
                blurRow.add(blurPixel(square))
            }
            blurImage.add(blurRow)
        }
        return blurImage
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
        fun Boolean.toInt(): Int {
            return if (this) {
                1
            } else {
                0
            }
        }
        val resultMatrix = mutableListOf<MutableList<Int>>()
        for ((i, row) in matrix.withIndex()) {
            val resultRow = mutableListOf<Int>()
            for((j, value) in row.withIndex()) {
                var sum = 0
                if (i != 0) {
                    sum += matrix[i - 1][j].toInt()
                    if (j != 0) {
                        sum += matrix[i - 1][j - 1].toInt()
                    }
                    if (j != row.size - 1) {
                        sum += matrix[i - 1][j + 1].toInt()
                    }
                }
                if (i != matrix.size - 1) {
                    sum += matrix[i + 1][j].toInt()
                    if (j != 0) {
                        sum += matrix[i + 1][j - 1].toInt()
                    }
                    if (j != row.size - 1) {
                        sum += matrix[i + 1][j + 1].toInt()
                    }
                }
                if (j != 0) {
                    sum += matrix[i][j - 1].toInt()
                }
                if (j != row.size - 1) {
                    sum += matrix[i][j + 1].toInt()
                }
                resultRow.add(sum)
            }
            resultMatrix.add(resultRow)
        }
        return resultMatrix
    }
}