package com.kiwilss.scrolltest

import android.app.Application
import android.content.Context
import com.lxj.androidktx.AndroidKtxConfig
import com.lxj.androidktx.AndroidKtxConfig.context
import com.lxj.androidktx.core.e
import com.lxj.androidktx.okhttp.OkWrapper
import com.lxj.androidktx.util.NetworkUtils
import okhttp3.CacheControl
import okhttp3.Interceptor

/**
 * @author : Lss kiwilss
 * @FileName: MyApp
 * @e-mail : kiwilss@163.com
 * @time : 2019/2/21
 * @desc : {DESCRIPTION}
 */
class MyApp : Application() {

     var context: Context? = null

    companion object {
        fun getContext(): Context = context
    }

    override fun onCreate() {
        super.onCreate()

         context = this.applicationContext


        //mmkv初始化
        //MMKV.initialize(this)

        //ktx init
        //AndroidKtxConfig.INSTANCE.init(this)
        AndroidKtxConfig.init(this,defaultLogTag = "MMM")
        // 也可以详细注册，自定义配置
        //        AndroidKtxConfig.init(context = this,
        //                isDebug = BuildConfig.DEBUG,
        //                defaultLogTag = "logTag",
        //                sharedPrefName = "spName")

        //设置自定义拦截器
        OkWrapper.interceptors(Interceptor {
            var request = it.request()

            if (!NetworkUtils.isConnected()) {//网络未连接
                request = request.newBuilder().cacheControl(CacheControl.FORCE_CACHE).build()
            }
            val originalResponse = it.proceed(request)
            //获取cookie
            val cookies = originalResponse.headers("Set-Cookie")

            // ["SESSION=ec42c395-69e2-4563-b20b-c01386f27561; Path=/vm.open/; HttpOnly","SESSION=ec42c395-69e2-4563-b20b-c01386f27561; Path=/msf.open/; HttpOnly"]
            if (cookies.size > 0) {
                cookies[0].e()
            }

            val cacheControl = request.cacheControl().toString()

            if (NetworkUtils.isConnected()) {
                originalResponse.newBuilder()
                    .header("Cache-Control", cacheControl)
                    .removeHeader("Pragma") // 清除头信息，因为服务器如果不支持，会返回一些干扰信息，不清除下面无法生效
                    .build()
            }else{
                // 无网络时 设置超时为1周
                val maxStale = 60 * 60 * 24 * 7
                 originalResponse.newBuilder()
                    .header("Cache-Control", "public, only-if-cached, max-stale=$maxStale")
                    .removeHeader("Pragma")
                    .build()
            }
        })





    }
}
