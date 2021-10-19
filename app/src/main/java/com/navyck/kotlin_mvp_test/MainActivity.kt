package com.navyck.kotlin_mvp_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.navyck.kotlin_mvp_test.data.InfoRepository
import org.json.JSONObject
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.View {
    private lateinit var presenter: MainPresenter
    private lateinit var repository: InfoRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        repository = InfoRepository(this)
        presenter = MainPresenter(this@MainActivity, repository)

        presenter.initInfo()
        initButtonListener()
    }

    override fun showInfo(info: JSONObject) {
        name_view.text = info.getString("name")
        email_view.text = info.getString("email")
    }

    private fun initButtonListener() {
        button_submit.setOnClickListener {
            val info = JSONObject()
            info.put("name", name_input.text.toString())
            info.put("email", email_input.text.toString())

            name_input.text.clear()
            email_input.text.clear()

            presenter.setInfo(info)
            presenter.saveInfo(info)
        }
    }
}