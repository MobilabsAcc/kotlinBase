package eu.vmpay.algotests

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModel : ViewModel() {

    val userList = MutableLiveData<List<String>>()

    private val database = Database()

    init {
        userList.value = database.getUserList()
    }

    fun refresh() {
        userList.value = database.refresh()
    }
}
