package eu.vmpay.algotests

object P4 {
    /**
     * Several people are standing in a row and need to be divided into two teams.
     * The first person goes into team 1, the second goes into team 2, the third goes into team 1 again,
     * the fourth into team 2, and so on. You are given an array of positive integers - the weights of
     * the people. Return an array of two integers, where the first element is the total weight of
     * team 1, and the second element is the total weight of team 2 after the division is complete.
     */
    fun alternatingSums(a: MutableList<Int>): MutableList<Int> {
        var b= mutableListOf<Int>()
        var c= mutableListOf<Int>()
        var suma=mutableListOf<Int>()
        for (i in 0.. a.indices.last){
            if(i%2==0)
                b.add(a[i])
            else
                c.add(a[i])
        }
        println(b)
        println(c)
        suma.add(b.sum())
        suma.add(c.sum())
        println(suma)

        return suma
    }

    /**
     * Given a rectangular matrix of characters, add a border of asterisks(*) to it.
     */
    fun addBorder(picture: MutableList<String>): MutableList<String> {
        for(i in 0..picture.indices.last){
            picture[i]="*"+picture[i]+"*"
        }
        println(picture)
        val dlugosc=picture[0].length
        val pierost="*".repeat(dlugosc)
        picture.add(0,pierost)
        picture.add(picture.indices.last+1,pierost)
        return picture
    }

    /**
     * Two arrays are called similar if one can be obtained from another by swapping at most one
     * pair of elements in one of the arrays. Given two arrays a and b, check whether they are similar.
     */
    fun areSimilar(a: MutableList<Int>, b: MutableList<Int>): Boolean {
        var wynik=false
        if(a==b)
            wynik=true
        var nowa= mutableListOf<Int>( 1 , 2 , 3 , 4 , 3)
        var nowatemp=b
        var indeks= mutableListOf<Int>()
        for(i in 0.. a.indices.last){
            if(a[i]!=b[i]) {
                println(i)
                for(j in 0..b.indices.last){
                    if(b[j]==a[i])
                        indeks.add(j)
                }
                for (j in 0..indeks.indices.last) {
                    println(b)
                    nowa[i] = b[indeks[j]]
                    println(indeks[j])
                    println(b[i])
                    nowa[indeks[j]]=b[i]
                    println(nowa)
                    if (nowa == a) {
                        wynik = true
                        break
                    } else {
                        nowa = nowatemp
                    }
                }
            }
        }
        return wynik
    }
    /**
     * You are given an array of integers. On each move you are allowed to increase exactly one of
     * its element by one. Find the minimal number of moves required to obtain a strictly
     * increasing sequence from the input.
     */
    fun arrayChange(inputArray: MutableList<Int>): Int {
        TODO("not implemented")
    }

    /**
     * Given a string, find out if its characters can be rearranged to form a palindrome.
     */
    fun palindromeRearranging(inputString: String): Boolean {
        TODO("not implemented")
    }

}
