package eu.vmpay.algotests

object P3 {

    /**
     * Given an array of strings, return another array containing all of its longest strings.
     * For inputArray = ["aba", "aa", "ad", "vcd", "aba"], the output should be
     * allLongestStrings(inputArray) = ["aba", "vcd", "aba"].
     */
    fun allLongestStrings(inputArray: MutableList<String>): MutableList<String> {
        var nowa = mutableListOf<String>()
        var max: Int = 0
        for (i in 0 .. inputArray.indices.last) {
            if (inputArray[i].length > max) {
                max = inputArray[i].length
            }
        }
        println(max)
        for (i in 0 ..inputArray.indices.last) {
            if (inputArray[i].length == max) {
                nowa.add(inputArray[i])
            }
        }
        return nowa
    }

    /**
     * Given two strings, find the number of common characters between them.
     * For s1 = "aabcc" and s2 = "adcaa", the output should be commonCharacterCount(s1, s2) = 3.
     * Strings have 3 common characters - 2 "a"s and 1 "c".
     */
    fun commonCharacterCount(s1: String, s2: String): Int {
        var s3 = s1.toCharArray()
        var s4 = s2.toCharArray()
        var suma = 0
        for (i in 0..s3.indices.last) {
            for (j in 0..s4.indices.last) {
                if (s3[i] == s4[j]) {
                    suma++
                    s4[j]='0'
                    println(s4)
                    println(s3)
                    println(suma)
                    break
                }
            }
        }
        return suma
    }

    /**
     * Ticket numbers usually consist of an even number of digits. A ticket number is considered lucky
     * if the sum of the first half of the digits is equal to the sum of the second half.
     * Given a ticket number n, determine if it's lucky or not.
     * For n = 1230, the output should be isLucky(n) = true;
     * For n = 239017, the output should be isLucky(n) = false.
     */
    fun isLucky(n: Int): Boolean {
        var sum = 0
        var suma = 0
        val string = n.toString()
        println(string)
        val arr = string.toList()
        println(arr)
        val arrOfInt = arr.map { it.toString().toInt() }
        println(arrOfInt)
        println(arrOfInt.indices.last / 2)
        for (i in 0 .. ((arrOfInt.indices.last+1) / 2)-1) {
            sum += arrOfInt[i]
        }
        println(sum)
        for (i in ((arrOfInt.indices.last+1) / 2) .. arrOfInt.indices.last) {
            suma += arrOfInt[i]
        }
        println(suma)
        if (sum == suma) {
            return true
        } else {
            return false
        }
    }

    /**
     * Some people are standing in a row in a park. There are trees between them which cannot be moved.
     * Your task is to rearrange the people by their heights in a non-descending order
     * without moving the trees. People can be very tall!
     * For a = [-1, 150, 190, 170, -1, -1, 160, 180],
     * the output should be sortByHeight(a) = [-1, 150, 160, 170, -1, -1, 180, 190].
     */
    fun sortByHeight(a: MutableList<Int>): MutableList<Int> {
        var heights = mutableListOf<Int>()
        for (i in a) {
            if (i >= 0) {
                heights.add(i)
            }
        }
        bubblesort(heights)
        var j = 0
        for (i in 0..a.indices.last) {
            if (a[i] >= 0) {
                a[i] = heights[j]
                j++
            }
        }
        return a
    }

    fun bubblesort(lista: MutableList<Int>): MutableList<Int> {

        for (j: Int in 0 until lista.indices.last) {
            for (i: Int in 0 until lista.size - j - 1) {
                if (lista[i + 1] < lista[i]) {
                    val t: Int = lista[i]
                    lista[i] = lista[i + 1]
                    lista[i + 1] = t
                }
            }
        }
        return lista
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
        var s = inputString
        while (s.indexOf("(") != -1) {
            s = reverseP(s)
        }
        return s
    }

    fun reverseP(s: String): String {
        var len = s.length
        var openBracketInd = s.lastIndexOf("(")
        var beforeBracket = s.slice(0..openBracketInd - 1)
        var afterBracket = s.slice(openBracketInd + 1..len)
        var closeBracketInd = beforeBracket.length + afterBracket.indexOf(")")
        var firstPart = s.slice(0..openBracketInd - 1)
        var secondPart = s.slice(closeBracketInd + 1..len)
        var middle = s.slice(openBracketInd + 1..closeBracketInd - 1)
        middle = middle.reversed()
        return firstPart + middle + secondPart
    }
}