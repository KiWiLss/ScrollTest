package com.kiwilss.lxkj.fourassembly.lauch;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import com.kiwilss.lxkj.fourassembly.R;
import com.kiwilss.lxkj.fourassembly.base.BaseActivity;

/**
 * @author : Lss kiwilss
 * @FileName: SingleTopActivity
 * @e-mail : kiwilss@163.com
 * @time : 2019/4/15
 * @desc : {DESCRIPTION}
 */
public class SingleTopActivity extends BaseActivity {

    public static final String TAG = "MMM";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_top);


        Log.e(TAG, "singleTop---onCreate: " );
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, "singleTop---onRestart: " );
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "singleTop---onStart: " );
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "singleTop---onResume: " );
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "singleTop---onPause: " );
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "singleTop---onStop: " );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "singleTop---onDestroy: " );
    }

    public void intoSingleTop(View view) {
        Intent intent = new Intent(this, SingleTopActivity.class);
        startActivity(intent);
    }

    public void intoOtherTop(View view) {
        Intent intent = new Intent(this, OtherTopActivity.class);
        startActivity(intent);
    }
}
