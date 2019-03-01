package com.kiwilss.scrolltest.uij;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.kiwilss.scrolltest.R;
import com.kiwilss.scrolltest.databinding.ActivityMvTestOneBinding;
import com.kiwilss.scrolltest.model.modelj.User;

/**
 * @author : Lss kiwilss
 * @FileName: MVTestOneActivity
 * @e-mail : kiwilss@163.com
 * @time : 2019/2/22
 * @desc : {DESCRIPTION}
 */
public class MVTestOneActivity extends AppCompatActivity {

    private ActivityMvTestOneBinding mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_mv_test_one);

        User user = new User("mack", "jack");
        mBinding.setUser(user);


        user.setFirstName("mack change");

    }
}
