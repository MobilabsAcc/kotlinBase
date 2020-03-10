package eu.vmpay.algotests

import androidx.fragment.app.FragmentActivity

fun FragmentActivity.getViewModelFactory() = ViewModelFactory(Injection.provideDatabase(), this)
