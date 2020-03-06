package eu.vmpay.algotests.algorithmictasks

import android.annotation.SuppressLint
import java.lang.Integer.min
import kotlin.math.abs
import kotlin.math.floor
import kotlin.math.max

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
        var yourStrongArm = yourLeft
        var yourWeakestArm = yourRight
        var friendsStrongArm = friendsLeft
        var friendsWeakestArm = friendsRight

        if (yourRight > yourStrongArm) {
            yourStrongArm = yourRight
            yourWeakestArm = yourLeft
        }
        if (friendsRight > friendsStrongArm) {
            friendsStrongArm = friendsRight
            friendsWeakestArm = friendsLeft
        }
        return yourStrongArm == friendsStrongArm && yourWeakestArm == friendsWeakestArm
    }

    /**
     * Given an array of integers, find the maximal absolute difference between any two of its adjacent elements.
     */
    fun arrayMaximalAdjacentDifference(inputArray: MutableList<Int>): Int {
        var result = 0
        val differencesArray = mutableListOf<Int>()

        for (i in 1 until inputArray.size) {
            differencesArray.add(abs(inputArray[i] - inputArray[i - 1]))
        }

        result = differencesArray.max()!!
        return result
    }

    /**
     * An IP address is a numerical label assigned to each device (e.g., computer, printer)
     * participating in a computer network that uses the Internet Protocol for communication.
     * There are two versions of the Internet protocol, and thus two versions of addresses.
     * One of them is the IPv4 address. Given a string, find out if it satisfies the IPv4 address naming rules.
     */
    fun isIPv4Address(inputString: String): Boolean {
        val part = inputString.split('.')
        val isInRange = ArrayList<Int>()

        if (part.size != 4) {
            return false
        } else {
            for (i in part) {
                if (i == "") {
                    return false
                } else {
                    if (i.toInt() in 0..255) {
                        isInRange.add(1)
                    } else {
                        isInRange.add(0)
                    }
                }
            }
        }
        return !isInRange.contains(0)
    }

    /**
     * You are given an array of integers representing coordinates of obstacles situated on a straight line.
     * Assume that you are jumping from the point with coordinate 0 to the right. You are allowed only
     * to make jumps of the same length represented by some integer. Find the minimal length of the jump
     * enough to avoid all the obstacles.
     */
    fun avoidObstacles(inputArray: MutableList<Int>): Int {
        TODO()
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
        val result = mutableListOf<MutableList<Int>>()
        val line = ArrayList<Int>()

        for (i in 0 until image.size - 2) {
            for (j in 0 until image[i].size - 2) {
                var sum = 0
                var count = 0
                for (a in i until i + 3) {
                    for (b in j until j + 3) {
                        sum += image[a][b]
                        count++
                    }
                }
                line.add(floor(sum.div(count).toDouble()).toInt())
            }
        }
        result.add(line)
        return result
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
    @SuppressLint("NewApi")
    fun minesweeper(matrix: MutableList<MutableList<Boolean>>): MutableList<MutableList<Int>> {
        val result = mutableListOf<MutableList<Int>>()

        for (i in 0 until matrix.size) {
            for (j in 0 until matrix[0].size) {
                for (k in max(0, i - 1) until min(i + 1, matrix.size - 1)) {
                    for (l in max(0, j - 1) until min(j + 1, matrix[0].size - 1)) {
                        if (matrix[k][l] && (i != k || l != j)) {
                            result[i][j]++
                        }
                    }
                }
            }
        }
        return result
    }
}