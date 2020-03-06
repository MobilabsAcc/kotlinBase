package eu.vmpay.algotests

import android.os.Build
import androidx.annotation.RequiresApi
import java.util.function.UnaryOperator

object P6 {

    /**
     * Given an array of integers, replace all the occurrences of elemToReplace with substitutionElem.
     */
    @RequiresApi(Build.VERSION_CODES.N)
    fun arrayReplace(
        inputArray: MutableList<Int>,
        elemToReplace: Int,
        substitutionElem: Int
    ): MutableList<Int> =
        inputArray.map { if (it == elemToReplace) substitutionElem else it }.toMutableList()


    /**
     * Check if all digits of the given integer are even.
     */
    fun evenDigitsOnly(n: Int): Boolean {
        var tmp = n
        while (tmp > 0) {
            if ((tmp % 10) % 2 != 0) return false
            tmp /= 10
        }
        return true
        TODO("not implemented")
    }

    /**
     * Correct variable names consist only of English letters, digits and underscores and they can't
     * start with a digit. Check if the given string is a correct variable name.
     */
    fun variableName(name: String): Boolean {
        for (item in name.indices) {
            if (item == 0 && (!name[item].isLetter() && name[item] != '_')) return false
            if (!name[item].isLetterOrDigit() && name[item] != '_') return false
        }
        return true
        TODO("not implemented")
    }

    /**
     * Given a string, your task is to replace each of its characters by the next one in the English alphabet;
     * i.e. replace a with b, replace b with c, etc (z would be replaced by a).
     */
    fun alphabeticShift(inputString: String): String {
        TODO("not implemented")
    }

    /**
     * Given two cells on the standard chess board, determine whether they have the same color or not.
     */
    fun chessBoardCellColor(cell1: String, cell2: String) {
        TODO("not implemented")
    }
}