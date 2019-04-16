package com.kiwilss.lxkj.fourassembly.lauch;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import com.kiwilss.lxkj.fourassembly.R;
import com.kiwilss.lxkj.fourassembly.base.BaseActivity;

/**
 * @author : Lss kiwilss
 * @FileName: OtherSingleTaskActivity
 * @e-mail : kiwilss@163.com
 * @time : 2019/4/15
 * @desc : {DESCRIPTION}
 */
public class OtherSingleTaskActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_single_task);
    }

    public void intoSingleTask(View view) {
        Intent intent = new Intent(this, SingleTaskActivity.class);
        startActivity(intent);
    }
}