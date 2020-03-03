package eu.vmpay.algotests.algorithmictasks

object P3 {

    /**
     * Given an array of strings, return another array containing all of its longest strings.
     * For inputArray = ["aba", "aa", "ad", "vcd", "aba"], the output should be
     * allLongestStrings(inputArray) = ["aba", "vcd", "aba"].
     */
    fun allLongestStrings(inputArray: MutableList<String>): MutableList<String> {
        var maxLength = inputArray[0].length
        val resultList: MutableList<String> = mutableListOf()

        for (i in inputArray){
            if(i.length > maxLength){
                maxLength = i.length
            }
        }
        for(i in inputArray){
            if(i.length == maxLength){
                resultList.add(i)
            }
        }
        return resultList
    }

    /**
     * Given two strings, find the number of common characters between them.
     * For s1 = "aabcc" and s2 = "adcaa", the output should be commonCharacterCount(s1, s2) = 3.
     * Strings have 3 common characters - 2 "a"s and 1 "c".
     */
    fun commonCharacterCount(s1: String, s2: String): Int{

        val s1CharsArray: ArrayList<Char> = ArrayList()
        val s2CharsArray: ArrayList<Char> = ArrayList()

        for (character in s1.toCharArray()) {
            s1CharsArray.add(character)
        }

        for (character in s2.toCharArray()) {
            s2CharsArray.add(character)
        }

        var commonLetters = 0
        for (i in s2CharsArray) {
            if (s1CharsArray.contains(i)) {
                s1CharsArray.remove(i)
                commonLetters++
            }
        }
        return commonLetters
    }

    /**
     * Ticket numbers usually consist of an even number of digits. A ticket number is considered lucky
     * if the sum of the first half of the digits is equal to the sum of the second half.
     * Given a ticket number n, determine if it's lucky or not.
     * For n = 1230, the output should be isLucky(n) = true;
     * For n = 239017, the output should be isLucky(n) = false.
     */
    fun isLucky(n: Int): Boolean {
        var equals = false
        val numberOfDigits = n.toString().length

        if (numberOfDigits.rem(2) != 0) {
            equals = false
        } else {
            var baseDivider = 10

            while (n.div(baseDivider) > baseDivider) {
                baseDivider *= 10
            }

            var leftNumber = n.div(baseDivider)
            var rightNumber = n.rem(baseDivider)
            var sumInLeftNumber = 0
            var sumInRightNumber = 0

            while (leftNumber != 0) {
                sumInLeftNumber += leftNumber.rem(10)
                leftNumber /= 10
            }

            while (rightNumber != 0) {
                sumInRightNumber += rightNumber.rem(10)
                rightNumber /= 10
            }

            if (sumInLeftNumber == sumInRightNumber) {
                equals = true
            }
        }
        return equals
    }

    /**
     * Some people are standing in a row in a park. There are trees between them which cannot be moved.
     * Your task is to rearrange the people by their heights in a non-descending order
     * without moving the trees. People can be very tall!
     * For a = [-1, 150, 190, 170, -1, -1, 160, 180],
     * the output should be sortByHeight(a) = [-1, 150, 160, 170, -1, -1, 180, 190].
     */
    fun sortByHeight(a: MutableList<Int>): MutableList<Int> {
        val listOfTrees: ArrayList<Int> = ArrayList()
        val listOfPeople: ArrayList<Int> = ArrayList()
        val indexesOfTrees: ArrayList<Int> = ArrayList()

        for (i in 0 until a.size) {
            if (a[i] == -1) {
                listOfTrees.add(a[i])
                indexesOfTrees.add(i)
            } else {
                listOfPeople.add(a[i])
                listOfPeople.sort()
            }
        }

        for(i in 0 until indexesOfTrees.size){
            listOfPeople.add(indexesOfTrees[i], -1)
        }

        return listOfPeople.toMutableList()
    }

    /**
     * Write a function that reverses characters in (possibly nested) parentheses in the input string.
     * Input strings will always be well-formed with matching ()s.
     * For inputString = "(bar)", the output should be reverseInParentheses(inputString) = "rab";
     * For inputString = "foo(bar)baz", the output should be
     * reverseInParentheses(inputString) = "foorabbaz";
     * For inputString = "foo(bar)baz(blim)", the output should be
     * reverseInParentheses(inputString) = "foorabbazmilb";
     * For inputString = "foo(bar(baz))blim", the output should be
     * reverseInParentheses(inputString) = "foobazrabblim".
     * Because "foo(bar(baz))blim" becomes "foo(barzab)blim" and then "foobazrabblim".
     */
    fun reverseInParentheses(inputString: String): String {
        var result: String = ""

        while(inputString.contains("(")){
            val start = inputString.lastIndexOf("(")
            val end = inputString.indexOf(")", inputString.lastIndexOf("("))

            result = inputString.substring(0, start) + inputString.substring(start + 1, end).reversed() +
                    inputString.substring(end + 1, inputString.length)
        }
        return result
    }
}