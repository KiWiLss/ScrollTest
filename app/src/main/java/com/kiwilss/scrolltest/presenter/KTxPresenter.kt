/**
 * Copyright (C), 2017-2019, XXX有限公司
 * FileName: KTxPresenter
 * Author:   kiwilss
 * Date:     2019/3/4 15:02
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.kiwilss.scrolltest.presenter

import com.kiwilss.scrolltest.model.modelk.BaseBean
import com.kiwilss.scrolltest.model.modelk.login.LoginIn
import com.kiwilss.scrolltest.utils.StringUtils
import com.kiwilss.scrolltest.utils.ToastUtils.Companion.handlerResult
import com.kiwilss.scrolltest.utils.hint
import com.lxj.androidktx.core.e
import com.lxj.androidktx.okhttp.get
import com.lxj.androidktx.okhttp.http
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 *@FileName: KTxPresenter
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2019/3/4
 * @desc   : {DESCRIPTION}
 */
class KTxPresenter{

    fun loginTest(name: String?,pwd: String?){

//       ToastUtils.handlerHint(name,"no name")?.run {
//           "has name".e()
//       }

//        ToastUtils.handlerHint2(name,ToastUtils.HINT_NAME)?.run {
//            "has name".e()
//        }

        name.hint(StringUtils.HINT_NAME)?.run {
            "has name".e()
        }


//
//        if (name.isNullOrEmpty()) {
//            ToastUtils.toast("name")
//            return
//        }
//        if (pwd.isNullOrEmpty()){
//            ToastUtils.toast("pwd")
//            return
//        }
        GlobalScope.launch {
            val job: BaseBean<LoginIn>? = "https://lepaytest.weemang.com/vm.open/mch/login?phone=18657194104&password=654321&deviceToken=77a84c376dd141c9bcc8f924099cc92a&deviceType=ANDROID"
                .http().get<BaseBean<LoginIn>>().await()
            job.toString().e()
            handlerResult(job,"login")
        }

    }



}