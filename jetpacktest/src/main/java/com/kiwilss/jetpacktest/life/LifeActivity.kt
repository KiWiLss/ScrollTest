/**
 * Copyright (C), 2017-2019, XXX有限公司
 * FileName: LifeActivity
 * Author:   kiwilss
 * Date:     2019/3/7 17:23
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.kiwilss.jetpacktest.life

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LifecycleRegistry
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.kiwilss.jetpacktest.R
import com.lxj.androidktx.core.e
import com.lxj.androidktx.core.toast

/**
 *@FileName: LifeActivity
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2019/3/7
 * @desc   : {DESCRIPTION}
 */
class LifeActivity: AppCompatActivity(),LifecycleOwner{

    //lifecycleregister
    lateinit var lifecycleRegistry: LifecycleRegistry

    override fun getLifecycle(): Lifecycle {
        return lifecycleRegistry
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life)
        //
        intent.getStringExtra("key").e()

        lifecycleRegistry = LifecycleRegistry(this)

        val myObserver = MyObserver(lifecycleRegistry, object : Callback{
            override fun update(string: String) {
                toast(string)
            }

        })

        lifecycleRegistry.addObserver(myObserver)


    lifecycleRegistry.markState(Lifecycle.State.CREATED)



    }

    override fun onResume() {
        super.onResume()
        lifecycleRegistry.markState(Lifecycle.State.RESUMED)
    }

    override fun onDestroy() {
        super.onDestroy()
        lifecycleRegistry.markState(Lifecycle.State.DESTROYED)
    }

}