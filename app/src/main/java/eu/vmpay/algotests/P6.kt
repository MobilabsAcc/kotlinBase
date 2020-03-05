package eu.vmpay.algotests

object P6 {

    /**
     * Given an array of integers, replace all the occurrences of elemToReplace with substitutionElem.
     */
    fun arrayReplace(inputArray: MutableList<Int>, elemToReplace: Int, substitutionElem: Int): MutableList<Int> {
        return inputArray.map {
            if (it == elemToReplace) {
                substitutionElem
            } else {
                it
            }
        }.toMutableList()
    }

    /**
     * Check if all digits of the given integer are even.
     */
    fun evenDigitsOnly(n: Int): Boolean {
        val elements = n.toString(10)
        val firstElement = elements[0]
        return elements.filter { it != firstElement }.none()
    }

    /**
     * Correct variable names consist only of English letters, digits and underscores and they can't
     * start with a digit. Check if the given string is a correct variable name.
     */
    fun variableName(name: String): Boolean {
        if (name[0].isDigit()) {
            return false
        }
        return name.filter { !it.isLetterOrDigit() && it != '_' }.none()
    }

    /**
     * Given a string, your task is to replace each of its characters by the next one in the English alphabet;
     * i.e. replace a with b, replace b with c, etc (z would be replaced by a).
     */
    fun alphabeticShift(inputString: String): String {
        return inputString.map { if (it == 'z') 'a' else it + 1 }.joinToString("")
    }

    /**
     * Given two cells on the standard chess board, determine whether they have the same color or not.
     */
    fun chessBoardCellColor(cell1: String, cell2: String): Boolean {
        val cell1Row = cell1[0]
        val cell1Column = cell1[1]
        val cell2Row = cell2[0]
        val cell2Column = cell2[1]
        return (cell1Row.toInt() % 2 == cell2Row.toInt() % 2 && cell1Column.toInt() % 2 == cell2Column.toInt() % 2) ||
                (cell1Row.toInt() % 2 != cell2Row.toInt() % 2 && cell1Column.toInt() % 2 != cell2Column.toInt() % 2)
    }
}