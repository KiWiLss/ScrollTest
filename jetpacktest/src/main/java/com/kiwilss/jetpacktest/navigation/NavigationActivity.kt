/**
 * Copyright (C), 2017-2019, XXX有限公司
 * FileName: NavigationActivity
 * Author:   kiwilss
 * Date:     2019/3/26 15:39
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.kiwilss.jetpacktest.navigation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.kiwilss.jetpacktest.R
import kotlinx.android.synthetic.main.activity_navigation.*

/**
 *@FileName: NavigationActivity
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2019/3/26
 * @desc   : {DESCRIPTION}
 */
class NavigationActivity: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)


    }

    //控制回退
    override fun onSupportNavigateUp() = NavHostFragment.findNavController(mainBlankFragment).navigateUp()

}