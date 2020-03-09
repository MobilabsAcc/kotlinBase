package eu.vmpay.algotests.mvvm

class Database{
    private var list = listOf("Michael", "Stephen","Klay")

    // fetch simulation
    fun  getUserList() = list

    //refresh simulation
    fun refresh() = list.reversed().also{ list = it }

}