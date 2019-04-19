package com.kiwilss.lxkj.fourassembly.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import static com.kiwilss.lxkj.fourassembly.service.StartService.TAG;

/**
 * @author : Lss kiwilss
 * @FileName: OrderlyBroadcastReceiver
 * @e-mail : kiwilss@163.com
 * @time : 2019/4/18
 * @desc : {DESCRIPTION}
 */
public class OrderlyBroadcastReceiver2 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e(TAG, "onReceive22 : "+intent.getStringExtra("key"));

        Bundle bundle = getResultExtras(true);
        String broad = bundle.getString("broad");
        Log.e(TAG, "onReceive222 : "+ broad );
    }
}
