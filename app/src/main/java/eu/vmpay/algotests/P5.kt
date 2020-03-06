package eu.vmpay.algotests

import kotlin.math.absoluteValue
import kotlin.math.floor
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
        val minValue = inputArray.min() ?: return -1
        inputArray.remove(minValue)
        val maxValue = inputArray.max() ?: return -1

        return (minValue - maxValue).absoluteValue
    }

    /**
     * An IP address is a numerical label assigned to each device (e.g., computer, printer)
     * participating in a computer network that uses the Internet Protocol for communication.
     * There are two versions of the Internet protocol, and thus two versions of addresses.
     * One of them is the IPv4 address. Given a string, find out if it satisfies the IPv4 address naming rules.
     */
    fun isIPv4Address(inputString: String): Boolean {
        val IPv4 = inputString.split('.')
        if (IPv4.size != 4) return false

        for(i in 0 until IPv4.size){
            if (IPv4[i].toInt() > 255 || IPv4[i].toInt() < 0) return false else continue
        }
        return true
    }

    /**
     * You are given an array of integers representing coordinates of obstacles situated on a straight line.
     * Assume that you are jumping from the point with coordinate 0 to the right. You are allowed only
     * to make jumps of the same length represented by some integer. Find the minimal length of the jump
     * enough to avoid all the obstacles.
     */
    fun avoidObstacles(inputArray: MutableList<Int>): Int {
        var jumpLenght = 2
        var jumpSumLength = 0

            do {
                if(inputArray.contains(jumpSumLength)) {
                    jumpLenght+=1
                    jumpSumLength = jumpLenght
                } else {
                    jumpSumLength+= jumpLenght
                }
            } while(jumpSumLength <= inputArray.max() ?: return 1)
        return jumpLenght
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
        val imageRows = image.size
        val imageColumns = image[0].size

        val countr: MutableList<MutableList<Int>> = MutableList(imageRows - 2){ MutableList(imageColumns - 2) {0}}
        var list:MutableList<Int>

        for (i in 1 until imageRows -1){
            for(j in 1 until imageColumns -1){
                list = arrayListOf()
                for(k in -1..1){
                    for(l in -1..1){
                        list.add(image[i+k][j+l])
                    }
                }
                countr[i-1][j-1] = floor(list.average()).toInt()
            }
        }

        return countr
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

        val rowNumber = matrix.size
        val columnNumber = matrix[0].size

        val countr: MutableList<MutableList<Int>> = MutableList(rowNumber + 2){ MutableList(columnNumber + 2) {0}}
        val finalMatrix : MutableList<MutableList<Int>> = mutableListOf()

       for (i in 1..rowNumber){
            for(j in 1..columnNumber){
                if(matrix[i-1][j-1]){
                    for(k in -1..1){
                        for(l in -1..1){
                            countr[i+k][j+l]+=1
                        }
                    }
                    countr[i][j]-=1
                }
            }
        }

        for (i in 1..rowNumber){
            val list: MutableList<Int> = mutableListOf()
            for(j in 1..columnNumber){
                list.add(countr[i][j])
            }
            finalMatrix.add(list)
        }

        return finalMatrix
    }
}