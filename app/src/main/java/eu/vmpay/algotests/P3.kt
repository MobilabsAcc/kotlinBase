package eu.vmpay.algotests

object P3 {

    /**
     * Given an array of strings, return another array containing all of its longest strings.
     * For inputArray = ["aba", "aa", "ad", "vcd", "aba"], the output should be
     * allLongestStrings(inputArray) = ["aba", "vcd", "aba"].
     */
    fun allLongestStrings(inputArray: MutableList<String>): MutableList<String> {
        var list = mutableListOf(inputArray[0])
        var i = 1
        while(i < inputArray.size){
            when{
                inputArray[i].length > list[0].length -> list = mutableListOf(inputArray[i])
                inputArray[i].length == list[0].length -> list.add(inputArray[i])
            }
            i++
        }
        return list
    }

    /**
     * Given two strings, find the number of common characters between them.
     * For s1 = "aabcc" and s2 = "adcaa", the output should be commonCharacterCount(s1, s2) = 3.
     * Strings have 3 common characters - 2 "a"s and 1 "c".
     */
    fun commonCharacterCount(s1: String, s2: String): Int {
        var sum = 0
        var temp = s2
        for(i in s1){
            if(temp.contains(i)){
                val index = temp.indexOfFirst { it == i }
                temp = temp.removeRange(index, index + 1)
                sum++
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
        val string = n.toString()
        var i = 0
        var sum1 = 0
        var sum2 = 0
        while(i < string.length/2){
            sum1 += string[i].toInt()
            sum2 += string[string.length - i - 1].toInt()
            i++
        }
        if(sum1 == sum2){
            return true
        }
        return false
    }

    /**
     * Some people are standing in a row in a park. There are trees between them which cannot be moved.
     * Your task is to rearrange the people by their heights in a non-descending order
     * without moving the trees. People can be very tall!
     * For a = [-1, 150, 190, 170, -1, -1, 160, 180],
     * the output should be sortByHeight(a) = [-1, 150, 160, 170, -1, -1, 180, 190].
     */
    fun sortByHeight(a: MutableList<Int>): MutableList<Int> {
        val people = getSortedPeople(a)
        var i = 0
        var j = 0
        while(i < a.size){
            if(a[i] > 0) {
                a[i] = people[j]
                j++
            }
            i++
        }
        return a
    }

    private fun getSortedPeople(a: MutableList<Int>): MutableList<Int>{
        val result = mutableListOf<Int>()
        for(i in a){
            if(i > 0)
                result.add(i)
        }
        result.sort()
        return result
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
        var result = inputString
        var substring: String
        var i = 0
        var j: Int
        while(result.contains('(')){
            if(i >= result.length)
                i=0
            if(result[i] == '('){
                j = i + 1
                while(j < result.length){
                    if(result[j] =='(')
                        i = j
                    if(result[j] == ')')
                        break
                    j++
                }
                substring = result.substring(i, j)
                substring = reverse(substring)
                result = result.replaceRange(i, j + 1, substring)
            }
            i++
        }
        return result
    }

    private fun reverse(string: String): String{
        var result = string.reversed()
        result = result.removePrefix(")")
        result = result.removeSuffix("(")
        return result
    }
}