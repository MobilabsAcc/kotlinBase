package eu.vmpay.algotests

class Database {

    private var list = listOf("Alice", "Bob", "John")

    // Simulates fetching process
    fun getUserList() = list

    // Simulates update process
    fun refresh() = list.reversed().also { list = it }
}