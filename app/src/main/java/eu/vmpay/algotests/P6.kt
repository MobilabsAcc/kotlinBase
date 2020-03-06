package eu.vmpay.algotests

object P6 {

    /**
     * Given an array of integers, replace all the occurrences of elemToReplace with substitutionElem.
     */
    fun arrayReplace(
        inputArray: MutableList<Int>,
        elemToReplace: Int,
        substitutionElem: Int
    ): MutableList<Int> {
        for (i in inputArray.indices) {
            if (inputArray[i] == elemToReplace)
                inputArray[i] = substitutionElem
        }
        return inputArray
    }

    /**
     * Check if all digits of the given integer are even.
     */
    fun evenDigitsOnly(n: Int): Boolean {
        val s = n.toString().toCharArray()
        for (i in s.indices) {
            if (s[i].toInt().rem(2) == 1)
                return false
        }
        return true
    }

    /**
     * Correct variable names consist only of English letters, digits and underscores and they can't
     * start with a digit. Check if the given string is a correct variable name.
     */
    fun variableName(name: String): Boolean {
        val s = name.toCharArray()
        if (s[0] in '1'..'9')
            return false
        for (i in 1..s.indices.last) {
            if (s[i] !in 'a'..'z' && s[i] !in 'A'..'Z' && s[i] !in '0'..'9' && s[i] != '_')
                return false
        }
        return true
    }

    /**
     * Given a string, your task is to replace each of its characters by the next one in the English alphabet;
     * i.e. replace a with b, replace b with c, etc (z would be replaced by a).
     */
    fun alphabeticShift(inputString: String): String {
        val s = inputString.toCharArray()
        val builder = StringBuilder()
        builder.append(s[s.indices.last])
        for (i in 0 until s.indices.last)
            builder.append(s[i])
        return builder.toString()
    }

    /**
     * Given two cells on the standard chess board, determine whether they have the same color or not.
     */
    fun chessBoardCellColor(cell1: String, cell2: String): Boolean {
        if (cell1.length != 2 || cell2.length != 2)
            return false
        val c1Array = cell1.toCharArray()
        val c2Array = cell2.toCharArray()
        if (c1Array[0] !in 'A'..'Z' || c2Array[0] !in 'A'..'Z' || c1Array[1] !in '1'..'8' || c2Array[1] !in '1'..'8')
            return false

        var isWhiteCell1 = true
        var isWhiteCell2 = true

        if (((c1Array[0] - 'A').rem(2) == 1) == ((c1Array[1] - 1).toInt().rem(2) == 1))
            isWhiteCell1 = false
        if (((c2Array[0] - 'A').rem(2) == 1) == ((c2Array[1] - 1).toInt().rem(2) == 1))
            isWhiteCell2 = false

        return isWhiteCell1 == isWhiteCell2

    }
}