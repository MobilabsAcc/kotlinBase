package eu.vmpay.algotests

import java.lang.Math.*

object P5 {
    /**
     * Call two arms equally strong if the heaviest weights they each are able to lift are equal.
     * Call two people equally strong if their strongest arms are equally strong (the strongest arm
     * can be both the right and the left), and so are their weakest arms. Given your and your
     * friend's arms' lifting capabilities find out if you two are equally strong.
     */
    fun areEquallyStrong(yourLeft: Int, yourRight: Int, friendsLeft: Int, friendsRight: Int): Boolean {

        return( max(yourLeft, yourRight) == max(friendsLeft, friendsRight) )
                &&
              ( min(yourLeft, yourRight) == min(friendsLeft, friendsRight) )
    }

    /**
     * Given an array of integers, find the maximal absolute difference between any two of its adjacent elements.
     */
    fun arrayMaximalAdjacentDifference(inputArray: MutableList<Int>): Int {

        var max: Int = 0

        for (i: Int in 1 until inputArray.size){
            if (abs(inputArray[i] - inputArray[i - 1]) > max)   max = abs(inputArray[i] - inputArray[i - 1])
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
       var regex = Regex("([0-9]{1,3}\\.){3}[0-9]{1,3}")

        if (!regex.matches(inputString)) return false

        var list = inputString.split(".")

        for (i in list){
            if (i.toInt() < 0 || i.toInt() > 254) return false
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

        var list = ArrayList<Int>()
        list.addAll(inputArray)

        list.sort()


        var tmpList = ArrayList<Int>()

        for (i: Int in 0..list.max()!! + 1)
            if(!list.contains(i))   tmpList.add(i)


        while (hasMod(list, arrayMaximalAdjacentDifference(tmpList)) && tmpList.size > 0){

            tmpList.remove(arrayMaximalAdjacentDifference(tmpList))
        }
        return arrayMaximalAdjacentDifference(tmpList)

    }

    private fun hasMod(list: MutableList<Int>, element: Int) : Boolean{

        for (i in list){
            if (i % element == 0 && i != 0)   return true
        }
        return false
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

        var resultList = ArrayList<ArrayList<Int>>()

        if (image.size < 3 || image[0].size < 3)    return resultList as MutableList<MutableList<Int>>;

        for (i: Int in 0 until image.size - 2){

            var tmpList = ArrayList<Int>()

            for (j: Int in 0 until image[i].size - 2){
                tmpList.add(blur(image, i, j))
            }
            resultList.add(tmpList)
        }
        return resultList as MutableList<MutableList<Int>>
    }

    fun blur(list: MutableList<MutableList<Int>>, a: Int, b: Int): Int{

        var sum = 0

        for (i: Int in a until  a+3){
            for (j: Int in b until  b+3){
                sum += list[i][j]
            }
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

        var tmpList = addBorder(matrix)

        var resultList = ArrayList<ArrayList<Int>>()



        for (i: Int in 0 until matrix.size){

            var tmp = ArrayList<Int>()
            resultList.add(tmp)

            for (j: Int in 0 until matrix[i].size){
                resultList[i].add(neighbour(tmpList, i, j))
            }
        }


        return resultList as MutableList<MutableList<Int>>

    }

    fun neighbour(list: MutableList<MutableList<Boolean>>, a: Int, b: Int): Int{
        var bombs = 0
        var i = a + 1
        var j = b + 1


        if (list[i - 1][j]) bombs++
        if (list[i + 1][j]) bombs++
        if (list[i][j - 1]) bombs++
        if (list[i][j + 1]) bombs++
        if (list[i + 1][j - 1]) bombs++
        if (list[i + 1][j + 1]) bombs++
        if (list[i - 1][j + 1]) bombs++
        if (list[i - 1][j - 1]) bombs++


        return bombs
    }

    fun addBorder (matrix: MutableList<MutableList<Boolean>>): MutableList<MutableList<Boolean>> {

        var resultList = ArrayList<ArrayList<Boolean>>()


        resultList.add(ArrayList<Boolean>())

        for (i: Int in 0 until matrix[0].size+2)
            resultList[0].add(false)


        for (i: Int in 0 until matrix.size){

            resultList.add(ArrayList<Boolean>())

            for (j: Int in -1 until matrix[i].size + 1) {

                if (j == -1 || j == matrix[i].size )    {
                    resultList[i + 1].add(false)
                }
                else{
                    resultList[i + 1].add(matrix[i][j])
                }

            }
        }

        resultList.add(ArrayList<Boolean>())

        for (i: Int in 0 until matrix[0].size+2)
            resultList[matrix.size + 1].add(false)


        return resultList as MutableList<MutableList<Boolean>>
    }
}