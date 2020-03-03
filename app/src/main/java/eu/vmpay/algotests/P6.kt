package eu.vmpay.algotests
import java.util.Scanner
/**
 * Challenge 2 - The cruise ship
 *
 * Four hundred people were traveling on a cruise ship with two engines having power of: 2kHP, 4kHP.
 * Fifty people represented the ship crew while others were tourists. The ship could have both engines
 * operating simultaneously, only one at a time or keep both off depending on the captain command.
 * Every tourist was assigned to a two or four person cabin shared with our tourists, which could be
 * his friends. The ship had a restaurant and a two bars of 300, 50 ,50 people capacity correspondingly.
 * Each tourist could visit one of the attractions or stay and his cabin at a time. Tourists under
 * 18 years were not allowed to enter the bar.
 *
 * Goal: implement the ship, engine, person, restaurant, bar, cabin classes reflecting the above case.
 */
open class Ship(){
    open val engine1 = 2
    open val engine2 = 4
    open val crew = 50
    open val tourists = 350
    fun command(comand: Int){
        if(comand==0) {
            println("zaden silnik nie dziala")
        } else if(comand==2) {
            println("dziala jeden silnik o mocy $engine1 kHp")
        }else if(comand==4){
            println("dziala jeden silnik o mocy $engine2 kHp")
        }
        else {
            println("dzialaja dwa silniki o mocy $engine1 kHp oraz $engine2 kHP")
        }
    }
}
class Engine():Ship(){
    fun demo(){
        println("Kapitanie wydaj comende ile silnikow ma dzialac")
    }
}
class restaurant(capacity:Int){
    val capacityr=capacity
}
class tourist(){
    fun stay(){
        println("lets go to a bar")
    }
    fun bar(restaurant:Int):Int{
        println("Lets go to a restaurant with capacity $restaurant")
        return 0
    }

}
fun main(){
    val reader = Scanner(System.`in`)
    Engine().demo()
    var i:Int = reader.nextInt()
    Ship().command(i)
    println(Ship().engine1)

}