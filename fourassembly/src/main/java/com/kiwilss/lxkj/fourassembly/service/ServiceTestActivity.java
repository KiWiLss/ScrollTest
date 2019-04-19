package com.kiwilss.lxkj.fourassembly.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import com.kiwilss.lxkj.fourassembly.AIDL_Service1;
import com.kiwilss.lxkj.fourassembly.R;

/**
 * @author : Lss kiwilss
 * @FileName: ServiceTestActivity
 * @e-mail : kiwilss@163.com
 * @time : 2019/4/16
 * @desc : {DESCRIPTION}
 */
public class ServiceTestActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_test);





    }

    public void startListener(View view) {
        Intent intent = new Intent(this, StartService.class);
        intent.putExtra("key","start");
        startService(intent);
    }



    public void startStopListener(View view) {
        Intent intent = new Intent(this, StartService.class);
        intent.putExtra("key","stop");
        stopService(intent);
    }

    public void localstartListener(View view) {
        Intent intent = new Intent(this, LocalService.class);
        intent.putExtra("key","start");
        startService(intent);
    }

    public void localStopListener(View view) {
        Intent intent = new Intent(this, LocalService.class);
        stopService(intent);
    }

    BindService.MyBinder myBinder;
    //创建 serviceConnection 匿名类
    private ServiceConnection mSc = new ServiceConnection(){

        //重写onServiceConnected()方法和onServiceDisconnected()方法
        //在Activity与Service建立关联和解除关联的时候调用
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            //实例化Service的内部类myBinder
            //通过向下转型得到了MyBinder的实例
            Log.e("MMM", "onServiceConnected: " );
             myBinder = (BindService.MyBinder) iBinder;
             //调用服务里的方法
            myBinder.serviceConnectActivity();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            Log.e("MMM", "onServiceDisconnected: " );
        }
    };

    public void bindstartListener(View view) {
        //构建绑定服务的Intent对象
        Intent bindIntent = new Intent(this, BindService.class);
        bindIntent.putExtra("key","binder");
        //调用bindService()方法,以此停止服务

        bindService(bindIntent,mSc,BIND_AUTO_CREATE);
        //参数说明
        //第一个参数:Intent对象
        //第二个参数:上面创建的Serviceconnection实例
        //第三个参数:标志位
        //这里传入BIND_AUTO_CREATE表示在Activity和Service建立关联后自动创建Service
        //这会使得MyService中的onCreate()方法得到执行，但onStartCommand()方法不会执行
    }

    public void bindStopListener(View view) {
        //调用unbindService()解绑服务
        //参数是上面创建的Serviceconnection实例
        unbindService(mSc);
    }

    public void bindServiceListener(View view) {
        if (myBinder != null){
            myBinder.serviceConnectActivity();
            myBinder.getService().serviceConnectActivity();
            myBinder.getService().serviceFun();
        }
    }

    public void intentstartListener(View view) {//5.0以后服务只能显示启动
//        Intent intent1 = new Intent();
//        intent1.setAction("cn.scu.finch");
//        startService(intent1);
         //请求1

        Intent intent = new Intent(this, MyIntentService.class);
        intent.putExtra("taskName","task1");
        startService(intent);


        Intent intent2 = new Intent(this, MyIntentService.class);
        intent2.putExtra("taskName","task2");
        startService(intent2);

        startService(intent);


  //多次启动


    }

    /**远程服务
     * @param view
     */
    //远程服务的serviceconnect
    AIDL_Service1 mAIDL_Service;
    private ServiceConnection mLongSc = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
//使用AIDLService1.Stub.asInterface()方法获取服务器端返回的IBinder对象
            //将IBinder对象传换成了mAIDL_Service接口对象
             mAIDL_Service = AIDL_Service1.Stub.asInterface(iBinder);

            try {
                //通过该对象调用在MyAIDLService.aidl文件中定义的接口方法,从而实现跨进程通信
                mAIDL_Service.AIDL_Service();
            } catch (RemoteException e) {
                e.printStackTrace();
            }

        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };
    public void longListener(View view) {
//通过Intent指定服务端的服务名称和所在包，与远程Service进行绑定
        //参数与服务器端的action要一致,即"服务器包名.aidl接口文件名"
//        Intent intent = new Intent("scut.carson_ho.service_server.AIDL_Service1");
//
//        //Android5.0后无法只通过隐式Intent绑定远程Service
//        //需要通过setPackage()方法指定包名
//        intent.setPackage("scut.carson_ho.service_server");
        Intent intent = new Intent(this, LongService.class);
        //绑定服务,传入intent和ServiceConnection对象
        bindService(intent, mLongSc, Context.BIND_AUTO_CREATE);

    }
}
