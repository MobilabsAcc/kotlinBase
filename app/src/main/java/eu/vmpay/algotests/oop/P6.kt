package eu.vmpay.algotests


object P6 {

    /**
     * Given an array of integers, replace all the occurrences of elemToReplace with substitutionElem.
     */
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
        var numb = n
        while (numb >= 1) {
            if ((numb % 10) % 2 != 0)
                return false
            numb /= 10
        }
        return true
    }


    /**
     * Correct variable names consist only of English letters, digits and underscores and they can't
     * start with a digit. Check if the given string is a correct variable name.
     */
    fun variableName(name: String): Boolean =
        name.count {
            it !in 'a'..'z' && it !in 'A'..'Z' && it !in '0'..'9' && it != '_'
        } == 0 &&  !name[0].isDigit()



    /**
     * Given a string, your task is to replace each of its characters by the next one in the English alphabet;
     * i.e. replace a with b, replace b with c, etc (z would be replaced by a).
     */
    fun alphabeticShift(inputString: String): String =
        String(inputString.map {
            when (it) {
                in 'A'..'Z' -> ((it - 'A' + 1) % 26 + 65).toChar()
                in 'a'..'z' -> ((it - 'a' + 1) % 26 + 97).toChar()
                else -> it
            }
        }.toCharArray())


    /**
     * Given two cells on the standard chess board, determine whether they have the same color or not.
     */
    fun chessBoardCellColor(cell1: String, cell2: String): Boolean =
        isWhite(cell1[0].toInt(), cell1[1].toInt()) == isWhite(cell2[0].toInt(), cell2[1].toInt())

    private fun isWhite(x: Int, y: Int): Boolean =
        x % 2 == y % 2
}