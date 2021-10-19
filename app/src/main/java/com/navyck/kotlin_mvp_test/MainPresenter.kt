package com.navyck.kotlin_mvp_test

import com.navyck.kotlin_mvp_test.data.InfoDataSource
import com.navyck.kotlin_mvp_test.data.InfoRepository
import org.json.JSONObject

class MainPresenter(
        val view: MainContract.View,
        private val repository: InfoRepository
) : MainContract.Presenter {
    override fun initInfo() {
        repository.getInfo(object: InfoDataSource.LoadInfoCallback {
            override fun onInfoLoaded(info: JSONObject) {
                view.showInfo(info)
            }

            override fun onDataNotAvailable() {

            }
        })
    }

    override fun setInfo(info: JSONObject) {
        view.showInfo(info)
    }

    override fun saveInfo(info: JSONObject) {
        repository.saveInfo(info)
    }

}