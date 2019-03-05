/**
 * Copyright (C), 2017-2019, XXX有限公司
 * FileName: StringUtils
 * Author:   kiwilss
 * Date:     2019/3/4 17:05
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.kiwilss.scrolltest.utils

/**
 *@FileName: StringUtils
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2019/3/4
 * @desc   : {DESCRIPTION}
 */
object StringUtils{
    const val HINT_NAME = "no name"

    const val BASEURL = "https://lepaytest.weemang.com/vm.open/mch/login?"

}

fun String.splicingUrl(map: Map<String,Any>): String{
    val stringBuffer = StringBuffer(this)
    map.forEach {
        stringBuffer.append(it.key + "=" + it.value + "&")
    }
    return stringBuffer.deleteCharAt(stringBuffer.lastIndex).toString()
}



fun String?.hint(type: String): Any?{
    return if (this.isNullOrEmpty()){
        ToastUtils.toast(type)
        null
    }else{
        ""
    }
}
