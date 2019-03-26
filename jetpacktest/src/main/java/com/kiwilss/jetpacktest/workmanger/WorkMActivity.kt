/**
 * Copyright (C), 2017-2019, XXX有限公司
 * FileName: WorkMActivity
 * Author:   kiwilss
 * Date:     2019/3/26 17:32
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.kiwilss.jetpacktest.workmanger

import android.arch.lifecycle.Observer
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.kiwilss.jetpacktest.R
import com.lxj.androidktx.core.click
import kotlinx.android.synthetic.main.activity_work.*

/**
 *@FileName: WorkMActivity
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2019/3/26
 * @desc   : {DESCRIPTION}
 */
class WorkMActivity: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work)

        btn_work_start.click {
            /**
             * 简单示例
             */
//            //创建一个单次执行的request
//            val workRequest = OneTimeWorkRequest.Builder(TestWorker::class.java).build()
//            WorkManager.getInstance().enqueue(workRequest)
//            //调用WorkManger的getStatusByIdLiveData（）返回任务执行的状态LiveData<WorkStatus>
//            //添加Observe（）执行观察回调
//            WorkManager.getInstance().getStatusByIdLiveData(workRequest.id)
//                .observe(this, Observer {
//                    Log.e("MMM", it?.state?.name)
//                    if (it?.state!!.isFinished) {
//                        Log.e("MMM", "Finish")
//                    }
//                })

            // 在连接网络、插入电源且设备处于空闲时运行
            val myConstraints = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                Constraints.Builder()
                    .setRequiredNetworkType(NetworkType.CONNECTED)
                    //.setRequiresCharging(true)
                    //.setRequiresDeviceIdle(true)
                    .build()
            } else {
                Constraints.Builder()
                    .setRequiredNetworkType(NetworkType.CONNECTED)
                    //.setRequiresCharging(true)
                    //.setRequiresDeviceIdle(true)
                    .build()
            }
            //添加约束条件
            val compressionWork = OneTimeWorkRequest.Builder(TestWorker::class.java)
                .setConstraints(myConstraints)
                .build()

                        WorkManager.getInstance().getStatusByIdLiveData(compressionWork.id)
                .observe(this, Observer {
                    Log.e("MMM", it?.state?.name)
                    if (it?.state!!.isFinished) {
                        Log.e("MMM", "Finish")
                    }
                })



        }




    }
}