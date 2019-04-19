package com.kiwilss.lxkj.fourassembly.broadcastreceiver;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import static com.kiwilss.lxkj.fourassembly.service.StartService.TAG;

/**
 * @author : Lss kiwilss
 * @FileName: NormalBroadCaseReceiver
 * @e-mail : kiwilss@163.com
 * @time : 2019/4/18
 * @desc : {DESCRIPTION}
 */
public class NormalBroadCaseReceiver extends BroadcastReceiver {
    @SuppressLint("UnsafeProtectedBroadcastReceiver")
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e(TAG, "onReceive: "+intent.getStringExtra("key") );
    }
}
