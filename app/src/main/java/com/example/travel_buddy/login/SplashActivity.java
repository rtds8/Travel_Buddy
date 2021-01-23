package com.example.travel_buddy.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.travel_buddy.R;
import com.example.travel_buddy.chat.ChatActivity;


public class SplashActivity extends Activity {

    private static int splash_seconds = 4000;
    TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash_screen);

        textView = findViewById(R.id.splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, ChatActivity.class);
                startActivity(intent);
                finish();
            }
        }, splash_seconds);
    }
}
