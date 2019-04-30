package com.kiwilss.lxkj.fourassembly.anim;

import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.*;
import android.widget.ImageView;
import com.kiwilss.lxkj.fourassembly.R;
import com.kiwilss.lxkj.fourassembly.anim.view.Sample08ObjectAnimatorView;
import com.kiwilss.lxkj.fourassembly.utils.Utils;

/**
 * @author : Lss kiwilss
 * @FileName: AnimTestActivity
 * @e-mail : kiwilss@163.com
 * @time : 2019/4/28
 * @desc : {DESCRIPTION}
 */
public class AnimTestActivity extends AppCompatActivity {

    private ImageView mIvImg;
    private Sample08ObjectAnimatorView mSoal;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim_test);

        mIvImg = (ImageView) findViewById(R.id.iv_anim_test_icon);
        mSoal = (Sample08ObjectAnimatorView) findViewById(R.id.soal);
    }

    public void addShowL(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mIvImg.setOutlineProvider(new MusicOutlineProvider());
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mIvImg.animate().translationZ(Utils.dpToPixel(15));
        }
    }

    public void removeShowL(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mIvImg.animate().translationZ(0);
        }
    }

    public void moveListener(View view) {
        mIvImg.animate().translationX(Utils.dpToPixel(100));
    }

    public void moveSituListener(View view) {
        mIvImg.animate().translationX(0);
    }

    public void rotateListener(View view) {
        mIvImg.animate().rotation(180);
    }

    public void scaleListener(View view) {
        //改动一个时间,其他的时间都会是 5000ms
        mIvImg.animate().scaleX(1.5f).setDuration(5000);
    }

    public void alphaListener(View view) {
        mIvImg.animate().alpha(0.5f);
    }

    public void setListener(View view) {
        mIvImg.animate().translationX(Utils.dpToPixel(100))
                .rotation(180)
                .alpha(0.5f);
    }


    public void linearListener(View view) {
        mIvImg.animate().translationX(Utils.dpToPixel(100))
                .setInterpolator(new LinearInterpolator());
    }

    public void accelerateDecelerateListener(View view) {
        mIvImg.animate().translationX(Utils.dpToPixel(100))
                .setInterpolator(new AccelerateDecelerateInterpolator());
    }

    public void accelerateListener(View view) {
        mIvImg.animate().translationX(Utils.dpToPixel(100))
                .setInterpolator(new AccelerateInterpolator());
    }

    public void decelerateListener(View view) {
        mIvImg.animate().translationX(Utils.dpToPixel(100))
                .setInterpolator(new DecelerateInterpolator());
    }

    public void AnticipateListener(View view) {
        mIvImg.animate().translationX(Utils.dpToPixel(100))
                .setInterpolator(new AnticipateInterpolator());
    }

    public void overshootListener(View view) {
        mIvImg.animate().translationX(Utils.dpToPixel(100))
                .setInterpolator(new OvershootInterpolator());
    }

    public void AnticipateOvershootListener(View view) {
        mIvImg.animate().translationX(Utils.dpToPixel(100))
                .setInterpolator(new AnticipateOvershootInterpolator());
    }

    public void customListener(View view) {
        Path interpolatorPath = new Path();
        // 先以「动画完成度 : 时间完成度 = 1 : 1」的速度匀速运行 25%
        interpolatorPath.lineTo(0.25f, 0.25f);
// 然后瞬间跳跃到 150% 的动画完成度
        interpolatorPath.moveTo(0.25f, 1.5f);
// 再匀速倒车，返回到目标点
        interpolatorPath.lineTo(1, 1);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mIvImg.animate().translationX(Utils.dpToPixel(100))
                    .setInterpolator(new PathInterpolator(interpolatorPath));
        }
    }


    public void fastListener(View view) {
        mIvImg.animate().translationX(Utils.dpToPixel(100))
                .setInterpolator(new FastOutLinearInInterpolator());
    }

    public void progressListener(View view) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(mSoal, "progress", 0, 100);
        animator.setDuration(1000);
        animator.setInterpolator(new FastOutSlowInInterpolator());
        animator.start();
    }
}
