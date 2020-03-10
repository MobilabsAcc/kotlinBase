package eu.vmpay.algotests

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModel(private val database: Database) : ViewModel() {

    val userList = MutableLiveData<List<String>>()

    init {
        userList.value = this.database.getUserList()
    }

    fun refresh() {
        userList.value = database.refresh()
    }
}
