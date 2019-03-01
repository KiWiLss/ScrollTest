/**
 * Copyright (C), 2017-2019, XXX有限公司
 * FileName: TestFg
 * Author:   kiwilss
 * Date:     2019/2/28 11:29
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.kiwilss.scrolltest.fg

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lxj.androidktx.core.sp

/**
 *@FileName: TestFg
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2019/2/28
 * @desc   : {DESCRIPTION}
 */
class TestFg: Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {


        context?.let {
            it.sp()
        }

        context?.apply {

        }



        context?.also {
            it.sp()
        }

        with(context){
            //sp()
        }

        context?.run {
            sp()
        }

        return super.onCreateView(inflater, container, savedInstanceState)
    }
}