package eu.vmpay.algotests

object P3 {

    /**
     * Given an array of strings, return another array containing all of its longest strings.
     * For inputArray = ["aba", "aa", "ad", "vcd", "aba"], the output should be
     * allLongestStrings(inputArray) = ["aba", "vcd", "aba"].
     */
    fun allLongestStrings(inputArray: MutableList<String>): MutableList<String> {
        val maxSize = inputArray.maxBy { it.length }!!.length
        val array = mutableListOf<String>()
        for(item in inputArray){
            if(item.length == maxSize){
                array.add(item)
            }
        }
        return array
        TODO("not implemented")
    }

    /**
     * Given two strings, find the number of common characters between them.
     * For s1 = "aabcc" and s2 = "adcaa", the output should be commonCharacterCount(s1, s2) = 3.
     * Strings have 3 common characters - 2 "a"s and 1 "c".
     */
    fun commonCharacterCount(s1: String, s2: String): Int {
        var sum = 0
        var string2 = s2
        for (char1 in s1){
            for(char2 in string2){
                if(char1 == char2){
                    string2 = string2.replaceFirst(char2,' ')
                    sum++
                    break
                }
            }
        }
        return sum
        TODO("not implemented")
    }

    /**
     * Ticket numbers usually consist of an even number of digits. A ticket number is considered lucky
     * if the sum of the first half of the digits is equal to the sum of the second half.
     * Given a ticket number n, determine if it's lucky or not.
     * For n = 1230, the output should be isLucky(n) = true;
     * For n = 239017, the output should be isLucky(n) = false.
     */
    fun isLucky(n: Int): Boolean {
        val size = n.toString().length
        var sum1 = 0
        var sum2 = 0
        var tmp = n
        for(i in 0 until size/2){
            sum1 += tmp%10
            tmp /= 10
        }
        for(i in 0 until size/2){
            sum2 += tmp%10
            tmp /= 10
        }
        if(sum1 == sum2)return true
        return false
        TODO("not implemented")
    }

    /**
     * Some people are standing in a row in a park. There are trees between them which cannot be moved.
     * Your task is to rearrange the people by their heights in a non-descending order
     * without moving the trees. People can be very tall!
     * For a = [-1, 150, 190, 170, -1, -1, 160, 180],
     * the output should be sortByHeight(a) = [-1, 150, 160, 170, -1, -1, 180, 190].
     */
    fun sortByHeight(a: MutableList<Int>): MutableList<Int> {
        val b = a.sorted().toMutableList().dropWhile { it == -1 }
        var j = 0
        for(i in 0 until a.size) {
            if(a[i] != -1){
                a[i] = b[j]
                j++
            }
        }
        return a
        TODO("not implemented")
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

        val tmp = mutableListOf<Int>()
        var tmpString = inputString
        var returnString = ""
        var index = 0

        for(i in inputString.indices){
            if(tmpString[i] == '('){
                tmp.add(i)
                index++
            }
            if(tmpString[i] == ')'){
                tmpString = tmpString.replaceRange(
                    tmp[index-1],
                    i,
                    tmpString.substring(tmp[index-1], i).reversed()
                )
                tmp.removeAt(index-1)
                index--
            }
        }
        for (i in tmpString.indices){
            if(tmpString[i] != ')' && tmpString[i] != '(')
                returnString += tmpString[i]
        }
        return returnString
        TODO("not implemented")
    }
}