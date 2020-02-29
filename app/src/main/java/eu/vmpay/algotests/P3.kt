package eu.vmpay.algotests

object P3 {

    /**
     * Given an array of strings, return another array containing all of its longest strings.
     * For inputArray = ["aba", "aa", "ad", "vcd", "aba"], the output should be
     * allLongestStrings(inputArray) = ["aba", "vcd", "aba"].
     */
    fun allLongestStrings(inputArray: MutableList<String>): MutableList<String> {
        var longestString = inputArray[0].length
        for (string in inputArray){
            if(string.length > longestString)
                longestString = string.length
        }
        var returnList = mutableListOf<String>()
        for(string in inputArray){
            if(string.length == longestString){
                returnList.add(string)
            }
        }
        return returnList
    }

    /**
     * Given two strings, find the number of common characters between them.
     * For s1 = "aabcc" and s2 = "adcaa", the output should be commonCharacterCount(s1, s2) = 3.
     * Strings have 3 common characters - 2 "a"s and 1 "c".
     */
    // TO DO - remove break
    fun commonCharacterCount(s1: String, s2: String): Int {
        var ss1 = s1
        var ss2 = s2
        var sum = 0
        for (i1 in ss1){
            for(i2 in ss2){
                if(i1 == i2){
                    ss1 = ss1.replaceFirst(i1 + "", "")
                    ss2 = ss2.replaceFirst(i2 + "", "")
                    sum++
                    break
                }
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
        var numberOfDigits = 0
        var copyNumber = n
        while(copyNumber > 0){
            copyNumber /= 10
            numberOfDigits++
        }
        copyNumber = n
        var counter = 0
        var sumFirstHalf = 0
        var sumSecondHalf = 0
        while(copyNumber > 0){
            when{
                counter < numberOfDigits/2 -> sumSecondHalf += copyNumber % 10
                else -> sumFirstHalf += copyNumber % 10
            }
            copyNumber /= 10
            counter++
        }
        return sumFirstHalf == sumSecondHalf
    }

    /**
     * Some people are standing in a row in a park. There are trees between them which cannot be moved.
     * Your task is to rearrange the people by their heights in a non-descending order
     * without moving the trees. People can be very tall!
     * For a = [-1, 150, 190, 170, -1, -1, 160, 180],
     * the output should be sortByHeight(a) = [-1, 150, 160, 170, -1, -1, 180, 190].
     */
    fun sortByHeight(a: MutableList<Int>): MutableList<Int> {
        var extraList = mutableListOf<Int>()
        for (element in a){
            if(element != -1)
                extraList.add(element)
        }
        for (i in 0 until extraList.size)
            for(j in 1 until  extraList.size){
                if(extraList[j-1] > extraList[j]){
                    var tmp = extraList[j-1]
                    extraList[j-1] = extraList[j]
                    extraList[j] = tmp
                }
            }
        var counter = 0
        for ((index, value) in a.withIndex()){
            if(value != -1){
                a[index] = extraList[counter++]
            }
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

    // TO DO: CLEAN!!
    fun reverseInParentheses(inputString: String): String {

        var st = mutableListOf<Int>()
        var string = inputString
        var returnstring = inputString
        var dlugosc = string.length
        var jj = -1

        for(i in 0 until dlugosc){
            if(returnstring[i] == '('){
                st.add(i)
                jj++
            }else if(returnstring[i] == ')'){
                returnstring = returnstring.replaceRange(
                    st.last(),
                    i,
                    returnstring.substring(st.last(), i).reversed()
                )
                st.removeAt(jj)
                jj--
            }
        }
        var returnn = ""
        for (i in 0 until returnstring.length){
            if(returnstring[i] != ')' && returnstring[i] != '(')
                returnn += returnstring[i]
        }
        return returnn

    }
}