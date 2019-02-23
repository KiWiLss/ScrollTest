package com.kiwilss.scrolltest

import android.content.Intent
import android.os.Bundle
import android.os.SystemClock
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.kiwilss.scrolltest.ui.ScrollActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btn_main_listener.setOnClickListener {

            startActivity(Intent(this,ScrollActivity::class.java))

        }

        btn_main_smart.setOnClickListener {

        }






        Log.e("MMM", ": " + SystemClock.elapsedRealtime());

        cc_main_time.base = SystemClock.elapsedRealtime()

        cc_main_time.format = "已用时间: %s"

        cc_main_time.start()

        cc_main_time.setOnChronometerTickListener {
            if (SystemClock.elapsedRealtime() - it.base >= 10000){
                it.stop()
            }
        }


    }
}
