package eu.vmpay.algotests

import java.util.*

object P3 {

    /**
     * Given an array of strings, return another array containing all of its longest strings.
     * For inputArray = ["aba", "aa", "ad", "vcd", "aba"], the output should be
     * allLongestStrings(inputArray) = ["aba", "vcd", "aba"].
     */
    fun allLongestStrings(inputArray: MutableList<String>): MutableList<String> {
        val longestString: MutableList<String> = arrayListOf()
        var maxSizeString = 0

        for (i in 0 until inputArray.size)
            if (inputArray[i].length >= maxSizeString ) maxSizeString = inputArray[i].length

        for (i in 0 until inputArray.size)
            if (inputArray[i].length == maxSizeString ) longestString.add(inputArray[i])

        return longestString
    }

    /**
     * Given two strings, find the number of common characters between them.
     * For s1 = "aabcc" and s2 = "adcaa", the output should be commonCharacterCount(s1, s2) = 3.
     * Strings have 3 common characters - 2 "a"s and 1 "c".
     */
    fun commonCharacterCount(s1: String, s2: String): Int {
        var counter = 0

        val list : MutableList<Char> = arrayListOf()

        for (aChar in s1.toCharArray()) {
            list.add(aChar)
        }

        for (c in s2.toCharArray()) {
            if (list.contains(c)) {
                list.remove(Character.valueOf(c))
                counter++
            }
        }
        return counter
    }

    /**
     * Ticket numbers usually consist of an even number of digits. A ticket number is considered lucky
     * if the sum of the first half of the digits is equal to the sum of the second half.
     * Given a ticket number n, determine if it's lucky or not.
     * For n = 1230, the output should be isLucky(n) = true;
     * For n = 239017, the output should be isLucky(n) = false.
     */
    fun isLucky(n: Int): Boolean {

        val number: String = n.toString()
        val first = number.substring(0, number.length/2)
        val second = number.substring(number.length/2, number.length)
        var firstSum = 0
        var secondSum = 0

        for (i in 0 until first.length) firstSum += first.toCharArray()[i].toInt()
        for (i in 0 until second.length) secondSum += second.toCharArray()[i].toInt()

        return firstSum == secondSum

    }

    /**
     * Some people are standing in a row in a park. There are trees between them which cannot be moved.
     * Your task is to rearrange the people by their heights in a non-descending order
     * without moving the trees. People can be very tall!
     * For a = [-1, 150, 190, 170, -1, -1, 160, 180],
     * the output should be sortByHeight(a) = [-1, 150, 160, 170, -1, -1, 180, 190].
     */
    fun sortByHeight(a: MutableList<Int>): MutableList<Int> {
        val b: MutableList<Int> = arrayListOf()
        val treeIndex: MutableList<Int> = arrayListOf()

        for (i in 0 until a.size) if ( a[i] != -1 ) b.add(a[i]) else treeIndex.add(i)

        val c: MutableList<Int> = b.sorted().toMutableList()

        for (i in 0 until treeIndex.size) c.add(treeIndex[i], -1 )

        return c

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
        var reverseList:String = inputString

        while (reverseList.contains('(')){
            val startIndex = reverseList.lastIndexOf('(')
            val endIndex = reverseList.indexOf(')', reverseList.lastIndexOf('('))
            reverseList = reverseList.slice(0 until  startIndex) +
                    reverseList.slice(startIndex +1 until endIndex).reversed() +
                    reverseList.slice(endIndex +1 until reverseList.length)
        }
        return reverseList
    }
}