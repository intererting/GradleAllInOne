package com.yuliyang.gradleallinone.rotate3d;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

import com.yuliyang.gradleallinone.R;

public class Rotate3dActivity extends AppCompatActivity {
    float centerX;
    float centerY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3d);
        final View tdView = findViewById(R.id.tdView);
        tdView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                tdView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                centerX = tdView.getMeasuredWidth() / 2.0f;
                centerY = tdView.getMeasuredHeight() / 2.0f;

                //创建动画对象
                Rotate3DAnimation r3a = new Rotate3DAnimation(0, 3600, 500, centerX, centerY, false);
                r3a.setDuration(20000);
                r3a.setFillAfter(true);
                //设置加速插补器
                r3a.setInterpolator(new LinearInterpolator());
                tdView.startAnimation(r3a);

                //动画监听
                r3a.setAnimationListener(new Animation.AnimationListener() {
                    //动画开始执行时的动作
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    //动画重复执行
                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }

                    //动画结束时的动作
                    @Override
                    public void onAnimationEnd(Animation animation) {
                    }
                });
            }
        });
    }
}
