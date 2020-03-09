package eu.vmpay.algotests

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.MainView {

    private val mainPresenter: MainContract.MainPresenter
            by lazy { MainPresenter(this, Database()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnRefresh.setOnClickListener { mainPresenter.refreshList() }
    }

    override fun onResume() {
        super.onResume()
        mainPresenter.subscribe()
    }

    override fun onPause() {
        super.onPause()
        mainPresenter.unsubscribe()
    }

    override fun showList(list: List<String>) {
        textView.text = "$list"
    }
}
