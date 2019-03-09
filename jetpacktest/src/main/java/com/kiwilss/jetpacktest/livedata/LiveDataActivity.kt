/**
 * Copyright (C), 2017-2019, XXX有限公司
 * FileName: LiveDataActivity
 * Author:   kiwilss
 * Date:     2019/3/7 23:23
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.kiwilss.jetpacktest.livedata


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.kiwilss.jetpacktest.R
import com.lxj.androidktx.core.click
import kotlinx.android.synthetic.main.activity_livedata.*

/**
 *@FileName: LiveDataActivity
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2019/3/7
 * @desc   : {DESCRIPTION}
 */
class LiveDataActivity : AppCompatActivity() {

    lateinit var mModel: TestViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_livedata)


// 如果在View Model中使用，先创建ViewModel的对象
        mModel = ViewModelProviders.of(this).get(TestViewModel::class.java)

        //创建观察者对象
        val nameObserable = Observer<String> {
            // 定义onChange（）方法中的操作
            tv_text.text = it
        }



// mCurrent 订阅观察
        mModel.mCurrent!!.observe(this, nameObserable)



// 设置两个点击事件，修改LiveData中的数据
        btn_change.click {
            mModel.mCurrent!!.value = "22222222222"
        }

        btn_btn.click {
            mModel.mCurrent!!.value = "33333333"
        }
    }
}