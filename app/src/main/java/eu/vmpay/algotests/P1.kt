package eu.vmpay.algotests

object P1 {

    /**
     * Write a function that returns the sum of two numbers.
     * For param1 = 1 and param2 = 2, the output should be add(param1, param2) = 3.
     */
    fun add(param1: Int, param2: Int): Int {
        return param1 + param2
    }

    /**
     * Given a year, return the century it is in. The first century spans from the year 1 up to and
     * including the year 100, the second - from the year 101 up to and including the year 200, etc.
     * For year = 1905, the output should be centuryFromYear(year) = 20;
     * For year = 1700, the output should be centuryFromYear(year) = 17.
     */
    fun centuryFromYear(year: Int): Int {
        val modulo = year.rem(100)
        val century = (year - modulo) / 100
        return if (modulo != 0) {
            century + 1
        } else {
            century
        }
    }

    /**
     * Given the string, check if it is a palindrome.
     * For inputString = "aabaa", the output should be checkPalindrome(inputString) = true;
     * For inputString = "abac", the output should be checkPalindrome(inputString) = false;
     * For inputString = "a", the output should be checkPalindrome(inputString) = true.
     */
    fun checkPalindrome(inputString: String): Boolean {
        for (i in 0 until inputString.length / 2) {
            if (inputString[i] != inputString[inputString.length - i - 1]) return false
        }
        return true
    }
}