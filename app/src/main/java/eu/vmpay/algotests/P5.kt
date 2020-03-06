package eu.vmpay.algotests

import kotlin.math.abs

fun main() {
    val x = P5.boxBlur(
        mutableListOf(
            mutableListOf(1, 2, 3),
            mutableListOf(1, 2, 3),
            mutableListOf(1, 2, 3)
        )
    )
    for (i in 0..x.lastIndex) {
        for (j in 0..x[i].lastIndex) {
            print(x)
            print(" ")
        }
        println(" ")
    }
}

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
    ): Boolean =
        yourLeft.coerceAtLeast(yourRight) == friendsLeft.coerceAtLeast(friendsRight)


    /**
     * Given an array of integers, find the maximal absolute difference between any two of its adjacent elements.
     */
    fun arrayMaximalAdjacentDifference(inputArray: MutableList<Int>): Int {
        var difference = 0
        for (i in 0 until inputArray.lastIndex) {
            if (abs(inputArray[i] - inputArray[i + 1]) > difference)
                difference = abs(inputArray[i] - inputArray[i + 1])
        }
        return difference
    }


    /**
     * An IP address is a numerical label assigned to each device (e.g., computer, printer)
     * participating in a computer network that uses the Internet Protocol for communication.
     * There are two versions of the Internet protocol, and thus two versions of addresses.
     * One of them is the IPv4 address. Given a string, find out if it satisfies the IPv4 address naming rules.
     */
    fun isIPv4Address(inputString: String): Boolean {
        if (inputString.length < 7 || inputString.filter { it == '.' }.length != 3)
            return false
        val address = inputString.plus(".")
        var start = -1
        for (i in 0 until address.lastIndex) {
            if (address[i] == '.') {
                if (!isNumber(address.substring(start + 1, i)))
                    return false
                start = i
            }
        }
        return true
    }

    private fun isNumber(str: String): Boolean {
        if (str.matches("[0-9]+".toRegex()))
            if (str.toInt() == str.toInt().coerceIn(0, 255))
                return true
        return false
    }


    /**
     * You are given an array of integers representing coordinates of obstacles situated on a straight line.
     * Assume that you are jumping from the point with coordinate 0 to the right. You are allowed only
     * to make jumps of the same length represented by some integer. Find the minimal length of the jump
     * enough to avoid all the obstacles.
     */
    fun avoidObstacles(inputArray: MutableList<Int>): Int {
        if (inputArray.isEmpty())
            return 1
        val goodCoordinates = mutableListOf<Int>()
        for (i in 1..inputArray.last() + inputArray.size) {
            if (!inputArray.contains(i))
                goodCoordinates.add(i)
        }
        for (i in 2..inputArray.last()) {
            if (goodCoordinates.count { it % i == 0 } == goodCoordinates.last() / i) {
                return i
            }
        }
        return inputArray.size + 1
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
        val blurredBox = mutableListOf<MutableList<Int>>()
        for (i in 1 until image.lastIndex) {
            blurredBox.add(mutableListOf())
            for (j in 1 until image[i].lastIndex) {
                blurredBox[i - 1].add(countAverage(i, j, image))
            }
        }
        return blurredBox
    }

    private fun countAverage(
        x: Int,
        y: Int,
        matrix: MutableList<MutableList<Int>>
    ): Int {
        var sum = 0
        for (i in x - 1..x + 1)
            for (j in y - 1..y + 1) {
                sum += matrix[i][j]
            }
        return sum / 9
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
        val output = mutableListOf<MutableList<Int>>()
        for (i in 0..matrix.lastIndex) {
            output.add(mutableListOf())
            for (j in 0..matrix[i].lastIndex) {
                output[i].add(countMinedNeighbours(i, j, matrix))
            }
        }
        return output
    }

    private fun countMinedNeighbours(
        x: Int,
        y: Int,
        matrix: MutableList<MutableList<Boolean>>
    ): Int {
        var counter = 0
        for (i in (x - 1).coerceAtLeast(0)..(x + 1).coerceAtMost(matrix.lastIndex))
            for (j in (y - 1).coerceAtLeast(0)..(y + 1).coerceAtMost(matrix[i].lastIndex)) {
                if ((i != x || y != j) && matrix[i][j])
                    counter += 1
            }
        return counter
    }


}