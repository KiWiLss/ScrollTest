/**
 * Copyright (C), 2017-2019, XXX有限公司
 * FileName: OneActivity
 * Author:   kiwilss
 * Date:     2019/4/2 11:34
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.kiwilss.lxkj.fourassembly.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.kiwilss.lxkj.fourassembly.R
import com.lxj.xpopup.XPopup
import kotlinx.android.synthetic.main.activity_one.*

/**
 *@FileName: OneActivity
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2019/4/2
 * @desc   : {DESCRIPTION}
 */
const val TAG = "MMM"

class OneActivity: AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_one)

        Log.e(TAG, "one ---- oncreate: " );


        btn_one_to.setOnClickListener {
            startActivity(Intent(this,TwoActivity::class.java))
        }

        btn_one_xpop.setOnClickListener {

            XPopup.Builder(this)
                .asConfirm("简单对话框","查看当前Activity生命周期"){
                    Toast.makeText(this,"yes",Toast.LENGTH_SHORT).show()
                }
                .show()

        }

    }

    override fun onStart() {
        super.onStart()
        Log.e(TAG, "one ---- onStart: " );
    }

    override fun onRestart() {
        super.onRestart()
        Log.e(TAG, "one ---- onRestart: ");
    }

    override fun onResume() {
        super.onResume()
        Log.e(TAG, "one ---- onResume: " );
    }

    override fun onPause() {
        super.onPause()
        Log.e(TAG, "one ---- onPause: " );
    }

    override fun onStop() {
        super.onStop()
        Log.e(TAG, "one ---- onStop: " );
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG, "one ---- onDestroy: " );
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.e(TAG, "onRestoreInstanceState: ");
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        Log.e(TAG, "onSaveInstanceState: " );
    }
}