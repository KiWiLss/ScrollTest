package com.kiwilss.jetpacktest

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.lxj.androidktx.core.click
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initClick()
    }

    private fun initClick() {
        btn_main_lifecycler.click {

        }
    }
}
