package com.kiwilss.jetpacktest.paging.jpaging;

import android.annotation.SuppressLint;
import android.arch.paging.PagedListAdapter;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.kiwilss.jetpacktest.R;

/**
 * @author : Lss kiwilss
 * @FileName: MyAdapter
 * @e-mail : kiwilss@163.com
 * @time : 2019/3/11
 * @desc : {DESCRIPTION}
 */
public class MyAdapter extends PagedListAdapter<DataBean, MyAdapter.MyViewHolder> {


    protected MyAdapter(@NonNull DiffUtil.ItemCallback<DataBean> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.student_item,
                viewGroup,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        DataBean data = getItem(i);
        myViewHolder.text1.setText("positon = "+ i +" content = "+data.content);
    }






     class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView text1;
        //public TextView text2;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            text1 = itemView.findViewById(R.id.name);
            text1.setTextColor(Color.RED);

//        text2 = itemView.findViewById(R.id.text2);
//        text2.setTextColor(Color.BLUE);

        }
    }

}
