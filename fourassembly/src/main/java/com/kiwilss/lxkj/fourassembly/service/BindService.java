package com.kiwilss.lxkj.fourassembly.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import static com.kiwilss.lxkj.fourassembly.service.StartService.TAG;

/**
 * @author : Lss kiwilss
 * @FileName: BindService
 * @e-mail : kiwilss@163.com
 * @time : 2019/4/17
 * @desc : {DESCRIPTION}可通信的服务,即实现了Activity指挥Service干什么Service就去干什么的功能
 */
public class BindService extends Service {
    //@androidx.annotation.Nullable

    MyBinder myBinder = new MyBinder();
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e(TAG, "onBind: " + intent.getStringExtra("key"));
        return myBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG, "onCreate: " );
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(TAG, "onStartCommand: " );
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e(TAG, "onUnbind: " );
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy: " );
    }

    public void serviceFun(){
        Log.e(TAG, "serviceFun: activity 调用服务里的方法" );
    }

    public void serviceConnectActivity(){
        Log.e(TAG, "serviceConnectActivity: +++++++服务关联activity,并在activity中执行服务中的方法" );
    }
    //新建一个子类继承 binder
    class MyBinder extends Binder{
        public void serviceConnectActivity(){
            Log.e(TAG, "serviceConnectActivity: *****+服务关联activity,并在activity中执行服务中的方法" );
        }

        public BindService getService(){
            return BindService.this;
        }
    }
}
