package com.kiwilss.scrolltest

import android.arch.lifecycle.Observer
import android.content.Intent
import android.os.Bundle
import android.os.SystemClock
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.kiwilss.scrolltest.ui.ScrollActivity
import com.kiwilss.scrolltest.ui.ui_adapter.AdapterActivity
import com.kiwilss.scrolltest.uij.MVTestOneActivity
import com.kiwilss.scrolltest.uij.MVTwoActivity
import com.kiwilss.scrolltest.uij.et.EtActivity
import com.kiwilss.scrolltest.uik.KTXActivity
import com.kiwilss.scrolltest.uik.KTXRVActivity
import com.kiwilss.scrolltest.uik.SmartToastActivity
import com.lxj.androidktx.bus.LiveDataBus
import com.lxj.androidktx.core.click
import com.lxj.androidktx.core.e
import com.lxj.androidktx.core.startActivity
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
            val intent = Intent()
            intent.action = "com.castiel.demo.singleinstance"
            startActivity(intent)
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

        btn_main_ktxRv.click {
            startActivity(Intent(this,KTXRVActivity::class.java))
        }

        btn_main_toast.click {
            startActivity<SmartToastActivity>()
        }

        btn_main_et.click {
            startActivity<EtActivity>()
        }

        btn_main_liuhai.click {
            startActivity<AdapterActivity>()
        }


        Log.e("MMM", ": " + SystemClock.elapsedRealtime())

        cc_main_time.base = SystemClock.elapsedRealtime()

        //cc_main_time.format = "已用时间: %s"

        val hour = ((SystemClock.elapsedRealtime() - cc_main_time.base) / 1000 / 60)
        //cc_main_time.setFormat("0"+String.valueOf(hour)+":%s");
        cc_main_time.format = "0$hour:%s"

        cc_main_time.start()
        //正数计时
        cc_main_time.setOnChronometerTickListener {
            if (SystemClock.elapsedRealtime() - it.base >= 1000*100){
                it.stop()
            }
        }


    }
}
