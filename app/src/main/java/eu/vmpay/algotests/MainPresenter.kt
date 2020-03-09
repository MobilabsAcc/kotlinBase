package eu.vmpay.algotests

class MainPresenter(
        private val mainView: MainContract.MainView,
        private val database: Database
) : MainContract.MainPresenter {

    override fun subscribe() {
        mainView.showList(
                database.getUserList()
        )
    }

    override fun unsubscribe() {
        // View goes off screen. Clear resources here
    }

    override fun refreshList() {
        mainView.showList(
                database.refresh()
        )
    }
}
