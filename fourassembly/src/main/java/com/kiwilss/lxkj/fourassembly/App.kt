/**
 * Copyright (C), 2017-2019, XXX有限公司
 * FileName: App
 * Author:   kiwilss
 * Date:     2019/4/2 11:36
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.kiwilss.lxkj.fourassembly

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

/**
 *@FileName: App
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2019/4/2
 * @desc   : {DESCRIPTION}
 */
class App: Application(){
    companion object {
        @SuppressLint("StaticFieldLeak")
        var mContext: Context? = null
    }
    override fun onCreate() {
        super.onCreate()
        mContext = this.applicationContext

    }
}