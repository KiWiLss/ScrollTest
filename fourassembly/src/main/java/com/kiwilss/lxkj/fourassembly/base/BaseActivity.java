package com.kiwilss.lxkj.fourassembly.base;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * @author : Lss kiwilss
 * @FileName: BaseActivity
 * @e-mail : kiwilss@163.com
 * @time : 2019/4/15
 * @desc : {DESCRIPTION}
 */
@SuppressLint("Registered")
public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.i("MMM", "*****onCreate()方法******");
        Log.i("MMM", "onCreate：" + getClass().getSimpleName() + " TaskId: " + getTaskId() + " hasCode:" + this.hashCode());
        dumpTaskAffinity();



    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.i("MMM", "*****onNewIntent()方法*****");
        Log.i("MMM", "onNewIntent：" + getClass().getSimpleName() + " TaskId: " + getTaskId() + " hasCode:" + this.hashCode());
        dumpTaskAffinity();
    }

    protected void dumpTaskAffinity(){
        try {
            ActivityInfo info = this.getPackageManager()
                    .getActivityInfo(getComponentName(), PackageManager.GET_META_DATA);
            Log.i("MMM", "taskAffinity:"+info.taskAffinity);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}
