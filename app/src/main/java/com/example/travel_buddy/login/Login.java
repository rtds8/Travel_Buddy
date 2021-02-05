package com.example.travel_buddy.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.travel_buddy.R;
import com.google.android.material.textfield.TextInputLayout;

public class Login extends AppCompatActivity {

    TextView callSignUp, login;
    TextInputLayout user_name, user_password;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.login_screen);

        user_name = findViewById(R.id.user_name);
        user_password = findViewById(R.id.password);

        String user = user_name.getEditText().toString();
        String pass = user_password.getEditText().toString();

        String email = "test@email.com"; // get from the view
        String password = "pass"; // get from the view
        String loginApiUrl = String.format("%s/login", Constants.BASE_API);
        String loginBody = String.format("{\"email\":\"%s\", \"password\":\"%s\"}", email, password);

        NetworkHelper loginApi = new NetworkHelper(loginApiUrl, loginBody, new NetworkResponseHandler() {
            @Override
            public void onSuccess(String response) {

            }

            @Override
            public void onError(String error) {

            }
        });

        login = findViewById(R.id.login_go);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        callSignUp = findViewById(R.id.sign_up);

        callSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this,SignUp.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
