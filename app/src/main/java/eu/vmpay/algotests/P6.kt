package eu.vmpay.algotests

object P6 {

    /**
     * Given an array of integers, replace all the occurrences of elemToReplace with substitutionElem.
     */
    fun arrayReplace(inputArray: MutableList<Int>, elemToReplace: Int, substitutionElem: Int): MutableList<Int> {
        for(i in 0 until inputArray.size) if(inputArray[i] == elemToReplace) inputArray[i] = substitutionElem

        return inputArray
    }
    /**
     * Check if all digits of the given integer are even.
     */
    fun evenDigitsOnly(n: Int): Boolean {
        for(i in 0 until n.toString().length) if(n.toString()[i].toInt() % 2 != 0) return false else continue

        return true
    }

    /**
     * Correct variable names consist only of English letters, digits and underscores and they can't
     * start with a digit. Check if the given string is a correct variable name.
     */
    fun variableName(name: String): Boolean {
        if (name[0].isDigit()) return false

        for(i in 0 until name.length)
            if (name[i].isLetterOrDigit() || name[i].toInt() == 95) continue else return false
        return true
    }

    /**
     * Given a string, your task is to replace each of its characters by the next one in the English alphabet;
     * i.e. replace a with b, replace b with c, etc (z would be replaced by a).
     */
    fun alphabeticShift(inputString: String): String {
        val array:MutableList<Char> = arrayListOf()

        for(i in 0 until inputString.length)
            if (inputString[i].toLowerCase().equals('z')) array.add('a')
            else array.add((inputString[i].toInt() + 1).toChar())

        return array.joinToString(separator = "")
    }

    /**
     * Given two cells on the standard chess board, determine whether they have the same color or not.
     */
    fun whatColour (cell: String): String {
        if (cell[0].toInt()%2 != 0 && cell[1].toInt()%2 != 0 ||
            cell[0].toInt()%2 == 0 && cell[1].toInt()%2 == 0) return "isWhite"
        return "isBlack"
    }

    fun chessBoardCellColor(cell1: String, cell2: String): Boolean {
        return whatColour(cell1) == (whatColour(cell2))
    }
}