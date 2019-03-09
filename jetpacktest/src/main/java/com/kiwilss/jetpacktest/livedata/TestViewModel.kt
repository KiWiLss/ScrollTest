/**
 * Copyright (C), 2017-2019, XXX有限公司
 * FileName: TestViewModel
 * Author:   kiwilss
 * Date:     2019/3/7 23:19
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.kiwilss.jetpacktest.livedata

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

/**
 *@FileName: TestViewModel
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2019/3/7
 * @desc   : {DESCRIPTION}
 */
class TestViewModel: ViewModel(){

    var mCurrent: MutableLiveData<String>? = null

    get() {
        if (field == null){
            field = MutableLiveData()
        }
        return field
    }

}