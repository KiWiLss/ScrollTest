/**
 * Copyright (C), 2017-2019, XXX有限公司
 * FileName: MyApp
 * Author:   kiwilss
 * Date:     2019/3/7 22:49
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.kiwilss.jetpacktest

import android.app.Application
import com.lxj.androidktx.AndroidKtxConfig

/**
 *@FileName: MyApp
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2019/3/7
 * @desc   : {DESCRIPTION}
 */
class MyApp: Application(){
    override fun onCreate() {
        super.onCreate()

        AndroidKtxConfig.init(this,defaultLogTag = "MMM")

    }
}