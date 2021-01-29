package com.example.travel_buddy.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.travel_buddy.R;
import com.example.travel_buddy.chat.ChatActivity;

public class SignUp extends AppCompatActivity {

    Button callLogin, callChat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        callLogin = findViewById(R.id.have_an_account);

        callLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUp.this, Login.class);
                startActivity(intent);
            }
        });

        callChat = findViewById(R.id.sign_up_go);
        callChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUp.this, ChatActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}