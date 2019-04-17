package com.kiwilss.lxkj.fourassembly.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import static com.kiwilss.lxkj.fourassembly.service.StartService.TAG;

/**
 * @author : Lss kiwilss
 * @FileName: LocalService
 * @e-mail : kiwilss@163.com
 * @time : 2019/4/17
 * @desc : {DESCRIPTION}本地服务
 */
public class LocalService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    //启动Service之后，就可以在onCreate()或onStartCommand()方法里去执行一些具体的逻辑
//由于这里作Demo用，所以只打印一些语句
    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG, "onCreate: " );
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(TAG, "onStartCommand: "+intent.getStringExtra("key") );
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy: " );
    }
}
