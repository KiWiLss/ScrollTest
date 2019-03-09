/**
 * Copyright (C), 2017-2019, XXX有限公司
 * FileName: LifeCycleActivity
 * Author:   kiwilss
 * Date:     2019/3/7 23:07
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.kiwilss.jetpacktest.life

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.kiwilss.jetpacktest.R
import com.lxj.androidktx.core.toast

/**
 *@FileName: LifeCycleActivity
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2019/3/7
 * @desc   : {DESCRIPTION}
 */
class LifeCycleActivity: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life)

        val myObserver = MyObserver(lifecycle, object : Callback{
            override fun update(string: String) {
                toast(string)
            }
        })

        lifecycle.addObserver(myObserver)
    }
}