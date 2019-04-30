package com.kiwilss.lxkj.fourassembly.anim;

import android.animation.*;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.*;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kiwilss.lxkj.fourassembly.R;

/**
 * @author : Lss kiwilss
 * @FileName: AnimActivity
 * @e-mail : kiwilss@163.com
 * @time : 2019/4/22
 * @desc : {DESCRIPTION}
 */
public class AnimActivity extends AppCompatActivity {

    private ImageView mIvIcon;
    private LinearLayout mLlImage;
    private Button mBtnUse;
    private ImageView ivanimicon;
    private Button btnanimuse;
    private Button btnaddimage;
    private Button btnremoveimage;
    private LinearLayout llimage;
    private android.widget.TextView tvanimaccelerate;
    private android.widget.TextView tvanimovershoot;
    private android.widget.TextView tvanimaccelerateDecelerate;
    private android.widget.TextView tvanimanticipate;
    private android.widget.TextView tvanimanticipateOvershoot;
    private android.widget.TextView tvanimbounce;
    private android.widget.TextView tvanimcycle;
    private android.widget.TextView tvanimdecelerate;
    private android.widget.TextView tvanimlinear;
    private Button mBtnUse2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim);
        this.tvanimlinear = (TextView) findViewById(R.id.tv_anim_linear);
        this.tvanimdecelerate = (TextView) findViewById(R.id.tv_anim_decelerate);
        this.tvanimcycle = (TextView) findViewById(R.id.tv_anim_cycle);
        this.tvanimbounce = (TextView) findViewById(R.id.tv_anim_bounce);
        this.tvanimanticipateOvershoot = (TextView) findViewById(R.id.tv_anim_anticipateOvershoot);
        this.tvanimanticipate = (TextView) findViewById(R.id.tv_anim_anticipate);
        this.tvanimaccelerateDecelerate = (TextView) findViewById(R.id.tv_anim_accelerateDecelerate);
        this.tvanimovershoot = (TextView) findViewById(R.id.tv_anim_overshoot);
        this.tvanimaccelerate = (TextView) findViewById(R.id.tv_anim_accelerate);
        this.llimage = (LinearLayout) findViewById(R.id.ll_image);
        this.btnremoveimage = (Button) findViewById(R.id.btn_remove_image);
        this.btnaddimage = (Button) findViewById(R.id.btn_add_image);
        this.btnanimuse = (Button) findViewById(R.id.btn_anim_use);
        this.ivanimicon = (ImageView) findViewById(R.id.iv_anim_icon);

        mIvIcon = findViewById(R.id.iv_anim_icon);
        mLlImage = (LinearLayout) findViewById(R.id.ll_image);
        mBtnUse = (Button) findViewById(R.id.btn_anim_use);
        mBtnUse2 = (Button) findViewById(R.id.btn_anim_use2);


        //对 linearlayout 设置过渡动画
        LayoutTransition transition = new LayoutTransition();

        transition.setStagger(LayoutTransition.CHANGE_APPEARING, 30);
        transition.setDuration(LayoutTransition.CHANGE_APPEARING, transition.getDuration(LayoutTransition.CHANGE_APPEARING));
        transition.setStartDelay(LayoutTransition.CHANGE_APPEARING, 0);

        @SuppressLint("ObjectAnimatorBinding") ObjectAnimator appearingAnimator = ObjectAnimator
                .ofPropertyValuesHolder(
                        (Object) null,
                        PropertyValuesHolder.ofFloat("scaleX", 0.0f, 1.0f),
                        PropertyValuesHolder.ofFloat("scaleY", 0.0f, 1.0f),
                        PropertyValuesHolder.ofFloat("alpha", 0, 1.0f));
        transition.setAnimator(LayoutTransition.APPEARING, appearingAnimator);
        transition.setDuration(LayoutTransition.APPEARING, transition.getDuration(LayoutTransition.APPEARING));
        transition.setStartDelay(LayoutTransition.APPEARING, transition.getDuration(LayoutTransition.CHANGE_APPEARING));

        @SuppressLint("ObjectAnimatorBinding") ObjectAnimator disappearingAnimator = ObjectAnimator
                .ofPropertyValuesHolder(
                        (Object) null,
                        PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.0f),
                        PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.0f),
                        PropertyValuesHolder.ofFloat("alpha", 1.0f, 0));
        transition.setAnimator(LayoutTransition.DISAPPEARING, disappearingAnimator);
        transition.setDuration(LayoutTransition.DISAPPEARING, transition.getDuration(LayoutTransition.DISAPPEARING));
        transition.setStartDelay(LayoutTransition.DISAPPEARING, 0);

        transition.setStagger(LayoutTransition.CHANGE_DISAPPEARING, 30);
        transition.setDuration(LayoutTransition.CHANGE_DISAPPEARING, transition.getDuration(LayoutTransition.CHANGE_DISAPPEARING));
        transition.setStartDelay(LayoutTransition.CHANGE_DISAPPEARING, transition.getDuration(LayoutTransition.DISAPPEARING));

        mLlImage.setLayoutTransition(transition);


    }

    public void viewAlphaListener(View view) {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.view_alpha);
        animation.setFillAfter(true);//设置保持动画后的状态
        mIvIcon.startAnimation(animation);
    }

    public void viewScaleListener(View view) {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.view_scale);
        animation.setFillAfter(true);//设置保持动画后的状态
        mIvIcon.startAnimation(animation);
    }

    public void viewTranslateListener(View view) {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.view_translate_left);
        animation.setFillAfter(true);//设置保持动画后的状态
        mIvIcon.startAnimation(animation);
    }

    public void viewRotateListener(View view) {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.view_rotate);
        animation.setFillAfter(true);//设置保持动画后的状态
        mIvIcon.startAnimation(animation);
    }

    public void viewAlphaListener2(View view) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1f, 0f);
        //设置持续时间
        alphaAnimation.setDuration(2000);
        //设置动画后的状态
        alphaAnimation.setFillAfter(true);
        //设置重复次数
        alphaAnimation.setRepeatCount(2);
        //设置重复模式
        alphaAnimation.setRepeatMode(Animation.REVERSE);
        //设置动画监听
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        mIvIcon.startAnimation(alphaAnimation);
    }

    public void viewScaleListener2(View view) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.5f, 1.0f, 0.5f);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(2000);
        mIvIcon.startAnimation(scaleAnimation);
    }

    public void viewTranslateListener2(View view) {
        TranslateAnimation translateAnimation = new TranslateAnimation(Animation.RELATIVE_TO_PARENT, 0f
                , Animation.RELATIVE_TO_PARENT, 1f,
                Animation.RELATIVE_TO_PARENT, 0f,
                Animation.RELATIVE_TO_PARENT, 1f);
        translateAnimation.setDuration(2000);
        translateAnimation.setFillAfter(true);
        mIvIcon.startAnimation(translateAnimation);
    }

    public void viewRotateListene2r(View view) {
        //设置旋转中心在图片的中心
        RotateAnimation rotateAnimation = new RotateAnimation(0, 180
                , Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setDuration(2000);
        rotateAnimation.setFillAfter(true);
        mIvIcon.startAnimation(rotateAnimation);
    }

    public void viewSetListener(View view) {//动画集合
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.view_set);
        //animation.setFillAfter(true);//设置保持动画后的状态
        mIvIcon.startAnimation(animation);
    }

    public void viewSetListener2(View view) {
        AnimationSet animationSet = new AnimationSet(true);
        RotateAnimation rotateAnimation = new RotateAnimation(0, 180
                , Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);

        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.5f, 1.0f, 0.5f);
        animationSet.addAnimation(rotateAnimation);
        animationSet.addAnimation(scaleAnimation);
        animationSet.setDuration(3000);
        animationSet.setFillAfter(true);
        mIvIcon.startAnimation(animationSet);
    }


    public void provityAlphaListener(View view) {
        Animator animator = AnimatorInflater.loadAnimator(this, R.animator.alpha);
        animator.setTarget(mIvIcon);
        animator.start();
    }

    public void provityScaleListener(View view) {
        Animator animator = AnimatorInflater.loadAnimator(this, R.animator.scale);
        animator.setTarget(mIvIcon);
        animator.start();
    }

    public void provityRotateListener(View view) {
        Animator animator = AnimatorInflater.loadAnimator(this, R.animator.rotate);
        animator.setTarget(mIvIcon);
        animator.start();
    }

    public void provityTranslateListener(View view) {
        Animator animator = AnimatorInflater.loadAnimator(this, R.animator.translate);
        animator.setTarget(mIvIcon);
        animator.start();
    }

    public void provityAlphaListener2(View view) {
        ObjectAnimator alpha = ObjectAnimator.ofFloat(mIvIcon, "alpha", 1f, 0.2f, 0.5f, 1f);
        alpha.setDuration(2000);
        alpha.start();
    }

    public void provityTranslateListener2(View view) {
        //x轴方向平移
        ObjectAnimator translationX = ObjectAnimator
                .ofFloat(mIvIcon, "translationX", 0, mIvIcon.getWidth());
        translationX.setDuration(2000);
        translationX.start();
        //y轴方向
        ObjectAnimator translationY = ObjectAnimator
                .ofFloat(mIvIcon, "translationY", 0, mIvIcon.getWidth());
        translationY.setDuration(2000);
        translationY.start();
        //x & y 同时执行
    }

    public void provityRotateListener2(View view) {
        //z轴旋转
//        ObjectAnimator rotation = ObjectAnimator.ofFloat(mIvIcon, "rotation", 0f, 180f);
//        rotation.setDuration(2000);
//        rotation.start();
        //x
//        ObjectAnimator rotationX = ObjectAnimator.ofFloat(mIvIcon, "rotationX", 0, 120);
//        rotationX.setDuration(2000);
//        rotationX.start();
        //y
        ObjectAnimator rotationY = ObjectAnimator.ofFloat(mIvIcon, "rotationY", 0, 60);
        rotationY.setDuration(2000);
        rotationY.start();
    }

    public void provityScaleListener2(View view) {
        //x轴方向
//        ObjectAnimator scaleX = ObjectAnimator.ofFloat(mIvIcon, "scaleX", 1f, 0.5f, 2f);
//        scaleX.setDuration(2000);
//        scaleX.start();
        //y轴方向,缩放点在左上角
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(mIvIcon, "scaleY", 1f, 2f);
        scaleY.setDuration(2000);
        scaleY.start();
    }

    /**
     * 属性动画,组合动画
     *
     * @param view
     */
    public void provitySetListener2(View view) {
        AnimatorSet animatorSet = new AnimatorSet();
        //ObjectAnimator objectAnimator = new ObjectAnimator();
        //ObjectAnimator objectAnimator = new ObjectAnimator();
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(mIvIcon, "scaleX", 1f, 2f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(mIvIcon, "scaleY", 1f, 2f);
        animatorSet.play(scaleX).after(scaleY);
        animatorSet.setDuration(2000);
        animatorSet.start();
    }

    public void valueTest1(View view) {
        // ObjectAnimator.ofInt(mIvIcon,"height",600).setDuration(2000)
        ValueAnimator valueAnimator = ValueAnimator.ofInt(0, 3);
        valueAnimator.setDuration(2500);
        valueAnimator.setStartDelay(500);
        // 设置动画重复播放次数 = 重放次数+1
        // 动画播放次数 = infinite时,动画无限重复
        valueAnimator.setRepeatCount(0);
        valueAnimator.setRepeatMode(ValueAnimator.RESTART);
        // 设置重复播放动画模式
        // ValueAnimator.RESTART(默认):正序重放
        // ValueAnimator.REVERSE:倒序回放
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                //获取改变后的值
                int currentValue = (int) animation.getAnimatedValue();

                Log.e("MMM", "onAnimationUpdate: " + currentValue);

//                // 步骤4：将改变后的值赋给对象的属性值，下面会详细说明
//                View.setproperty（currentValue）；
//
//                // 步骤5：刷新视图，即重新绘制，从而实现动画效果
//                View.requestLayout();

            }
        });


        valueAnimator.start();

    }

    public void addIcon(View view) {
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(R.mipmap.enjoylife);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(200, 200);
        mLlImage.addView(imageView, 0, layoutParams);
    }

    public void removeIcon(View view) {
        int childCount = mLlImage.getChildCount();
        if (childCount > 0) {
            mLlImage.removeViewAt(0);
        }
    }

    public void valueTestXML(View view) {
        Animator animator = AnimatorInflater.loadAnimator(this, R.animator.set_animation);
// 载入XML动画
        animator.setTarget(view);
// 设置动画对象
        animator.start();
// 启动动画
    }

    public void valueTestUse(View view) {
        int width = mBtnUse.getWidth();
        Log.e("MMM", "valueTestUse: " + width);
// 步骤1：设置属性数值的初始值 & 结束值
        ValueAnimator valueAnimator = ValueAnimator.ofInt(width, 500);
// 步骤2：设置动画的播放各种属性
        valueAnimator.setDuration(2000);
        // 设置动画运行时长:1s
// 步骤3：将属性数值手动赋值给对象的属性:此处是将 值 赋给 按钮的宽度
        // 设置更新监听器：即数值每次变化更新都会调用该方法

        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {

                int animatedValue = (int) animation.getAnimatedValue();
                Log.e("MMM", "onAnimationUpdate: " + animatedValue);

                mBtnUse.getLayoutParams().width = animatedValue;
                // 每次值变化时，将值手动赋值给对象的属性
                // 即将每次变化后的值 赋 给按钮的宽度，这样就实现了按钮宽度属性的动态变化

                // 步骤4：刷新视图，即重新绘制，从而实现动画效果
                mBtnUse.requestLayout();

            }
        });


        valueAnimator.start();
        // 启动动画
    }

    /**
     * @param view
     */
    public void valueTestUse2(View view) {
        ViewWrapper viewWrapper = new ViewWrapper(mBtnUse2);
        ObjectAnimator.ofInt(viewWrapper, "width", mBtnUse2.getWidth(),500)
                .setDuration(5000).start();

    }

    public void translateX(View view) {
        mIvIcon.animate().translationX(500)
        .setDuration(5000);
    }

    private static class ViewWrapper{
        private View mTarget;

        public ViewWrapper(View target) {
            mTarget = target;
        }

        public void setWidth(int width){
            mTarget.getLayoutParams().width = width;
            mTarget.requestLayout();
        }

        public int getWidth(){
            return mTarget.getLayoutParams().width;
        }
    }

    /**
     * 插值器效果测试
     *
     * @param view
     */
    public void startChaZhiQiListener(View view) {

        AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator();
        ObjectAnimator translationX = ObjectAnimator.ofFloat(tvanimaccelerate, "translationX", 0, 200);
                translationX.setDuration(2000)
                .setInterpolator(accelerateInterpolator);
                translationX.start();


    }


}
