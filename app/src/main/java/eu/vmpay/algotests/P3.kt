package eu.vmpay.algotests

import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.min

object P3 {

    /**
     * Given an array of strings, return another array containing all of its longest strings.
     * For inputArray = ["aba", "aa", "ad", "vcd", "aba"], the output should be
     * allLongestStrings(inputArray) = ["aba", "vcd", "aba"].
     */
    fun allLongestStrings(inputArray: MutableList<String>): MutableList<String> {
        val longestStrings = ArrayList<String>()
        var stringLength = 0
        for (i in inputArray.indices) {
            if (inputArray[i].length >= stringLength) {
                if (inputArray[i].length > stringLength) {
                    stringLength = inputArray[i].length
                    longestStrings.clear()
                }
                longestStrings.add(inputArray[i])
            }
        }
        return longestStrings
    }

    /**
     * Given two strings, find the number of common characters between them.
     * For s1 = "aabcc" and s2 = "adcaa", the output should be commonCharacterCount(s1, s2) = 3.
     * Strings have 3 common characters - 2 "a"s and 1 "c".
     */
    fun commonCharacterCount(s1: String, s2: String): Int {
        val s1Counter = Array('z' - 'a' + 1) { 0 }
        val s2Counter = Array('z' - 'a' + 1) { 0 }
        for (i in s1.indices)
            s1Counter[(s1[i].toInt() - 'a'.toInt())]++
        for (i in s2.indices)
            s2Counter[(s2[i].toInt() - 'a'.toInt())]++

        var sum = 0
        for (i in s1Counter.indices)
            sum += min(s1Counter[i], s2Counter[i])

        return sum
    }

    /**
     * Ticket numbers usually consist of an even number of digits. A ticket number is considered lucky
     * if the sum of the first half of the digits is equal to the sum of the second half.
     * Given a ticket number n, determine if it's lucky or not.
     * For n = 1230, the output should be isLucky(n) = true;
     * For n = 239017, the output should be isLucky(n) = false.
     */
    fun isLucky(n: Int): Boolean {
        val s = n.toString()
        val size = s.length / 2

        var firstHalf = 0
        var secondHalf = 0
        for (i in 0 until size) {
            firstHalf += s[i].toInt()
            secondHalf += s[i + size].toInt()

        }
        return firstHalf == secondHalf
    }

    /**
     * Some people are standing in a row in a park. There are trees between them which cannot be moved.
     * Your task is to rearrange the people by their heights in a non-descending order
     * without moving the trees. People can be very tall!
     * For a = [-1, 150, 190, 170, -1, -1, 160, 180],
     * the output should be sortByHeight(a) = [-1, 150, 160, 170, -1, -1, 180, 190].
     */
    fun sortByHeight(a: MutableList<Int>): MutableList<Int> {
        val b = ArrayList<Int>()

        for (i in a.indices)
            if (a[i] != -1)
                b.add(a[i])

        b.sort()
        var j = 0
        for (i in a.indices)
            if (a[i] != -1) {
                a[i] = b[j]
                j++
            }

        return a
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
        var level = 0
        var count = 0
        var newString = inputString
        var s: String
        val starting = Stack<Int>()
        val ending = Stack<Int>()

        for (i in inputString.indices) {
            if (inputString[i] == '(') {
                starting.add(i)
                level++
            }
            if (inputString[i] == ')') {
                ending.add(ending.size - count, i - count*2)
                count = if (level > 1)
                    level - 1
                else
                    0
                level--
            }
        }

        val builder = StringBuilder()

        var start: Int
        var end: Int

        while (!starting.empty()) {
            start = starting.pop()
            end = ending.pop()
            s = newString.substring(start + 1, end)
            s = s.reversed()
            for (i in 0 until start)
                builder.append(newString[i])
            for (i in s.indices)
                builder.append(s[i])
            for (i in (end + 1)..newString.indices.last)
                builder.append(newString[i])
            newString = builder.toString()
            builder.clear()
        }
        return newString
    }
}