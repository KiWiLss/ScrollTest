package com.kiwilss.jetpacktest.paging.jpaging;

import android.arch.paging.PositionalDataSource;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Lss kiwilss
 * @FileName: MyDataSource
 * @e-mail : kiwilss@163.com
 * @time : 2019/3/11
 * @desc : {DESCRIPTION}
 */
public class MyDataSource extends PositionalDataSource<DataBean> {
    @Override
    public void loadInitial(@NonNull LoadInitialParams params, @NonNull LoadInitialCallback<DataBean> callback) {
        callback.onResult(loadData(0, 10),0,10);
    }

    @Override
    public void loadRange(@NonNull LoadRangeParams params, @NonNull LoadRangeCallback<DataBean> callback) {
        callback.onResult(loadData(params.startPosition, 10));
    }

    /**
     * 假设这里需要做一些后台线程的数据加载任务。
     *
     * @param startPosition
     * @param count
     * @return
     */
    private List<DataBean> loadData(int startPosition, int count) {
        List<DataBean> list = new ArrayList();
        for (int i = 0; i < count; i++) {
            DataBean data = new DataBean();
            data.id = startPosition + i;
            data.content = "测试的内容=" + data.id;
            list.add(data);
        }
        return list;
    }

}
