package com.kiwilss.lxkj.fourassembly

import android.content.Intent
import android.os.Bundle
import com.kiwilss.lxkj.fourassembly.activity.OneActivity
import com.kiwilss.lxkj.fourassembly.base.BaseActivity
import com.kiwilss.lxkj.fourassembly.lauch.SingleTaskActivity
import com.kiwilss.lxkj.fourassembly.lauch.SingleTopActivity
import com.kiwilss.lxkj.fourassembly.lauch.StandardActivity
import com.kiwilss.lxkj.fourassembly.service.ServiceTestActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initClick()



    }

    private fun initClick() {
        btn_main_four.setOnClickListener {
            startActivity(Intent(this,OneActivity::class.java))
        }
        btn_main_launch.setOnClickListener {
            startActivity(Intent(this,StandardActivity::class.java))
        }
        btn_main_singleTop.setOnClickListener {
            startActivity(Intent(this,SingleTopActivity::class.java))
        }
        btn_main_singleTask.setOnClickListener {
            startActivity(Intent(this, SingleTaskActivity::class.java))
        }
        //通过 start 启动服务
        btn_main_service1.setOnClickListener {
            startActivity(Intent(this, ServiceTestActivity::class.java))
        }
    }
}
