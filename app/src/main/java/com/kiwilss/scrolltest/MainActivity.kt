package com.kiwilss.scrolltest

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.kiwilss.scrolltest.ui.ScrollActivity
import com.tencent.mmkv.MMKV
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btn_main_listener.setOnClickListener {

            startActivity(Intent(this,ScrollActivity::class.java))

        }


        MMKV.defaultMMKV().encode("key",true)

        val decodeBool = MMKV.defaultMMKV().decodeBool("key")


    }
}
