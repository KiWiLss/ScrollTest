package com.kiwilss.lxkj.fourassembly.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import com.kiwilss.lxkj.fourassembly.R;

/**
 * @author : Lss kiwilss
 * @FileName: TwoActivity
 * @e-mail : kiwilss@163.com
 * @time : 2019/4/2
 * @desc : {DESCRIPTION}
 */
public class TwoActivity extends AppCompatActivity {

    public static final String TAG = "MMM";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        Log.e(TAG, "two ---- onCreate: ");

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.e(TAG, "two-----onConfigurationChanged: " );
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, "two ----onRestart: " );
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "two ----onStart: " );
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "two ----onResume: " );
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "two ----onPause: " );
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "two ----onStop: " );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "two ----onDestroy: " );
    }

    public void goToThree(View view) {
        startActivity(new Intent(this,ThreeActivity.class));
    }
}
