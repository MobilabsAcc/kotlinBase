package eu.vmpay.algotests

object P6 {

    /**
     * Given an array of integers, replace all the occurrences of elemToReplace with substitutionElem.
     */
    fun arrayReplace(inputArray: MutableList<Int>, elemToReplace: Int, substitutionElem: Int): MutableList<Int> {

        for(i: Int in 0 until inputArray.size){
            if(inputArray[i] == elemToReplace)      inputArray[i] = substitutionElem
        }

        return inputArray
    }

    /**
     * Check if all digits of the given integer are even.
     */
    fun evenDigitsOnly(n: Int): Boolean {
        var s: String = n.toString()

        for (i: Int in 1 until s.length){
            if (s[i] != s[i - 1])   return false
        }
        return true
    }

    /**
     * Correct variable names consist only of English letters, digits and underscores and they can't
     * start with a digit. Check if the given string is a correct variable name.
     */
    fun variableName(name: String): Boolean {

        var regex = Regex("[a-bA-Z\\_][\\_a-zA-Z0-9]{0,}")

        return regex.matches(name)
    }

    /**
     * Given a string, your task is to replace each of its characters by the next one in the English alphabet;
     * i.e. replace a with b, replace b with c, etc (z would be replaced by a).
     */
    fun alphabeticShift(inputString: String): String {

        var result : String = ""

        for (i: Char in inputString){
            result += if (i == 'z' || i == 'Z')
                i - 25
            else
                i + 1
        }
        return  result
    }

    /**
     * Given two cells on the standard chess board, determine whether they have the same color or not.
     */
    fun chessBoardCellColor(cell1: String, cell2: String) : Boolean{

        var a1 = cell1[0].toInt()
        var b1 = cell1[1].toInt()

        var a2 = cell2[0].toInt()
        var b2 = cell2[1].toInt()

        if(
            (isEven(a1, b1, true) && isEven(a2, b2, true) )
            ||
            (isEven(a1, b1, false) && isEven(a2, b2, false))
            ||
            (evenOdd(a1, b1) == evenOdd(a2,b2))
        )   return true


        return false
    }

    private fun evenOdd(a : Int, b: Int) : Boolean {

        return (a % 2 == 0 && b % 2 == 1) || (a % 2 == 1 && b % 2 == 0)
    }

    private fun isEven(a : Int, b: Int, e: Boolean) : Boolean{

        var i: Int = if (e) 0 else 1

        return a % 2 == i && b % 2 == i
    }
}