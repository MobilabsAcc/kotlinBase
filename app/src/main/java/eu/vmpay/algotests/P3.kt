package eu.vmpay.algotests

object P3 {

    /**
     * Given an array of strings, return another array containing all of its longest strings.
     * For inputArray = ["aba", "aa", "ad", "vcd", "aba"], the output should be
     * allLongestStrings(inputArray) = ["aba", "vcd", "aba"].
     */
    fun allLongestStrings(inputArray: MutableList<String>): MutableList<String> {
        var maxLength = 0
        for (item in inputArray) {
            if (item.length > maxLength) {
                maxLength = item.length
            }
        }
        return inputArray.filter { it.length == maxLength } as MutableList<String>
    }

    /**
     * Given two strings, find the number of common characters between them.
     * For s1 = "aabcc" and s2 = "adcaa", the output should be commonCharacterCount(s1, s2) = 3.
     * Strings have 3 common characters - 2 "a"s and 1 "c".
     */
    fun commonCharacterCount(s1: String, s2: String): Int {
        val characterMap = HashMap<Char, Int>()
        s1.forEach {
            characterMap[it] = (characterMap[it] ?: 0) + 1
        }
        var counter = 0
        s2.forEach {
            if (characterMap.containsKey(it) && characterMap[it] ?: 0 > 0) {
                counter += 1
                characterMap[it] = (characterMap[it] ?: 0) - 1
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
        val nString = n.toString()
        val nLength = nString.length
        val firstHalf = nString.subSequence(0, nLength / 2)
        val secondHalf = nString.subSequence(nLength / 2, nLength)
        return firstHalf.sumBy { it.toInt() } == secondHalf.sumBy { it.toInt() }
    }

    /**
     * Some people are standing in a row in a park. There are trees between them which cannot be moved.
     * Your task is to rearrange the people by their heights in a non-descending order
     * without moving the trees. People can be very tall!
     * For a = [-1, 150, 190, 170, -1, -1, 160, 180],
     * the output should be sortByHeight(a) = [-1, 150, 160, 170, -1, -1, 180, 190].
     */
    fun sortByHeight(a: MutableList<Int>): MutableList<Int> {
        val indexes = mutableListOf<Int>()
        val people = mutableListOf<Int>()
        a.forEachIndexed { index, person ->
            if (person != -1) {
                indexes.add(index)
                people.add(person)
            }
        }
        people.sort()
        indexes.zip(people).forEach {(index, person) ->
            a[index] = person
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
        fun reverse(inputString: String): String {
            val regex = Regex("[(][a-z]*[)]")
            val result = regex.find(inputString, 0)
            if (result != null) {
                return inputString.replace(
                    result.value,
                    result.value.reversed().substring(1, result.value.length - 1)
                )
            }
            return inputString
        }
        var resultString = inputString
        while(true) {
            val newResultString = reverse(resultString)
            if (newResultString == resultString) {
                break
            }
            resultString = newResultString
        }
        return resultString
    }
}