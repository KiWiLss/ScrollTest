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
import androidx.navigation.Navigation
import com.kiwilss.jetpacktest.R
import com.lxj.androidktx.core.click
import kotlinx.android.synthetic.main.fg_navigation_one.*

/**
 *@FileName: FgOne
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2019/3/26
 * @desc   : {DESCRIPTION}
 */
class FgOne: Fragment(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fg_navigation_one, container, false)

        Log.e("MMM", ": fg one create view")
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e("MMM", ": fg one  view  create")

        mJumpBtn.click {
            //点击跳转到下一个fragment
            //Navigation.findNavController(view).navigate(R.id.fgTwo)
            //点击传参数
            Navigation.findNavController(view).navigate(R.id.fgTwo, Bundle().apply {
                putString("name", "tracy")
                putInt("age", 35)
            })
        }
    }

}