package eu.vmpay.algotests

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModel : ViewModel() {

    private val database = Database()

    val userList = MutableLiveData<List<String>>()

    init {
        userList.value = database.getUserList()
    }

    fun refresh() {
        userList.value = database.refresh()
    }
}
