/**
 * Copyright (C), 2017-2019, XXX有限公司
 * FileName: KTXRVActivity
 * Author:   kiwilss
 * Date:     2019/3/5 11:13
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.kiwilss.scrolltest.uik


import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.kiwilss.scrolltest.R
import com.lxj.androidktx.core.click
import kotlinx.android.synthetic.main.activity_ktx_rv.*
/**
 *@FileName: KTXRVActivity
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2019/3/5
 * @desc   : {DESCRIPTION}
 */
class KTXRVActivity: AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ktx_rv)

        //init data
        val dataList = arrayListOf<Int>().run {
            for (i in 1..30){
               add(i)
            }
        }


        btn_ktx_rv_get.click {



        }



    }
}