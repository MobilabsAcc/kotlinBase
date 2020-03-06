package eu.vmpay.algotests

import java.lang.Math.abs


object P5 {
    /**
     * Call two arms equally strong if the heaviest weights they each are able to lift are equal.
     * Call two people equally strong if their strongest arms are equally strong (the strongest arm
     * can be both the right and the left), and so are their weakest arms. Given your and your
     * friend's arms' lifting capabilities find out if you two are equally strong.
     */
    fun areEquallyStrong(yourLeft: Int, yourRight: Int, friendsLeft: Int, friendsRight: Int): Boolean {
        var yourStrong: Int = yourLeft
        if(yourStrong < yourRight)
            yourStrong = yourRight
        var friendsStrong : Int = friendsLeft
        if(friendsStrong < friendsRight)
            friendsStrong = friendsRight
        return friendsStrong==yourStrong

    }

    /**
     * Given an array of integers, find the maximal absolute difference between any two of its adjacent elements.
     */
    fun arrayMaximalAdjacentDifference(inputArray: MutableList<Int>): Int {
        if(inputArray.size < 2)
            return 0
        var max:Int = abs(inputArray[0]-inputArray[1])
        for( i in 1 until inputArray.size - 1){
            if(max < abs(inputArray[i]-inputArray[i+1]))
                max = abs(inputArray[i]-inputArray[i+1])
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
        if(inputString.length > 15  || inputString.length < 7 || inputString.filter { it=='.' }.length!=3)
            return false
        val temp = inputString.plus('.')
        var start = -1
        var part:String
        for (i in temp.indices){
            if(temp[i] == '.') {
                if(start + 1 == i)
                    return false
                part = temp.substring(start + 1, i)
                if(part.toInt() > 255 || part.toInt() < 0)
                    return false
                start = i
            }
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
        if(inputArray.isEmpty())
            return 1

        for(i in 2 until inputArray[inputArray.size-1]){
            var j = 0
            while (j <= inputArray[inputArray.size-1]){
                j+=i
                if(inputArray.contains(j))
                    break
            }
            if(j > inputArray[inputArray.size-1])
                return i
        }
        return inputArray[inputArray.size-1]+1
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
        val blurred = mutableListOf<MutableList<Int>>()
        for(i in 1 until image.size - 1){
            blurred.add(mutableListOf())
            for(j in 1 until image[i].size -1){
                var sum = 0
                for(a in i-1 until (i+2)) {
                    for (b in j-1 until j+2)
                        sum+=image[a][b]
                }
                blurred[i-1].add(sum/9)
            }
        }
        return blurred
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
        val outputMatrix = mutableListOf<MutableList<Int>>()
        for(i in 0 until matrix.size){
            outputMatrix.add(mutableListOf())
            for(j in 0 until matrix[i]. size){
                var sum = 0
                for(a in (i-1).coerceAtLeast(0) .. (i +1).coerceAtMost(matrix.size -1)){
                    for(b in (j-1).coerceAtLeast(0) .. (j +1).coerceAtMost(matrix[i].size -1)){
                       if(a==i && b==j)
                           continue
                        if(matrix[a][b])
                            sum+=1
                    }
                }
                outputMatrix[i].add(sum)
            }
        }
         return outputMatrix
    }
}