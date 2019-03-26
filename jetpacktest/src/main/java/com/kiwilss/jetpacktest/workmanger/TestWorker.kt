/**
 * Copyright (C), 2017-2019, XXX有限公司
 * FileName: TestWorker
 * Author:   kiwilss
 * Date:     2019/3/26 17:25
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.kiwilss.jetpacktest.workmanger

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

/**
 *@FileName: TestWorker
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2019/3/26
 * @desc   : {DESCRIPTION}
 */
class TestWorker(context: Context, workerParameters: WorkerParameters)
    : Worker(context,workerParameters) {
    override fun doWork(): Result {
        Log.e("MMM", "执行了 doWork() 操作！")
        return Result.SUCCESS
    }
}