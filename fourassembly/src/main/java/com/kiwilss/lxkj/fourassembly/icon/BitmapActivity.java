package com.kiwilss.lxkj.fourassembly.icon;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import com.kiwilss.lxkj.fourassembly.R;

/**
 * @author : Lss kiwilss
 * @FileName: BitmapActivity
 * @e-mail : kiwilss@163.com
 * @time : 2019-04-30
 * @desc : {DESCRIPTION}
 */
public class BitmapActivity extends AppCompatActivity {
    private static final String TAG = "MMM";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitmap);

        //获取屏幕的 dip
        float xdpi = getResources().getDisplayMetrics().xdpi;
        float ydpi = getResources().getDisplayMetrics().ydpi;
        Log.e(TAG, "onCreate: " + xdpi + "---" + ydpi);






    }
}
