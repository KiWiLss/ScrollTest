package com.kiwilss.hxim

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.kiwilss.hxim.ui.LoginActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btn_main_custom.setOnClickListener {
            startActivity(Intent(this@MainActivity,LoginActivity::class.java))
        }

        btn_main_easyUi.setOnClickListener {
            startActivity(Intent(this@MainActivity,LoginActivity::class.java).putExtra("type","easy"))
        }

    }
}
