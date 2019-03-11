package com.kiwilss.jetpacktest.paging.jpaging;

import android.arch.paging.DataSource;

/**
 * @author : Lss kiwilss
 * @FileName: MyDataSourceFactory
 * @e-mail : kiwilss@163.com
 * @time : 2019/3/11
 * @desc : {DESCRIPTION}
 */
public class MyDataSourceFactory extends DataSource.Factory<Integer,DataBean> {
    @Override
    public DataSource<Integer, DataBean> create() {
        return new MyDataSource();
    }
}
