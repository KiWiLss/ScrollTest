package com.kiwilss.lxkj.fourassembly.custom_view.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.kiwilss.lxkj.fourassembly.R;
import com.kiwilss.lxkj.fourassembly.utils.DensityUtils;

import static com.kiwilss.lxkj.fourassembly.service.StartService.TAG;

/**
 * @author : Lss kiwilss
 * @FileName: ClockView
 * @e-mail : kiwilss@163.com
 * @time : 2019/4/22
 * @desc : {DESCRIPTION}
 */
public class ClockView extends View {

    private final int mLightColor;

    private int mBackgroundColor;
    private int mDarkColor;
    private float mTextSize;
    private Paint mTextPaint;
    //小圆圈画笔
    private Paint mCirclePaint;
    //小圆圈线条宽度
    private final float mCircleStrokeWidth = 0;

    public ClockView(Context context) {
        this(context,null);
    }

    public ClockView(Context context,  @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ClockView(Context context,  @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.ClockView);
        mBackgroundColor = ta.getColor(R.styleable.ClockView_clock_backgroundColor, Color.parseColor("#237EAD"));
        mDarkColor = ta.getColor(R.styleable.ClockView_clock_darkColor, Color.parseColor("#80ffffff"));
        mLightColor = ta.getColor(R.styleable.ClockView_clock_lightColor, Color.parseColor("#ffffff"));
        mTextSize = ta.getDimension(R.styleable.ClockView_clock_textSize, DensityUtils.dp2px(context, 14));

        Log.e(TAG, "ClockView:  textsize = "+ mTextSize );
        mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setStyle(Paint.Style.FILL);
        mTextPaint.setColor(mDarkColor);
        //设置文字居中
        mTextPaint.setTextAlign(Paint.Align.CENTER);
        mTextPaint.setTextSize(mTextSize);


        mCirclePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mCirclePaint.setStyle(Paint.Style.STROKE);
        mCirclePaint.setColor(mDarkColor);
        mCirclePaint.setStrokeWidth(mCircleStrokeWidth);


    }
}
