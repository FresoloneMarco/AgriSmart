package com.example.agrismart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class Login extends AppCompatActivity {

    public Button login_button;

    login_button = findViewById(R.id.login_button);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }



        login_button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            login_button.setBackgroundResource(R.drawable.loginbuttonclicked);
            Intent intent = new Intent(getApplicationContext(), HomeAdmin.class);
            startActivity(intent);
            finish();
        }
    });
}
