package com.kiwilss.scrolltest

import android.app.Application
import com.lxj.androidktx.AndroidKtxConfig
import com.tencent.mmkv.MMKV

/**
 * @author : Lss kiwilss
 * @FileName: MyApp
 * @e-mail : kiwilss@163.com
 * @time : 2019/2/21
 * @desc : {DESCRIPTION}
 */
class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()

        //mmkv初始化
        MMKV.initialize(this)

        //ktx init
        //AndroidKtxConfig.INSTANCE.init(this)
        AndroidKtxConfig.init(this,defaultLogTag = "MMM")
        // 也可以详细注册，自定义配置
        //        AndroidKtxConfig.init(context = this,
        //                isDebug = BuildConfig.DEBUG,
        //                defaultLogTag = "logTag",
        //                sharedPrefName = "spName")

    }
}
