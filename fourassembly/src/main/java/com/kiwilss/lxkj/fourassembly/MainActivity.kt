package com.kiwilss.lxkj.fourassembly

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.kiwilss.lxkj.fourassembly.activity.OneActivity
import com.kiwilss.lxkj.fourassembly.anim.AnimActivity
import com.kiwilss.lxkj.fourassembly.anim.AnimTestActivity
import com.kiwilss.lxkj.fourassembly.anim.EditTextActivity
import com.kiwilss.lxkj.fourassembly.base.BaseActivity
import com.kiwilss.lxkj.fourassembly.broadcastreceiver.BroadActivity
import com.kiwilss.lxkj.fourassembly.contentprovider.ContentTestActivity
import com.kiwilss.lxkj.fourassembly.custom_view.CustomViewActivity
import com.kiwilss.lxkj.fourassembly.gesture.GestureActivity
import com.kiwilss.lxkj.fourassembly.handler.HandlerActivity
import com.kiwilss.lxkj.fourassembly.icon.BitmapActivity
import com.kiwilss.lxkj.fourassembly.io.IOTestActivity
import com.kiwilss.lxkj.fourassembly.lauch.SingleInstanceActivity
import com.kiwilss.lxkj.fourassembly.lauch.SingleTaskActivity
import com.kiwilss.lxkj.fourassembly.lauch.SingleTopActivity
import com.kiwilss.lxkj.fourassembly.lauch.StandardActivity
import com.kiwilss.lxkj.fourassembly.service.ServiceTestActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.e("MMM", ": mainactivity" );
        initClick()



    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Log.e("MMM", "MainActivity   :   onNewIntent" );
    }

    private fun initClick() {
        //activity生命周期
        btn_main_four.setOnClickListener {
            startActivity(Intent(this,OneActivity::class.java))
        }
        //activity 启动模式
        btn_main_launch.setOnClickListener {
            startActivity(Intent(this,StandardActivity::class.java))
        }
        btn_main_singleTop.setOnClickListener {
            startActivity(Intent(this,SingleTopActivity::class.java))
        }
        btn_main_singleTask.setOnClickListener {
            startActivity(Intent(this, SingleTaskActivity::class.java))
        }
        btn_main_singleInstance.setOnClickListener {
            startActivity(Intent(this, SingleInstanceActivity::class.java))
        }
        //服务相关
        btn_main_service1.setOnClickListener {
            startActivity(Intent(this, ServiceTestActivity::class.java))
        }
        //广播相关
        btn_main_braod.setOnClickListener {
            startActivity(Intent(this, BroadActivity::class.java))
        }
        //内容提供者
        btn_main_contentProvider.setOnClickListener {
            startActivity(Intent(this, ContentTestActivity::class.java))
        }
        //自定义view
        btn_main_customView.setOnClickListener {
            startActivity(Intent(this, CustomViewActivity::class.java))
        }
        btn_main_anim.setOnClickListener {
            startActivity(Intent(this, AnimActivity::class.java))
        }
        btn_main_anim2.setOnClickListener {
            startActivity(Intent(this, AnimTestActivity::class.java))
        }
        btn_main_edittext.setOnClickListener {
            startActivity(Intent(this, EditTextActivity::class.java))
        }
        btn_main_gesture.setOnClickListener {
            startActivity(Intent(this, GestureActivity::class.java))
        }
        btn_main_icon.setOnClickListener {
            startActivity(Intent(this, BitmapActivity::class.java))
        }
        btn_main_io.setOnClickListener {
            startActivity(Intent(this, IOTestActivity::class.java))
        }
        btn_main_handler.setOnClickListener { startActivity(Intent(this, HandlerActivity::class.java)) }
    }
}
