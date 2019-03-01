package com.kiwilss.scrolltest.uij;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.kiwilss.scrolltest.R;
import com.kiwilss.scrolltest.databinding.ActivityMvTwoBinding;
import com.kiwilss.scrolltest.model.modelj.UserT;

/**
 * @author : Lss kiwilss
 * @FileName: MVTwoActivity
 * @e-mail : kiwilss@163.com
 * @time : 2019/2/25
 * @desc : {DESCRIPTION}
 */
public class MVTwoActivity extends AppCompatActivity {

    private ActivityMvTwoBinding mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_mv_two);


        new Thread(
                new Runnable() {
                    @Override
                    public void run() {

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                            }
                        });
                    }
                }
        ).start();

    }

    public void onClick(View view) {
        UserT user = new UserT("张君宝", "张三丰", true, 30);
        mBinding.setUser(user);
    }

}
