package com.navyck.kotlin_mvp_test

import org.json.JSONObject

interface MainContract {
    interface View {
        fun showInfo(info: JSONObject)
    }

    interface Presenter {
        fun initInfo()
        fun setInfo(info: JSONObject)
        fun saveInfo(info: JSONObject)
    }
}