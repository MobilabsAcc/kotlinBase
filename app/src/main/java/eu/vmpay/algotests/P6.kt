package eu.vmpay.algotests

object P6 {

    /**
     * Given an array of integers, replace all the occurrences of elemToReplace with substitutionElem.
     */
    fun arrayReplace(inputArray: MutableList<Int>, elemToReplace: Int, substitutionElem: Int): MutableList<Int> {
        for(i in 0..inputArray.indices.last){
            if (inputArray[i]==elemToReplace){
                inputArray[i]=substitutionElem
            }
        }
        return inputArray
    }

    /**
     * Check if all digits of the given integer are even.
     */
    fun evenDigitsOnly(n: Int): Boolean {
        var wynik=true
        val strNum :String = "" + n;
        for( i in strNum) {
            val digit = Integer.parseInt(i.toString())
            if (digit % 2 == 1) {
                wynik=false
            }
        }
        return wynik
    }

    /**
     * Correct variable names consist only of English letters, digits and underscores and they can't
     * start with a digit. Check if the given string is a correct variable name.
     */
    fun variableName(name: String): Boolean {
        if (name[0].isDigit()) {
            return false
        }
        val lista = name.filter { !it.isLetterOrDigit() && it != '_' }
        return lista.none()
    }
    /**
     * Given a string, your task is to replace each of its characters by the next one in the English alphabet;
     * i.e. replace a with b, replace b with c, etc (z would be replaced by a).
     */
    fun alphabeticShift(inputString: String): String {
        var s = inputString.split("").toMutableList();
        println(s)
        for( i in 0 .. s.indices.last){
            when(s[i]){
                "" -> ""
                "z"-> s[i]="a"
                else -> s[i]=s[i].map{it+1}.joinToString()

            }
        }
        return s.joinToString("")
    }

    /**
     * Given two cells on the standard chess board, determine whether they have the same color or not.
     */
    fun chessBoardCellColor(cell1: String, cell2: String):Boolean {
        var wynik=false
        if((cell1[0].toInt()+cell1[1].toInt())%2==(cell2[0].toInt()+cell2[1].toInt())%2)
            wynik=true
        return wynik
    }
}