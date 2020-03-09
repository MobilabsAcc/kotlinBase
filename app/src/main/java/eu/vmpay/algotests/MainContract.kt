package eu.vmpay.algotests

interface MainContract {

    interface MainView {

        fun showList(list: List<String>)
    }

    interface MainPresenter {

        fun subscribe()

        fun unsubscribe()

        fun refreshList()
    }
}
