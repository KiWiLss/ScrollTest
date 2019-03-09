package com.kiwilss.jetpacktest

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.kiwilss.jetpacktest.life.LifeCycleActivity
import com.kiwilss.jetpacktest.livedata.LiveDataActivity
import com.kiwilss.jetpacktest.viewmodel.ModelActivity
import com.lxj.androidktx.core.click
import com.lxj.androidktx.core.startActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initClick()
    }

    private fun initClick() {
        btn_main_lifecycler.click {

//            startActivity<LifeActivity>(bundle = arrayOf(
//                "key" to "value"
//            ))

            startActivity<LifeCycleActivity>()
        }

        btn_main_livedata.click {
            startActivity<LiveDataActivity>()
        }

        btn_main_model.click {
            startActivity<ModelActivity>()
        }


    }
}
