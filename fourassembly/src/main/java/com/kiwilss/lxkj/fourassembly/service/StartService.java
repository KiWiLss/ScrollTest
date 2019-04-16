package com.kiwilss.lxkj.fourassembly.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * @author : Lss kiwilss
 * @FileName: StartService
 * @e-mail : kiwilss@163.com
 * @time : 2019/4/16
 * @desc : {DESCRIPTION}
 */
public class StartService extends Service {

    public static final String TAG = "MMM";

    //@androidx.annotation.Nullable
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e(TAG, "onBind: " );
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG, "onCreate: ");
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String key = intent.getStringExtra("key");
        Log.e(TAG, "onStartCommand: " + key);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy: " );
    }
}
