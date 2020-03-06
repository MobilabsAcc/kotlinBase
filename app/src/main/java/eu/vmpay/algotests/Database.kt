package eu.vmpay.algotests

class Database {

    private var list = listOf("Jan Kowalski", "Ivan Petrov")

    fun getUserList() = list

    fun refresh() = list.reversed().also { list = it}


}