package com.kiwilss.scrolltest

import android.arch.lifecycle.Observer
import android.content.Intent
import android.os.Bundle
import android.os.SystemClock
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.kiwilss.scrolltest.ui.ScrollActivity
import com.kiwilss.scrolltest.uij.MVTestOneActivity
import com.kiwilss.scrolltest.uij.MVTwoActivity
import com.kiwilss.scrolltest.uik.KTXActivity
import com.lxj.androidktx.bus.LiveDataBus
import com.lxj.androidktx.core.e
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // 接收消息
        LiveDataBus.with<String>("key2").observe(this, observer = Observer {
            it?.e()
        })

        //可快速收到消息
        LiveDataBus.with<String>("key2").observeForever(observer = Observer {
            it?.e()
            "forever".e()
        })




        btn_main_listener.setOnClickListener {

            startActivity(Intent(this,ScrollActivity::class.java))

        }

        btn_main_smart.setOnClickListener {

        }

        btn_main_mvtone.setOnClickListener {
            startActivity(Intent(this,MVTestOneActivity::class.java))
        }

        btn_main_mvtTwo.setOnClickListener {
            startActivity(Intent(this,MVTwoActivity::class.java))
        }

        btn_main_ktx.setOnClickListener {
            startActivity(Intent(this,KTXActivity::class.java))

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
