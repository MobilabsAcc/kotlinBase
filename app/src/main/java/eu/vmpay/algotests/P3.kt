package eu.vmpay.algotests

import java.util.regex.Pattern

object P3 {

    /**
     * Given an array of strings, return another array containing all of its longest strings.
     * For inputArray = ["aba", "aa", "ad", "vcd", "aba"], the output should be
     * allLongestStrings(inp    utArray) = ["aba", "vcd", "aba"].
     */
    fun allLongestStrings(inputArray: MutableList<String>): MutableList<String> {

        var resultList =  ArrayList<String>()

        var max = 0

        for (i: String in inputArray){
            if (i.length > max) {
                max = i.length
                resultList = ArrayList()
            }

            if(i.length == max) resultList.add(i)
        }
        return resultList
    }

    /**
     * Given two strings, find the number of common characters between them.
     * For s1 = "aabcc" and s2 = "adcaa", the output should be commonCharacterCount(s1, s2) = 3.
     * Strings have 3 common characters - 2 "a"s and 1 "c".
     */
    fun commonCharacterCount(s1: String, s2: String): Int {
        var tmpS1 = HashMap<Char, Int>()
        var tmpS2 = HashMap<Char, Int>()

        for (c: Char in s1){
            if (tmpS1.containsKey(c))
                tmpS1[c] = tmpS1.getValue(c) + 1
            else
                tmpS1[c] = 1
        }

        for (c: Char in s2){
            if (tmpS2.containsKey(c))
                tmpS2[c] = tmpS2.getValue(c) + 1
            else
                tmpS2[c] = 1
        }

        var result = 0

        for (c: Char in tmpS1.keys){

            if (tmpS2.containsKey(c)){
                result += if (tmpS2.getValue(c) > tmpS1.getValue(c)) tmpS1.getValue(c) else tmpS2.getValue(c)
            }
        }
        return result
    }

    /**
     * Ticket numbers usually consist of an even number of digits. A ticket number is considered lucky
     * if the sum of the first half of the digits is equal to the sum of the second half.
     * Given a ticket number n, determine if it's lucky or not.
     * For n = 1230, the output should be isLucky(n) = true;
     * For n = 239017, the output should be isLucky(n) = false.
     */
    fun isLucky(n: Int): Boolean {

        var s = n.toString()

        var sumLeft = 0
        var sumRight = 0
        var i = 0

        while (i < s.length/2){

            sumLeft += s[s.lastIndex - i].toInt() - 48
            sumRight += s[i].toInt() - 48

            i++
        }

        return sumLeft == sumRight
    }

    /**
     * Some people are standing in a row in a park. There are trees between them which cannot be moved.
     * Your task is to rearrange the people by their heights in a non-descending order
     * without moving the trees. People can be very tall!
     * For a = [-1, 150, 190, 170, -1, -1, 160, 180],
     * the output should be sortByHeight(a) = [-1, 150, 160, 170, -1, -1, 180, 190].
     */
    fun sortByHeight(a: MutableList<Int>): MutableList<Int> {

        var i = 0


        while (i < a.size){

            if(a[i] > 0){

                var min = a[i]
                var currentIndex = i
                var j = i

                while (j < a.size){

                    if(a[j] in 1..(min - 1)){
                        min = a[j]
                        currentIndex = j
                    }
                    j++
                }


                var tmpValue = a[i]
                a[i] = min
                a[currentIndex] = tmpValue

            }
            i++

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

        var input = inputString
        var pattern = Pattern.compile("\\([^\\(\\)\$]{0,}\\)")
        var matcher = pattern.matcher(input)

        while (matcher.find())  {

            var tmp = matcher.group(0)
            var oldMatch = tmp

            tmp = tmp.replace("(", "")
            tmp = tmp.replace(")", "")

            input = input.replace(oldMatch, tmp.reversed())
            matcher = pattern.matcher(input)
        }

        return input
    }
}