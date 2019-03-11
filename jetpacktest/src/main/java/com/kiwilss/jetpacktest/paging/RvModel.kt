/**
 * Copyright (C), 2017-2019, XXX有限公司
 * FileName: RvModel
 * Author:   kiwilss
 * Date:     2019/3/11 14:16
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.kiwilss.jetpacktest.paging

import android.app.Application
import android.arch.lifecycle.AndroidViewModel

/**
 *@FileName: RvModel
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2019/3/11
 * @desc   : {DESCRIPTION}
 */
class RvModel(app: Application) : AndroidViewModel(app){

//    val allStudents = LivePagedListBuilder(dao.getAllStudent(), PagedList.Config.Builder()
//        .setPageSize(PAGE_SIZE)                         //配置分页加载的数量
//        .setEnablePlaceholders(ENABLE_PLACEHOLDERS)     //配置是否启动PlaceHolders
//        .setInitialLoadSizeHint(PAGE_SIZE)              //初始化加载的数量
//        .build()).build()

    companion object {
        private const val PAGE_SIZE = 15

        private const val ENABLE_PLACEHOLDERS = false
    }


}