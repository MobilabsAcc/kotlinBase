package eu.vmpay.algotests

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this, getViewModelFactory()).get(UserViewModel::class.java)

        viewModel.userList.observe(this@MainActivity, Observer {
            fillData(it)
        })

        button.setOnClickListener {
            viewModel.refresh()
        }
    }

    /**
     * Fill updated info in the view
     *
     * @param list of names to be displayed
     */
    private fun fillData(list: List<String>) {
        textView.text = list.toString()
    }
}
