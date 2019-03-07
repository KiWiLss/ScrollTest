/**
 * Copyright (C), 2017-2019, XXX有限公司
 * FileName: SmartToastActivity
 * Author:   kiwilss
 * Date:     2019/3/7 11:42
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.kiwilss.scrolltest.uik

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.coder.zzq.smartshow.snackbar.SmartSnackbar
import com.kiwilss.scrolltest.R
import com.lxj.androidktx.core.click
import com.lxj.androidktx.core.toast
import kotlinx.android.synthetic.main.activity_smart_toast.*

/**
 *@FileName: SmartToastActivity
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2019/3/7
 * @desc   : {DESCRIPTION}
 */
 class SmartToastActivity: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_smart_toast)

        initClickListener()



    }

    private fun initClickListener() {



//        btn_smart_toast.click {
//            //SmartToast.show("hello")
//            //SmartToast.showInCenter("hello")
//            //SmartToast.showAtTop("hello")
//
//            SmartToast.info("hello")
//        }

        SmartSnackbar.setting().backgroundColorRes(R.color.colorAccent)

        btn_smart_snack.click {
            //单纯的文本
            //SmartTopbar.get(this).show("hello")
            //文本加动作
//            SmartTopbar.get(this).show("hello","good"){
//                toast("world")
//            }
            //SmartSnackbar.get(this).show("snackbar")
            SmartSnackbar.get(this).show("hello","action"){
                toast("good")
            }


            //SmartSnackbar.get(this).show("")
            //原生的snackbar
            //Snackbar.make(it,"hello",Snackbar.LENGTH_SHORT).show()

            //原生带点击的snackbar
//            Snackbar.make(it,"hello",Snackbar.LENGTH_SHORT).setAction("good"){
//                toast("yes")
//            }.show()


        }

    }
}