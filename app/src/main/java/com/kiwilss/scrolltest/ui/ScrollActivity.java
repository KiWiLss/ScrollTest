package com.kiwilss.scrolltest.ui;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kiwilss.scrolltest.R;
import com.lxj.androidktx.okhttp.OkWrapper;
import com.tencent.mmkv.MMKV;
import okhttp3.Interceptor;
import okhttp3.Response;

import java.io.IOException;

/**
 * @author : Lss kiwilss
 * @FileName: ScrollActivity
 * @e-mail : kiwilss@163.com
 * @time : 2019/2/20
 * @desc : {DESCRIPTION}
 */
public class ScrollActivity extends AppCompatActivity {
    public static final String TAG = "MMM";
    private TextView tvscrollone;
    private TextView tvscrolltwo;
    private TextView tvscrollthree;
    private TextView tvscrollfour;
    private LinearLayout llscrollouter;
    private NestedScrollView svscrollouter;
    private Button btnscrollbottom;
    private TextView tvscrollfive;
    private Button btnscrolltop;
    private Button btnscrollany;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll);
        this.btnscrollany = (Button) findViewById(R.id.btn_scroll_any);
        this.btnscrolltop = (Button) findViewById(R.id.btn_scroll_top);
        this.tvscrollfive = (TextView) findViewById(R.id.tv_scroll_five);
        this.btnscrollbottom = (Button) findViewById(R.id.btn_scroll_bottom);
        this.svscrollouter =  findViewById(R.id.sv_scroll_outer);
        this.llscrollouter = (LinearLayout) findViewById(R.id.ll_scroll_outer);
        this.tvscrollfour = (TextView) findViewById(R.id.tv_scroll_four);
        this.tvscrollthree = (TextView) findViewById(R.id.tv_scroll_three);
        this.tvscrolltwo = (TextView) findViewById(R.id.tv_scroll_two);
        this.tvscrollone = (TextView) findViewById(R.id.tv_scroll_one);


        //scrollview 滚动监听
        svscrollouter.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {

                //Log.e(TAG, "onScrollChange: " + scrollX +"---" + scrollY + "----" +oldScrollX + "---" + oldScrollY );
                //监听滚动状态

                if (scrollY > oldScrollY) {//向下滚动
                    Log.i(TAG, "Scroll DOWN");
                }
                if (scrollY < oldScrollY) {//向上滚动
                    Log.i(TAG, "Scroll UP");
                }

                if (scrollY == 0) {// 滚动到顶
                    Log.i(TAG, "TOP SCROLL");
                }
                // 滚动到底
                if (scrollY == (v.getChildAt(0).getMeasuredHeight() - v.getMeasuredHeight())) {
                    Log.i(TAG, "BOTTOM SCROLL");
                }

                //判断某个控件是否可见
                Rect scrollBounds = new Rect();
                svscrollouter.getHitRect(scrollBounds);
                if (tvscrollthree.getLocalVisibleRect(scrollBounds)) {//可见
                    Log.e(TAG, "onScrollChange:  第3个可见" );
                }else {//完全不可见
                    Log.e(TAG, "onScrollChange:  第3个不可见" );
                }



//                Log.e(TAG, "onScrollChange: ------------" + scrollY +"------"+ tvscrollthree.getTop() );
//                //判断某个控件是否滚到顶部
//                if (scrollY == tvscrollthree.getTop()){
//                    Log.i(TAG, "onScrollChange: ------top-------" );
//                }
//
//                Log.e(TAG, "onScrollChange: bottmo" + scrollY +"-----"+ (tvscrollthree.getTop() + tvscrollthree.getHeight()) );


            }
        });

        //控制滚动到底
        btnscrollbottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                svscrollouter.fullScroll(NestedScrollView.FOCUS_DOWN);
                //svscrollouter.fullScroll(ScrollView.FOCUS_DOWN);

            }
        });

        //滚动顶
        btnscrolltop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                svscrollouter.fullScroll(NestedScrollView.FOCUS_UP);

            }
        });

        //滚动到任意位置
        btnscrollany.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //svscrollouter.scrollTo(0,tvscrollfour.getTop());
                svscrollouter.scrollTo(0,tvscrollthree.getBottom());

            }
        });

        MMKV.defaultMMKV().encode("string","string类型");

        MMKV.defaultMMKV().encode("boolean",true);

        
        //测试
         findViewById(R.id.btn_scroll_test).setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {

                 Log.e(TAG, "onClick: "+ MMKV.defaultMMKV().decodeString("string") );

                 Log.e(TAG, "onClick: "+ MMKV.defaultMMKV().getBoolean("boolean",false) );

             }
         });


        OkWrapper.INSTANCE.interceptors(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                return null;
            }
        });




    }
}
