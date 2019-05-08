package com.kiwilss.lxkj.fourassembly.handler;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.kiwilss.lxkj.fourassembly.R;

import java.lang.ref.WeakReference;

/**
 * @author : Lss kiwilss
 * @FileName: HandlerActivity
 * @e-mail : kiwilss@163.com
 * @time : 2019-05-05
 * @desc : {DESCRIPTION}
 */
public class HandlerActivity extends AppCompatActivity {

    public static final String TAG = "MMM";

    public final int MSG_DOWN_FAIL = 1;
    public final int MSG_DOWN_SUCCESS = 2;
    public final int MSG_DOWN_START = 3;


    private static class MyHandler extends Handler{

        WeakReference<Activity>reference;
         private MyHandler(Activity activity) {
            reference = new WeakReference<Activity>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            HandlerActivity activity = (HandlerActivity) reference.get();
            activity.mTvStatus.setText(msg.obj.toString());
        }
    }



    //初始化 handler
    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            int what = msg.what;
            switch (what) {
                case MSG_DOWN_START:
                    Toast.makeText(HandlerActivity.this, "start", Toast.LENGTH_SHORT).show();
                    break;
                case MSG_DOWN_SUCCESS:
                    Object obj = msg.obj;
                    Toast.makeText(HandlerActivity.this, obj.toString(), Toast.LENGTH_SHORT).show();
                    mTvStatus.setText(obj.toString());
                    break;
                case MSG_DOWN_FAIL:
                    Toast.makeText(HandlerActivity.this, "fail", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };
    private TextView mTvStatus;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);

        mTvStatus = (TextView) findViewById(R.id.tv_handler_status);

        //Looper looper = Looper.myLooper();

        //针对内存泄漏的处理
        MyHandler myHandler = new MyHandler(this);
        Message message = new Message();
        message.obj = "静态类 + 弱引用";
        myHandler.sendMessage(message);

    }

    public void sendMsg1(View view) {
        new Thread(mRunnable1).start();
    }

    Runnable mRunnable1 = new Runnable() {
        @Override
        public void run() {
            Log.e(TAG, "run: start" );
            mHandler.sendEmptyMessage(MSG_DOWN_START);

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Message message = new Message();
            message.what = MSG_DOWN_SUCCESS;
            message.obj = "success";
            mHandler.sendMessage(message);

            Log.e(TAG, "run: end" );
        }
    };

    public void sendPostMsg1(View view) {
        new Thread(mRunnable2).start();
    }
    Runnable mRunnable2 = new Runnable() {
        @Override
        public void run() {
            Log.e(TAG, "run: start" );
            mHandler.sendEmptyMessage(MSG_DOWN_START);

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //切换到主线程
           mHandler.post(new Runnable() {
               @Override
               public void run() {
                   mTvStatus.setText("消息状态----success");
                   Log.e(TAG, "run: end" );
               }
           });


        }
    };
}
