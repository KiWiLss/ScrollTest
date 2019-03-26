/**
 * Copyright (C), 2017-2019, XXX有限公司
 * FileName: FgOne
 * Author:   kiwilss
 * Date:     2019/3/26 16:09
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.kiwilss.jetpacktest.navigation.fg

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kiwilss.jetpacktest.R

/**
 *@FileName: FgOne
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2019/3/26
 * @desc   : {DESCRIPTION}
 */
class FgTwo: Fragment(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fg_navigation_two, container, false)


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            Log.e("MMM", ": "+it.getString("name"))
            Log.e("MMM", ": "+it.getInt("age"))
        }
    }
}