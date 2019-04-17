package com.kiwilss.lxkj.fourassembly.service;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * @author : Lss kiwilss
 * @FileName: MyIntentService
 * @e-mail : kiwilss@163.com
 * @time : 2019/4/17
 * @desc : {DESCRIPTION}
 */
public class MyIntentService extends IntentService {
    private static final String TAG = "MMM";

    public MyIntentService(String name) {
        super(name);
    }

    public MyIntentService(){
        // 调用父类的构造函数
        // 参数 = 工作线程的名字
        super("myIntentService");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG, "onCreate: " );
    }

    @Override
    public int onStartCommand( @Nullable Intent intent, int flags, int startId) {
        Log.e(TAG, "onStartCommand: " );
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy: " );
    }

    /**
     * 复写onHandleIntent()方法
     * 根据 Intent实现 耗时任务 操作
     **/
    @Override
    protected void onHandleIntent( @Nullable Intent intent) {
        // 根据 Intent的不同，进行不同的事务处理
        assert intent != null;
        String taskName = intent.getStringExtra("taskName");
        switch (taskName) {
            case "task1":
                Log.e(TAG, "onHandleIntent: task1" );
                break;
            case "task2":
                Log.e(TAG, "onHandleIntent: test2" );
                break;
        }
    }
}
