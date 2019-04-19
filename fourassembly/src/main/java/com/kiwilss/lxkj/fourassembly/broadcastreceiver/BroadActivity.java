package com.kiwilss.lxkj.fourassembly.broadcastreceiver;

import android.content.*;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import com.kiwilss.lxkj.fourassembly.R;

/**
 * @author : Lss kiwilss
 * @FileName: BroadActivity
 * @e-mail : kiwilss@163.com
 * @time : 2019/4/18
 * @desc : {DESCRIPTION}
 */
public class BroadActivity extends AppCompatActivity {

    private LocalBroadcastManager localBroadcastManager;
    private LocalBroadcastReceiver mBroadcastReceiver;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad);
    }

    public void normalListener(View view) {
//        Intent intent = new Intent(this, NormalBroadCaseReceiver.class);
//        intent.putExtra("key","broad");
//        sendBroadcast(intent);
        //隐式启动,如果有多个静态注册的广播action 相同,都会收到
//        Intent intent1 = new Intent();
//        intent1.setAction("com.kiwilss.broadcase1");
//        intent1.putExtra("key", "broad");
//        sendBroadcast(intent1);

        //8.0以后,想发送成功就要加上 intent1.setPackage(getPackageName());
        //原因:谷歌在8.0后为了提高效率，删除了静态注册，防止关闭App后广播还在，
        // 造成内存泄漏， 现在静态注册的广播需要指定包名，而动态注册就没有这个问题
        Intent intent1 = new Intent();
        intent1.setAction("com.kiwilss.broadcase1");
        intent1.putExtra("key", "broad");
        intent1.setPackage(getPackageName());
        sendBroadcast(intent1);
    }

    public void orderlyListener(View view) {
        //和无序广播类似
        Intent intent1 = new Intent();
        intent1.setAction("com.kiwilss.broadcase2");
        intent1.putExtra("key","broad");
        //intent1.putExtra("key", "orderly");
        //null 表示没有权限限制
        sendOrderedBroadcast(intent1, null);
    }


    /**
     * 对于LocalBroadcastManager方式发送的应用内广播，
     * 只能通过LocalBroadcastManager动态注册，不能静态注册
     *
     * @param view
     */
    public void appListener(View view) {
        //注册应用内广播接收器
        //步骤1：实例化BroadcastReceiver子类 & IntentFilter mBroadcastReceiver
        mBroadcastReceiver = new LocalBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter();
        //步骤2：实例化LocalBroadcastManager的实例
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
//步骤3：设置接收广播的类型
        intentFilter.addAction("com.kiwilss.local");
//4,注册
        localBroadcastManager.registerReceiver(mBroadcastReceiver, intentFilter);


        //发送应用内广播测试
        Intent intent = new Intent("com.kiwilss.local");
        intent.putExtra("key","本地广播");
        localBroadcastManager.sendBroadcast(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //取消注册本地广播
        if (mBroadcastReceiver != null && localBroadcastManager != null)
        localBroadcastManager.unregisterReceiver(mBroadcastReceiver);

        //取消网络监听注册
        if (netBroadcastReceiver != null)
            unregisterReceiver(netBroadcastReceiver);
    }




    class LocalBroadcastReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            Log.e("MMM", "onReceive: " + intent.getStringExtra("key"));
        }
    }

    /**普通广播,动态注册
     * @param view
     */
    public void normalDynamicListener(View view) {
        //动态注册广播发送消息
        Intent intent = new Intent("com.kiwilss.normaldynamic");
        intent.putExtra("key","普通广播动态注册");
        sendBroadcast(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //普通广播注册
        if (mBroadcastReceiver == null){
            mBroadcastReceiver = new LocalBroadcastReceiver();
            IntentFilter intentFilter = new IntentFilter("com.kiwilss.normaldynamic");
            registerReceiver(mBroadcastReceiver,intentFilter);
        }
    }


    @Override
    protected void onPause() {
        super.onPause();
        //普通广播解除注册
        if (mBroadcastReceiver != null) {
            unregisterReceiver(mBroadcastReceiver);
        }
    }


    /**系统广播,示例监听网络
     * @param view
     */
    NetBroadcastReceiver netBroadcastReceiver;
    public void appDynamicListener(View view) {
         netBroadcastReceiver = new NetBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(netBroadcastReceiver,intentFilter);
        //ondestory中取消注册
    }

    class NetBroadcastReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            Log.e("MMM", "onReceive: 网络有变化" );
            //连接或是关闭网络时可以监控
        }
    }

}
