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
        var weightLeft = 0
        var weightRight = 0

        for (i: Int in 0 until a.size){
            if(i % 2 == 0)  weightLeft += a[i]
            else            weightRight += a[i]
        }

        return mutableListOf(weightLeft, weightRight)
    }

    /**
     * Given a rectangular matrix of characters, add a border of asterisks(*) to it.
     */
    fun addBorder(picture: MutableList<String>): MutableList<String> {
        var resultList = ArrayList<String>()

        val size = picture.size + 2
        val howManyInRow = picture[0].length + 2

        for (i: Int in 0 until size){

            if (i == 0 || i == size-1){

                var tmp = ""

                for (j: Int in 0 until howManyInRow){
                    tmp += "*"
                }
                resultList.add(tmp)
            }else
                resultList.add("*" + picture[i - 1] + "*")
        }
        return resultList
    }

    /**
     * Two arrays are called similar if one can be obtained from another by swapping at most one
     * pair of elements in one of the arrays. Given two arrays a and b, check whether they are similar.
     */
    fun areSimilar(a: MutableList<Int>, b: MutableList<Int>): Boolean {

        var tmp = 0

        for(i: Int in 0 until a.size){
            if (a[i] != b[i])   {
                if(findAndSwap(b, a[i], i)) {
                    tmp++
                    if (tmp > 1)    return false
                }else
                    return false
            }
        }
        return true

    }

    fun findAndSwap(arr: MutableList<Int>,x: Int, from: Int) : Boolean{

        for (i: Int in from + 1 until arr.size){
            if(arr[i] == x){

                var tmp = arr[from]
                arr[from] = arr[i]
                arr[i]  = tmp
                return true
            }
        }
        return false
    }

    /**
     * You are given an array of integers. On each move you are allowed to increase exactly one of
     * its element by one. Find the minimal number of moves required to obtain a strictly
     * increasing sequence from the input.
     */
    fun arrayChange(inputArray: MutableList<Int>): Int {

        var howMany = 0

        for (i: Int in 1 until inputArray.size){

            if (inputArray[i] <= inputArray[i - 1]){

                howMany += inputArray[i - 1] - inputArray[i] + 1
                inputArray[i] = inputArray[i - 1] + 1
            }
        }
        return howMany
    }

    /**
     * Given a string, find out if its characters can be rearranged to form a palindrome.
     */
    fun palindromeRearranging(inputString: String): Boolean {

        var map = HashMap<Char, Int>()

        for (i: Char in inputString){
            if(!map.containsKey(i)) map.put(i, 1)
            else                    map.set(i, map.getValue(i) + 1)
        }

        var alert = 0

        for (i: Char in map.keys){
            if (map[i]?.rem(2) ?: 1 != 0)    {
                alert++
                if (alert > 1)  return false
            }
        }

        return true
    }

}
