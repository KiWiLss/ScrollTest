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
import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.kiwilss.scrolltest.R
import com.kiwilss.scrolltest.config.URL_LOGIN
import com.kiwilss.scrolltest.model.modelk.BaseBean
import com.kiwilss.scrolltest.model.modelk.Province
import com.kiwilss.scrolltest.model.modelk.login.LoginIn
import com.kiwilss.scrolltest.presenter.KTxPresenter
import com.kiwilss.scrolltest.utils.splicingUrl
import com.lxj.androidktx.bus.LiveDataBus
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

    val mPresenter: KTxPresenter by lazy {
        KTxPresenter()
    }


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ktx)


        //出现错误时接收错误信息
        LiveDataBus.with<String>("error").observe(this,observer = Observer {
            it?.e()
            toast(it!!)
        })


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
//                launch(Dispatchers.Main){
//                    tv_ket_net.text = job[0].name
//                }
                // 发送消息
                LiveDataBus.with<String>("data").postValue(job[0].name)
                //LiveDataBus.with<String>("result").setValue(job[0].name)
            }

        }

        //接收数据
        LiveDataBus.with<List<Province>>("data2").observe(this,observer = Observer {
            it?.forEach {
                tv_ket_net2.text = tv_ket_net2.text.toString()+it.name
            }
        })
        //获取数据
        LiveDataBus.with<LoginIn>("login").observe(this,observer = Observer {
            it?.run {
                tv_ket_net2.text = mchOpenDTO.merchantName
            }
        })


        btn_ket_net2.click {

            /**
             * presenter
             */
            mPresenter.loginTest("jjj","pwd")
            GlobalScope.launch {
//                val job =  "http://guolin.tech/api/china".http().get<List<Province>>().await()
//                if (job != null) {
//                    LiveDataBus.with<List<Province>>("data2").postValue(job)
//                }
                /**
                 *   获取原始数据
                 */
//                    val job: LoginInfo? = "https://lepaytest.weemang.com/vm.open/mch/login?phone=18657194104&password=6543210&deviceToken=77a84c376dd141c9bcc8f924099cc92a&deviceType=ANDROID"
//                        .http().get<LoginInfo>().await()
//
//                job.toString().e()
//                    job?.run {
//                        message.e()
//                    }
                /**
                 *     //处理后的数据
                 */
//                val job: BaseBean<LoginIn>? = "https://lepaytest.weemang.com/vm.open/mch/login?phone=18657194104&password=6543210&deviceToken=77a84c376dd141c9bcc8f924099cc92a&deviceType=ANDROID"
//                    .http().get<BaseBean<LoginIn>>().await()
//                job.toString().e()
//               handlerResult(job,"login")
            }
        }

        // 接收消息
        LiveDataBus.with<String>("data").observe(this, observer = Observer {
           tv_ket_net.text = it
        })

        // 接收消息
        LiveDataBus.with<String>("key2").observe(this, observer = Observer {
            tv_ket_net3.text = it
        })

        btn_ket_net3.setOnClickListener {
            "click btnSendObject".e()
            //LiveDataBus.with<String>("key2").setValue("李晓俊")
            //测试拼接网址
            val map = HashMap<String,Any>()
            map.run {
                this["name"] = "李小军"
               this["phone"] = "12903828302382380"
            }
            URL_LOGIN.splicingUrl(map).e()
            URL_LOGIN.splicingUrl("name" to "李小军", "pwd" to "123456").e()

        }





    }


    private fun  <T>handlerResult(data: BaseBean<T>?, key: String){
        data?.run {
            if (result == null) {
                if (message != null) {
                    LiveDataBus.with<String>("error").postValue(message)
                }
            }else{
                LiveDataBus.with<T>(key).postValue(result)
            }
        }
    }


}