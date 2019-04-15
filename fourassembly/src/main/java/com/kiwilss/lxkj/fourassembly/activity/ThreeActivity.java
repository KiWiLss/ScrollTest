package com.kiwilss.lxkj.fourassembly.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import com.kiwilss.lxkj.fourassembly.R;

/**
 * @author : Lss kiwilss
 * @FileName: ThreeActivity
 * @e-mail : kiwilss@163.com
 * @time : 2019/4/15
 * @desc : {DESCRIPTION}
 */
public class ThreeActivity extends AppCompatActivity {

    public static final String TAG = "MMM";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);

        Log.e(TAG, "three----onCreate: " );

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, "three----onRestart: " );
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "three----onStart: " );
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "three----onResume: " );
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.e(TAG, "three----onNewIntent: " );
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "three----onPause: " );
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "three----onStop: " );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "three----onDestroy: " );
    }

    public void goToTwo(View view) {
        startActivity(new Intent(this,TwoActivity.class));
    }
}
