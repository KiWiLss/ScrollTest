package com.kiwilss.lxkj.apktest

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_main_singleInstance.setOnClickListener {
            val intent = Intent()
            intent.action = "com.castiel.demo.singleinstancetest"
            startActivity(intent)
        }
    }
}
