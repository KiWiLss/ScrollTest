package com.kiwilss.jetpacktest.paging.jpaging;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PagedList;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import com.kiwilss.jetpacktest.R;

/**
 * @author : Lss kiwilss
 * @FileName: PagingActivity
 * @e-mail : kiwilss@163.com
 * @time : 2019/3/11
 * @desc : {DESCRIPTION}
 */
public class PagingActivity extends AppCompatActivity {
    private RecyclerView rvpaginglist;

    public DiffUtil.ItemCallback<DataBean> mDiffCallback = new DiffUtil.ItemCallback<DataBean>() {
        @Override
        public boolean areItemsTheSame(@NonNull DataBean oldItem, @NonNull DataBean newItem) {
            Log.d("MMM","areItemsTheSame");
            return oldItem.id == newItem.id;
        }

        @Override
        public boolean areContentsTheSame(@NonNull DataBean oldItem,@NonNull DataBean newItem) {
            Log.d("MMM","areContentsTheSame222");
            return (oldItem == newItem);
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paging);
        this.rvpaginglist = (RecyclerView) findViewById(R.id.rv_paging_list);

         final MyAdapter mAdapter = new MyAdapter(mDiffCallback);

        PagedList.Config config = new PagedList.Config.Builder()
                .setPageSize(10)
                .setEnablePlaceholders(false)
                .setInitialLoadSizeHint(10)
                .build();

        /**
         * LiveData<PagedList<DataBean>> 用LivePagedListBuilder生成
         * LivePagedListBuilder 用 DataSource.Factory<Integer,DataBean> 和PagedList.Config.Builder 生成
         * DataSource.Factory<Integer,DataBean> 用 PositionalDataSource<DataBean>
         */
        LiveData<PagedList<DataBean>> liveData = new LivePagedListBuilder(new MyDataSourceFactory(), config)
//                .setBoundaryCallback(null)
//                .setFetchExecutor(null)
                .build();
        liveData.observe(this,new Observer<PagedList<DataBean>>() {
            @Override
            public void onChanged(@Nullable PagedList<DataBean> dataBeans) {
                mAdapter.submitList(dataBeans);
            }
        });

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        rvpaginglist.setLayoutManager(mLayoutManager);
        rvpaginglist.setAdapter(mAdapter);




    }
}
