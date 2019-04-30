package com.kiwilss.lxkj.fourassembly.custom_view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.kiwilss.lxkj.fourassembly.utils.Utils;

import static com.kiwilss.lxkj.fourassembly.service.StartService.TAG;

/**
 * @author : Lss kiwilss
 * @FileName: MyArcView
 * @e-mail : kiwilss@163.com
 * @time : 2019-04-28
 * @desc : {DESCRIPTION}
 */
public class MyArcView extends View {

    private Paint paint;

    public MyArcView(Context context) {
        this(context, null);
    }

    public MyArcView(Context context,  @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyArcView(Context context,  @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(Utils.dpToPixel(5));

        RectF arcRectF = new RectF(10,10,100,100);
        float x = (getWidth() - getHeight() / 2) / 2;
        float y = getHeight() / 4;
        RectF oval = new RectF( x, y,
                getWidth() - x, getHeight() - y);
        Log.e(TAG, "onDraw: " + x +"--" +y + "--" + (getWidth() - x) + "---" + (getHeight() - y));
        //构造一个指定了4个参数的矩形 ，这些参数都是坐标，即矩形的宽width = right - left ，高height = bottom - top；

        canvas.drawArc(oval,270,360,false,paint);
//        startAngle-弧线开始绘制时的角度
//        sweepAngle-弧线顺时针旋转的角度
//        useCenter-如果为true，绘制的起点和终点会和圆心相连
//        paint-绘制弧线的画笔
        //canvas.drawCircle(getWidth()/2,getHeight()/2,30,paint);
    }
}
