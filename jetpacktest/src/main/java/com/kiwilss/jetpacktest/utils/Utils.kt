/**
 * Copyright (C), 2017-2019, XXX有限公司
 * FileName: Utils
 * Author:   kiwilss
 * Date:     2019/3/12 14:04
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.kiwilss.jetpacktest.utils

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri

/**
 *@FileName: Utils
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2019/3/12
 * @desc   : {DESCRIPTION}
 */

/**
 * 打电话
 * @receiver Context
 * @param number String
 * @return Boolean
 */
@SuppressLint("MissingPermission")
fun Context.makeCall(number: String): Boolean {
    try {
        val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:$number"))
        startActivity(intent)
        return true
    } catch (e: Exception) {
        e.printStackTrace()
        return false
    }
}


