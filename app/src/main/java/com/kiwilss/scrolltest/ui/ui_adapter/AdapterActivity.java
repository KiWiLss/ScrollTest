package com.kiwilss.scrolltest.ui.ui_adapter;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import com.kiwilss.scrolltest.R;

/**
 * @author : Lss kiwilss
 * @FileName: AdapterActivity
 * @e-mail : kiwilss@163.com
 * @time : 2019/3/28
 * @desc : {DESCRIPTION}
 */
public class AdapterActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 全屏显示
//        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN |
//                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);

        setContentView(R.layout.activity_adapter);



        //透明状态栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }


    }
}
