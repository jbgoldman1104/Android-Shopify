package com.example.nextapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    final static int SPLASH_SCREEN = 3000;

    Animation top_anim , bottom_anim;
    TextView tvNAME ,tvDESCRIPTION;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        top_anim = AnimationUtils.loadAnimation(this, R.anim.top_anim);
        bottom_anim = AnimationUtils.loadAnimation(this , R.anim.bottom_anim);
        tvDESCRIPTION = findViewById(R.id.tvDESCRIPTION);
        tvNAME = findViewById(R.id.tvNAME);

        tvNAME.setAnimation(top_anim);
        tvDESCRIPTION.setAnimation(bottom_anim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent (MainActivity.this , com.example.nextapp.login.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);
    }
}