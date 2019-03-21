/**
 * Copyright (C), 2017-2019, XXX有限公司
 * FileName: UtilsActivity
 * Author:   kiwilss
 * Date:     2019/3/11 21:34
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.kiwilss.jetpacktest.utils

import android.content.res.Resources
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.blankj.utilcode.util.AdaptScreenUtils
import com.kiwilss.jetpacktest.R

/**
 *@FileName: UtilsActivity
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2019/3/11
 * @desc   : {DESCRIPTION}
 */
class UtilsActivity: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_utils)






    }

    override fun getResources(): Resources {
        return AdaptScreenUtils.adaptWidth(super.getResources(), 1080)
        //return AdaptScreenUtils.closeAdapt(super.getResources())
    }
}