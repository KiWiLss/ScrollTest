package com.kiwilss.lxkj.fourassembly.lauch;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import com.kiwilss.lxkj.fourassembly.R;
import com.kiwilss.lxkj.fourassembly.base.BaseActivity;

/**
 * @author : Lss kiwilss
 * @FileName: OtherSingleInstanceActivity
 * @e-mail : kiwilss@163.com
 * @time : 2019/4/19
 * @desc : {DESCRIPTION}
 */
public class OtherSingleInstanceActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_singleinstance);
    }

    public void goToInstance(View view) {
        startActivity(new Intent(this,SingleInstanceActivity.class));
    }
}
