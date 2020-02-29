package eu.vmpay.algotests

object P3 {

    /**
     * Given an array of strings, return another array containing all of its longest strings.
     * For inputArray = ["aba", "aa", "ad", "vcd", "aba"], the output should be
     * allLongestStrings(inputArray) = ["aba", "vcd", "aba"].
     */
    fun allLongestStrings(inputArray: MutableList<String>): MutableList<String> {
        var max = 0
        val outputArray = mutableListOf<String>()
        for (i in inputArray) {
            if (max < i.length)
                max = i.length
        }
        for (i in inputArray) {
            if (i.length == max)
                outputArray.add(i)
        }
        return outputArray
    }

    /**
     * Given two strings, find the number of common characters between them.
     * For s1 = "aabcc" and s2 = "adcaa", the output should be commonCharacterCount(s1, s2) = 3.
     * Strings have 3 common characters - 2 "a"s and 1 "c".
     */
    fun commonCharacterCount(s1: String, s2: String): Int {
        var sum = 0
        var s1 = s1
        for (i in s2) {
            if (s1.contains(i)) {
                val id = s1.indexOfFirst { it == i }
                s1 = s1.removeRange(id, id + 1)
                sum += 1
            }

        }
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
        val number = n.toString()
        var sum1 = 0
        var sum2 = 0
        for (i in 0 until number.length / 2) {
            sum1 += number[i].toInt()
            sum2 += number[i + number.length / 2].toInt()
        }
        return sum1 == sum2
    }

    /**
     * Some people are standing in a row in a park. There are trees between them which cannot be moved.
     * Your task is to rearrange the people by their heights in a non-descending order
     * without moving the trees. People can be very tall!
     * For a = [-1, 150, 190, 170, -1, -1, 160, 180],
     * the output should be sortByHeight(a) = [-1, 150, 160, 170, -1, -1, 180, 190].
     */
    fun sortByHeight(a: MutableList<Int>): MutableList<Int> {
        var people = a.filterNot { it == -1 }
        people = people.sortedDescending()
        var index = people.size - 1
        for (i in 0 until a.size) {
            if (a[i] != -1)
                a[i] = people[index--]
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
        var i = 0
        var index1 = -1
        var index2:Int
        var substr: String
        var outputString = inputString
        while (outputString.contains('(')) {
            if (i == outputString.length)
                i = 0
            if (outputString[i] == '(')
                index1 = i
            if (outputString[i] == ')') {
                index2 = i
                substr = outputString.substring(index1 + 1, index2)
                substr = substr.reversed()
                outputString = outputString.replaceRange(index1 + 1, index2, substr)
                if(index2 == outputString.length - 1)
                    outputString = outputString.substring(0, index2)
                else
                    outputString = outputString.removeRange(index2, index2 + 1)
                outputString = outputString.removeRange(index1, index1+1)
                i = 0
                continue
            }
            i++
        }
        return outputString
    }
}