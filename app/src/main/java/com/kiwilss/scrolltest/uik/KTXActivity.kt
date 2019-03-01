/**
 * Copyright (C), 2017-2019, XXX有限公司
 * FileName: KTXActivity
 * Author:   kiwilss
 * Date:     2019/2/26 11:41
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.kiwilss.scrolltest.uik

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.kiwilss.scrolltest.R
import com.kiwilss.scrolltest.model.modelk.Province
import com.lxj.androidktx.core.*
import com.lxj.androidktx.okhttp.get
import com.lxj.androidktx.okhttp.http
import kotlinx.android.synthetic.main.activity_ktx.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

/**
 *@FileName: KTXActivity
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2019/2/26
 * @desc   : {DESCRIPTION}
 */
class KTXActivity: AppCompatActivity(){


     val UI: CoroutineContext = Dispatchers.Main


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ktx)


    //Log
        "log v".v()
        "log w".w()
        "log info".e()
        "log i".i()

    //span
        val text: String = tv_ktx_span.text as String

        tv_ktx_span.backgroundColorSpan(text,0..2)

        tv_ktx_span.click {
            toast(text)
        }

        //动态设置宽高

        //tv_ktx_dynamic.animateWidthAndHeight(200,300)

        //imageview 设置图片
        val url = "http://lechinepay.oss-cn-hangzhou.aliyuncs.com/lxf/app_image/00260001_lxf/20160720172918-3.png"
        iv_ktx_url.load(url)


        //sp
        sp().putBoolean("isTrue",true)

        sp().edit {
            putString("key","string value")
            putString("keyT", "string value two")
        }

        sp().getString("key","").e()

        sp().getBoolean("isTrue",false).toString().e()

        mmkv().encode("key","value")

        //正则表达式
        "18657194104".isPhone().toString().e()

        //子线程,主线程
//        Thread(
//            Runnable {
//                runOnUiThread { }
//            }
//        ).start()
        //网络相关
        btn_ket_net.click {
            //Anko协程切换
//            doAsync {
//                uiThread {
//                }
//                UI {
//                }
//            }
            //可以用的协程切换
//            runBlocking {
//                val job = async {
//                    return@async "http://guolin.tech/api/china".http().get<List<Province>>().await()
//                }
//                job.await()!![0].name.e()
//                tv_ket_net.text = job.await()!![0].name
//            }

            //可用的方法二
//            GlobalScope.launch(Dispatchers.Main){
//                "hello".e()
//                tv_ket_net.text = "hello word"
//                val result = async {
//                    return@async "http://guolin.tech/api/china".http().get<List<Province>>().await()
//                }.await()
//                tv_ket_net.text = result!![0].name
//            }
            //可用的切换三
            GlobalScope.launch {
               val job =  "http://guolin.tech/api/china".http().get<List<Province>>().await()
                job!![0].name.e()
                launch(Dispatchers.Main){
                    tv_ket_net.text = job[0].name
                }
            }

        }









    }


}