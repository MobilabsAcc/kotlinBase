package eu.vmpay.algotests.mvvm

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import eu.vmpay.algotests.R

class UserViewModel : ViewModel() {

    private val database = Database()
    val userList = MutableLiveData<List<String>>()

    init {
        userList.value = database.getUserList()
    }

    fun refresh(){
        userList.value = database.refresh()
    }

}
