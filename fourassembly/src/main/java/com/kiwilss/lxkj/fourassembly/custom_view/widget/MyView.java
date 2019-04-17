package com.kiwilss.lxkj.fourassembly.custom_view.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author : Lss kiwilss
 * @FileName: MyView
 * @e-mail : kiwilss@163.com
 * @time : 2019/4/16
 * @desc : {DESCRIPTION}
 */
public class MyView extends View {
    public MyView(Context context) {
        this(context,null);
    }

    public MyView(Context context,  @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyView(Context context,  @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);




    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);




    }

    private int getMySize(int defaultSize, int measureSpec) {
        int mySize = defaultSize;
        int mode = MeasureSpec.getMode(measureSpec);
        int size = MeasureSpec.getSize(measureSpec);
        switch (mode) {
            //任意值,没有指定大小
            case MeasureSpec.UNSPECIFIED:
                mySize = defaultSize;
                break;
                //最大值
                case MeasureSpec.AT_MOST:
                    mySize = size;
                    break;
                    //确定值
                    case MeasureSpec.EXACTLY:
                        mySize = size;
                        break;
        }
        return mySize;
    }

}
