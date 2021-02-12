package com.example.travel_buddy.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.travel_buddy.R;
import com.example.travel_buddy.chat.ChatActivity;
import com.google.android.material.textfield.TextInputLayout;

public class SignUp extends AppCompatActivity {

    TextView callLogin, callChat;
    TextInputLayout name, user_name, email, phone, password;
    //PrefHelper pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.sign_up);

        name = findViewById(R.id.new_full_name);
        user_name = findViewById(R.id.new_user_name);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone_number);
        password = findViewById(R.id.new_password);

        String new_user_name = name.getEditText().toString();
        String new_user_id = user_name.getEditText().toString();
        String new_user_email = email.getEditText().toString();
        String new_user_phone = phone.getEditText().toString();
        String new_user_password = password.getEditText().toString();


        callLogin = findViewById(R.id.have_an_account);

        callLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUp.this, Login.class);
                startActivity(intent);
                finish();
            }
        });

        callChat = findViewById(R.id.sign_up_go);
        callChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*if(new_user_id != null && new_user_password != null) {
                    pref.setUserId(new_user_id);
                    pref.setPassword(new_user_password);
                    pref.setEmail(new_user_email);
                    pref.setName(new_user_name);
                    pref.setPhone(new_user_phone);

                    Toast.makeText(SignUp.this, "New User Created", Toast.LENGTH_SHORT).show();*/

                    Intent intent = new Intent(SignUp.this, ChatActivity.class);
                    startActivity(intent);
                    finish();
                }
            //}
        });
    }
}