/**
 * Copyright (C), 2017-2019, XXX有限公司
 * FileName: ToastUtils
 * Author:   kiwilss
 * Date:     2019/3/4 15:05
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.kiwilss.scrolltest.utils

import android.widget.Toast
import com.kiwilss.scrolltest.MyApp
import com.kiwilss.scrolltest.model.modelk.BaseBean
import com.lxj.androidktx.bus.LiveDataBus

/**
 *@FileName: ToastUtils
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2019/3/4
 * @desc   : {DESCRIPTION}
 */
class ToastUtils {



    companion object {

        val HINT_NAME = "name"
        val HINT_PWD = "pwd"

        /**
         * 全局吐司
         * @param mes String?
         */
        fun toast(mes: String?) {
            if (!mes.isNullOrEmpty()) {
                Toast.makeText(MyApp.getContext(), mes, Toast.LENGTH_SHORT).show()
            }
        }

        /**
         * 统一处理返回结果
         * @param data BaseBean<T>?
         * @param key String
         */
        fun <T> handlerResult(data: BaseBean<T>?, key: String) {
            //判断异常出现的原因
            data?.run {
                if (result == null) {
                    if (message != null) {
                        LiveDataBus.with<String>("error").postValue(message)
                    }
                } else {
                    LiveDataBus.with<T>(key).postValue(result)
                    //LiveDataBus.with<T>(key).setValue(result)
                }
            }
        }

        fun handlerHint(data: String?, hint: String): Any? {
            return if (data.isNullOrEmpty()) {
                toast(hint)
                null
            } else{
                ""
            }
        }



        fun handlerHint2(data: String?, type: String): Any? {
            return if (data.isNullOrEmpty()) {
                toast(type)
                null
            } else{
                ""
            }
        }

    }




}




