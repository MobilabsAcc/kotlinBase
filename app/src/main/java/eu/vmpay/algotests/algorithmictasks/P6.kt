package eu.vmpay.algotests.algorithmictasks

import java.util.*

object P6 {

    /**
     * Given an array of integers, replace all the occurrences of elemToReplace with substitutionElem.
     */
    fun arrayReplace(
        inputArray: MutableList<Int>,
        elemToReplace: Int,
        substitutionElem: Int
    ): MutableList<Int> {
        val result = mutableListOf<Int>()

        for (i in 0 until inputArray.size) {
            if (inputArray[i] == elemToReplace) {
                inputArray[i] = substitutionElem
                result.add(inputArray[i])
            } else {
                result.add(inputArray[i])
            }
        }
        return result
    }

    /**
     * Check if all digits of the given integer are even.
     */
    fun evenDigitsOnly(n: Int): Boolean {
        val digits = mutableListOf<Int>()
        val isEven = mutableListOf<Int>()
        var number = n

        while (number > 0) {
            digits.add(number.rem(10))
            number /= 10
        }

        for (i in digits) {
            if (i.rem(2) == 0) {
                isEven.add(1)
            } else {
                isEven.add(0)
            }
        }
        return !isEven.contains(0)
    }

    /**
     * Correct variable names consist only of English letters, digits and underscores and they can't
     * start with a digit. Check if the given string is a correct variable name.
     */
    fun variableName(name: String): Boolean {
        val allowed = Regex("^([a-zA-Z_]).*[a-zA-z_0-9].*")
        return name.matches(allowed)
    }

    /**
     * Given a string, your task is to replace each of its characters by the next one in the English alphabet;
     * i.e. replace a with b, replace b with c, etc (z would be replaced by a).
     */
    fun alphabeticShift(inputString: String): String {
        var input = inputString.toLowerCase(Locale.ROOT)
        var result = ""

        for (i in inputString) {
            result += if (i == 'z') {
                i - 25
            } else {
                i + 1
            }
        }
        return result
    }

    /**
     * Given two cells on the standard chess board, determine whether they have the same color or not.
     */
    fun chessBoardCellColor(cell1: String, cell2: String): Boolean {
        return isWhite(cell1) == isWhite(cell2)
    }

    private fun isWhite(chars: String): Boolean {
        var state1 = false
        var state2 = false
        var white = false
        val charArray = chars.toCharArray()

        state1 = when (charArray[0]) {
            'A' -> true
            'C' -> true
            'E' -> true
            'G' -> true
            else -> false
        }
        state2 = when (charArray[1]) {
            '1' -> true
            '3' -> true
            '5' -> true
            '7' -> true
            else -> false
        }
        white = state1 != state2
        return white
    }
}