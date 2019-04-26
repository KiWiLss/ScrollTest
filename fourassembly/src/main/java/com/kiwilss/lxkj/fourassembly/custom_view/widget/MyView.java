package com.kiwilss.lxkj.fourassembly.custom_view.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.kiwilss.lxkj.fourassembly.R;

/**
 * @author : Lss kiwilss
 * @FileName: MyView
 * @e-mail : kiwilss@163.com
 * @time : 2019/4/16
 * @desc : {DESCRIPTION}
 */
public class MyView extends View {

    private int mDefaultSize;

    public MyView(Context context) {
        this(context,null);
    }

    public MyView(Context context,  @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyView(Context context,  @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        //获取自定义属性
        TypedArray typedArray = context.obtainStyledAttributes(defStyleAttr, R.styleable.MyView);

        mDefaultSize = typedArray.getDimensionPixelSize(R.styleable.MyView_default_size, 100);

        typedArray.recycle();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        //调用父View的onDraw函数，因为View这个类帮我们实现了一些
        // 基本的而绘制功能，比如绘制背景颜色、背景图片等
        super.onDraw(canvas);

        int r = getMeasuredWidth() / 2;
        //圆心的横坐标为当前的View的左边起始位置+半径
        int centerX =  r ;
        //圆心的纵坐标为当前的View的顶部起始位置+半径
        int centerY = r ;

        @SuppressLint("DrawAllocation") Paint paint = new Paint();
        paint.setColor(Color.GREEN);
        canvas.drawCircle(centerX,centerY,r,paint);

        paint.setColor(Color.BLUE);
        paint.setTextSize(32);
        canvas.drawText("你好",0,r,paint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //获取宽高
        int width = getMySize(mDefaultSize, widthMeasureSpec);
        int height = getMySize(mDefaultSize, heightMeasureSpec);
        if (width < height){
            height = width;
        }else {
            width = height;
        }
        setMeasuredDimension(width,height);
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
