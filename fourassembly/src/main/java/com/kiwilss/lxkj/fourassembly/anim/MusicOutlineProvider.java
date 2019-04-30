package com.kiwilss.lxkj.fourassembly.anim;

import android.graphics.Outline;
import android.graphics.Path;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.ViewOutlineProvider;

import static com.kiwilss.lxkj.fourassembly.utils.Utils.dpToPixel;

/**
     * 为音乐图标设置三角形的 Outline。
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    class MusicOutlineProvider extends ViewOutlineProvider {
        Path path = new Path();

        {
            path.moveTo(0, dpToPixel(10));
            path.lineTo(dpToPixel(7), dpToPixel(2));
            path.lineTo(dpToPixel(116), dpToPixel(58));
            path.lineTo(dpToPixel(116), dpToPixel(70));
            path.lineTo(dpToPixel(7), dpToPixel(128));
            path.lineTo(0, dpToPixel(120));
            path.close();
        }

        @Override
        public void getOutline(View view, Outline outline) {
            outline.setConvexPath(path);
        }
    }