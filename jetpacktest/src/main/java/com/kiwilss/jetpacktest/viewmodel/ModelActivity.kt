/**
 * Copyright (C), 2017-2019, XXX有限公司
 * FileName: ModelActivity
 * Author:   kiwilss
 * Date:     2019/3/8 11:32
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.kiwilss.jetpacktest.viewmodel

import android.annotation.SuppressLint
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.kiwilss.jetpacktest.R
import com.lxj.androidktx.core.click
import kotlinx.android.synthetic.main.activity_model.*

/**
 *@FileName: ModelActivity
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2019/3/8
 * @desc   : {DESCRIPTION}
 */
class ModelActivity: AppCompatActivity(){
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_model)

        //init viewmodel

        val model = ViewModelProviders.of(this)[Model::class.java]

      //设置文字
        tv_model_text.text = "no change = 111111"

        //点击
        btn_model_change.click {
            //改变 model 的值
            model.textname = "change = 33333"
            tv_model_text.text = model.textname
            //tv_model_text.text = "change = 2222222"
        }

    }
}