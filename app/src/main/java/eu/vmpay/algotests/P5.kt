package eu.vmpay.algotests

import kotlin.math.abs

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
        val yourStrength = if (yourLeft > yourRight) yourLeft else yourRight
        val friendStrength = if (friendsLeft > friendsRight) friendsLeft else friendsRight
        return yourStrength == friendStrength
    }

    /**
     * Given an array of integers, find the maximal absolute difference between any two of its adjacent elements.
     */
    fun arrayMaximalAdjacentDifference(inputArray: MutableList<Int>): Int {
        var max = 0
        for (i in 0 until inputArray.indices.last) {
            if (abs(inputArray[i] - inputArray[i + 1]) > max)
                max = abs(inputArray[i] - inputArray[i + 1])
        }
        return max
    }

    /**
     * An IP address is a numerical label assigned to each device (e.g., computer, printer)
     * participating in a computer network that uses the Internet Protocol for communication.
     * There are two versions of the Internet protocol, and thus two versions of addresses.
     * One of them is the IPv4 address. Given a string, find out if it satisfies the IPv4 address naming rules.
     */
    fun isIPv4Address(inputString: String): Boolean {
        val s = inputString.split(".")
        if (s.size != 4)
            return false
        for (i in s.indices)
            if (s[i].toInt() < 0 || s[i].toInt() > 255)
                return false
        return true
    }

    /**
     * You are given an array of integers representing coordinates of obstacles situated on a straight line.
     * Assume that you are jumping from the point with coordinate 0 to the right. You are allowed only
     * to make jumps of the same length represented by some integer. Find the minimal length of the jump
     * enough to avoid all the obstacles.
     */
    fun avoidObstacles(inputArray: MutableList<Int>): Int {
        var minLength = 1
        var collision = true
        val lastObstacles = inputArray.max()
        if (lastObstacles != null) {
            while (collision) {
                collision = false
                var currentPosition = 0
                while (currentPosition < lastObstacles) {
                    currentPosition += minLength
                    if (inputArray.contains(currentPosition)) {
                        collision = true
                        minLength++
                        break
                    }
                }
            }
        }
        return minLength
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
        if (image.size < 3 || image[0].size < 3)
            return mutableListOf()

        val list = mutableListOf<MutableList<Int>>()
        for (i in 1 until image.indices.last) {
            list.add(mutableListOf())
            for (j in 1 until image[0].indices.last) {
                var sum = 0
                for (k in i - 1..i + 1) {
                    for (l in j - 1..j + 1) {
                        sum += image[k][l]
                    }
                }
                list[i - 1].add(sum / 9)
            }
        }
        return list
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
        val list = mutableListOf<MutableList<Int>>()
        for (i in matrix.indices) {
            list.add(mutableListOf())
            for (j in matrix[0].indices) {
                var sum = 0
                var left = 0
                var right = 0
                var up = 0
                var down = 0
                if (i > 0)
                    up--
                if (i < matrix.indices.last)
                    down++
                if (j > 0)
                    left--
                if (j < matrix.indices.last)
                    right++

                for (k in i + up..i + down)
                    for (l in j + left..j + right)
                        if (k != i || l != j)
                            if (matrix[k][l])
                                sum++
                list[i].add(sum)
            }
        }
        return list
    }
}
