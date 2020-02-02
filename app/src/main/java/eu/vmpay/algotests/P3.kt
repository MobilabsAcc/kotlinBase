package eu.vmpay.algotests

object P3 {

    /**
     * Given an array of strings, return another array containing all of its longest strings.
     * For inputArray = ["aba", "aa", "ad", "vcd", "aba"], the output should be
     * allLongestStrings(inputArray) = ["aba", "vcd", "aba"].
     */
    fun allLongestStrings(inputArray: MutableList<String>): MutableList<String> {
        val maxLength = inputArray.map { it.length }.max()
        return inputArray.filter { it.length == maxLength }.toMutableList()
    }

    /**
     * Given two strings, find the number of common characters between them.
     * For s1 = "aabcc" and s2 = "adcaa", the output should be commonCharacterCount(s1, s2) = 3.
     * Strings have 3 common characters - 2 "a"s and 1 "c".
     */
    fun commonCharacterCount(s1: String, s2: String): Int {
        var tmp = s2
        for (character in s1.asSequence())
            if (tmp.contains(character))
                tmp = tmp.replaceFirst(Character.toString(character), "", false)
        return s2.length - tmp.length
    }

    /**
     * Ticket numbers usually consist of an even number of digits. A ticket number is considered lucky
     * if the sum of the first half of the digits is equal to the sum of the second half.
     * Given a ticket number n, determine if it's lucky or not.
     * For n = 1230, the output should be isLucky(n) = true;
     * For n = 239017, the output should be isLucky(n) = false.
     */
    fun isLucky(n: Int): Boolean {
        var list = n.toString().toCharArray().map { it.toString().toInt() }
        var a = 0
        var b = 0
        for (i in list.indices)
            if (i < list.size / 2) a += list[i] else b += list[i]
        return a == b
    }

    /**
     * Some people are standing in a row in a park. There are trees between them which cannot be moved.
     * Your task is to rearrange the people by their heights in a non-descending order
     * without moving the trees. People can be very tall!
     * For a = [-1, 150, 190, 170, -1, -1, 160, 180],
     * the output should be sortByHeight(a) = [-1, 150, 160, 170, -1, -1, 180, 190].
     */
    fun sortByHeight(a: MutableList<Int>): MutableList<Int> {
        val s = a.filter { it != -1 }.sorted().toMutableList()
        return a.map { if (it == -1) -1 else s.removeAt(0) }.toMutableList()
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
        val closeIndex = inputString.indexOfFirst { it == ')' }
        if (closeIndex == -1) return inputString
        val openIndex = inputString.substring(0, closeIndex).indexOfLast { it == '(' }
        return reverseInParentheses(inputString.substring(0, openIndex) + inputString.substring(openIndex + 1, closeIndex).reversed() + inputString.substring(closeIndex + 1))
    }
}