package com.kiwilss.scrolltest;

import android.app.Application;
import com.tencent.mmkv.MMKV;

/**
 * @author : Lss kiwilss
 * @FileName: MyApp
 * @e-mail : kiwilss@163.com
 * @time : 2019/2/21
 * @desc : {DESCRIPTION}
 */
public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        //mmkv初始化
        MMKV.initialize(this);


    }
}
