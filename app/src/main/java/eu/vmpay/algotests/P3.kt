package eu.vmpay.algotests

object P3 {

    /**
     * Given an array of strings, return another array containing all of its longest strings.
     * For inputArray = ["aba", "aa", "ad", "vcd", "aba"], the output should be
     * allLongestStrings(inputArray) = ["aba", "vcd", "aba"].
     */
    fun allLongestStrings(inputArray: MutableList<String>): MutableList<String> {
        var maxLength = 0
        for(i in 0..inputArray.lastIndex){
            if(inputArray[i].length > maxLength)
                maxLength = inputArray[i].length
        }
        return inputArray.filter { it.length == maxLength }.toMutableList()
    }

    /**
     * Given two strings, find the number of common characters between them.
     * For s1 = "aabcc" and s2 = "adcaa", the output should be commonCharacterCount(s1, s2) = 3.
     * Strings have 3 common characters - 2 "a"s and 1 "c".
     */
    fun commonCharacterCount(s1: String, s2: String): Int {
        var counter = 0
        for(i in 'a'..'z'){
            counter += s1.count { it == i }.coerceAtMost(s2.count { it == i })
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
        var numb = n
        val numb_of_digits = n.toString().length
        var counter = 0
        while (numb >= 1){
            if(numb.toString().length > numb_of_digits/2) {
                counter += numb%10
            }
            else{
                counter -= numb%10
            }
            numb /=10
        }
        return counter == 0
    }

    /**
     * Some people are standing in a row in a park. There are trees between them which cannot be moved.
     * Your task is to rearrange the people by their heights in a non-descending order
     * without moving the trees. People can be very tall!
     * For a = [-1, 150, 190, 170, -1, -1, 160, 180],
     * the output should be sortByHeight(a) = [-1, 150, 160, 170, -1, -1, 180, 190].
     */
    fun sortByHeight(a: MutableList<Int>): MutableList<Int> {
        val indexList = mutableListOf<Int>()
        for( i in 0..a.lastIndex){
            if(a[i] == -1)
                indexList.add(i)
        }
        val sortedList = a.filter { it != -1 }.sorted()
        val sortedListIterator = sortedList.iterator()
        val output = mutableListOf<Int>()
        for(i in 0..a.lastIndex){
            if(indexList.contains(i))
                output.add(-1)
            else
                output.add(sortedListIterator.next())
        }
        return output
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
        var string = inputString
        var open = 0

        while(string.contains('(')){
            for(i in 0..string.lastIndex){
                if(string[i] == '(')
                    open = i
                if(string[i]== ')'){
                    string = string.replace(string.substring(open,i+1),string.substring(open+1,i).reversed())
                    break
                }
            }
        }
        return string
    }
}