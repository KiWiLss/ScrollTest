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

import com.kiwilss.scrolltest.config.URL_BASEURL

/**
 *@FileName: StringUtils
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2019/3/4
 * @desc   : {DESCRIPTION}
 */




object StringUtils{
    const val HINT_NAME = "no name"



}

/**
 * 拼接网址
 * @receiver String
 * @param map Map<String,Any>
 * @return String
 */

fun String.splicingUrl(map: Map<String,Any>): String{
    val stringBuffer = StringBuffer(URL_BASEURL)
    stringBuffer.append("$this?")
    map.forEach {
        stringBuffer.append(it.key + "=" + it.value + "&")
    }
    return stringBuffer.deleteCharAt(stringBuffer.lastIndex).toString()
}

fun String.splicingUrl(vararg params: Pair<String, Any>): String{
    val stringBuffer = StringBuffer(URL_BASEURL)
    stringBuffer.append("$this?")
    params.forEach {
        stringBuffer.append("${it.first}=${it.second}&")
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

/**
 * 自定义点击事件
 * @receiver View?
 * @param action (view: View) -> Unit
 */
//fun View?.setOnClick(action: (view: View) -> Unit){
//    this?.run {
//        //setOnClickListener(action)
//        setOnClickListener {
//            action(it)
//        }
//    }
//}

