package com.kiwilss.lxkj.fourassembly.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;

import static com.kiwilss.lxkj.fourassembly.service.StartService.TAG;

/**
 * @author : Lss kiwilss
 * @FileName: OrderlyBroadcastReceiver
 * @e-mail : kiwilss@163.com
 * @time : 2019/4/18
 * @desc : {DESCRIPTION}
 */
public class OrderlyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e(TAG, "onReceive: "+intent.getStringExtra("key"));

        if (TextUtils.equals("orderly",intent.getStringExtra("key"))) {
            //中断传递
            abortBroadcast();
        }else {
            //传递新的信息给下一个广播
            Bundle bundle = new Bundle();
            bundle.putString("broad","新的信息");
            setResultExtras(bundle);
        }
    }
}
