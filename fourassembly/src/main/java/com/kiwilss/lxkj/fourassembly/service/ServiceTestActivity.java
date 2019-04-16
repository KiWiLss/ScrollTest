package com.kiwilss.lxkj.fourassembly.service;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
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

    public void bindListener(View view) {
    }

    public void startStopListener(View view) {
        Intent intent = new Intent(this, StartService.class);
        intent.putExtra("key","stop");
        stopService(intent);
    }
}
