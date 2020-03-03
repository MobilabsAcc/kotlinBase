package eu.vmpay.algotests

object P1 {

    /**
     * Write a function that returns the sum of two numbers.
     * For param1 = 1 and param2 = 2, the output should be add(param1, param2) = 3.
     */
    fun add(a: Int, b: Int): Int {
        return a + b
    }

    /**
     * Given a year, return the century it is in. The first century spans from the year 1 up to and
     * including the year 100, the second - from the year 101 up to and including the year 200, etc.
     * For year = 1905, the output should be centuryFromYear(year) = 20;
     * For year = 1700, the output should be centuryFromYear(year) = 17.
     */
    fun centuryFromYear(year: Int): Int {
        if (year <= 100)
            return 1
        if (year % 100 == 0)
            return year / 100
        else
            return year / 100 + 1

    }

    /**
     * Given the string, check if it is a palindrome.
     * For inputString = "aabaa", the output should be checkPalindrome(inputString) = true;
     * For inputString = "abac", the output should be checkPalindrome(inputString) = false;
     * For inputString = "a", the output should be checkPalindrome(inputString) = true.
     */
    fun checkPalindrome(inputString: String): Boolean {
        var x = 0
        var wynik=false
        println(inputString[0])
        for (i in 0.. inputString.length-1) {
            if (inputString[i] == inputString[inputString.length - i-1])
                x++
        }
        if (x == inputString.length) {
            wynik=true
        }
        return wynik
    }
}
