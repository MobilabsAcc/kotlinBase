package eu.vmpay.algotests

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner

@Suppress("UNCHECKED_CAST")
class ViewModelFactory constructor(
        private val database: Database,
        owner: SavedStateRegistryOwner,
        defaultArgs: Bundle? = null
) : AbstractSavedStateViewModelFactory(owner, defaultArgs) {

    override fun <T : ViewModel> create(
            key: String,
            modelClass: Class<T>,
            handle: SavedStateHandle
    ) = with(modelClass) {
        when {
            isAssignableFrom(UserViewModel::class.java) -> UserViewModel(database)
            else -> throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
        }
    } as T
}
