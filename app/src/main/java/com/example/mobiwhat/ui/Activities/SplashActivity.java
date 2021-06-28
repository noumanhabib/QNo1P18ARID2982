package com.example.mobiwhat.ui.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.example.mobiwhat.R;

public class SplashActivity extends AppCompatActivity {
    private static final int SPLASH_TIME_OUT = 3000;
    Animation topAnimation, bottomAnimation, middleAnimation;
    TextView appName, slogan;
    View one, two, three, four, five, six;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        topAnimation = AnimationUtils.loadAnimation(this, R.anim.splash_top_animation);
        middleAnimation = AnimationUtils.loadAnimation(this, R.anim.spash_middle_animation);
        bottomAnimation = AnimationUtils.loadAnimation(this, R.anim.splash_bottom_animation);

        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);

        appName = findViewById(R.id.app_name);
        slogan = findViewById(R.id.slogan);

        one.setAnimation(topAnimation);
        two.setAnimation(topAnimation);
        three.setAnimation(topAnimation);
        four.setAnimation(topAnimation);
        five.setAnimation(topAnimation);
        six.setAnimation(topAnimation);

        appName.setAnimation(middleAnimation);
        slogan.setAnimation(bottomAnimation);
    }

    @Override
    protected void onStart() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, Master_page.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_TIME_OUT);
        super.onStart();
    }
}