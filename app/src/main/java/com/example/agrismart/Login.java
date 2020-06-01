package com.example.agrismart;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    private Button login_button;
    private EditText user;
    private EditText password;
    private TextView r_alert1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login_button = findViewById(R.id.login_button);
        user = findViewById(R.id.edit_text1);
        password = findViewById(R.id.edit_text2);
        r_alert1 = findViewById(R.id.required_alert1);
        final String utente = user.getText().toString();
        System.out.println(utente);


        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user = findViewById(R.id.edit_text1);
                String utente = user.getText().toString();

                if (user.getText().toString().equals("") || password.getText().toString().equals("")) {

                    r_alert1.setVisibility(View.VISIBLE);

                    if (user.getText().toString().equals("") && password.getText().toString().equals("")) {
                        user.setBackgroundResource(R.drawable.editext1_required);
                        password.setBackgroundResource(R.drawable.editext1_required);
                    }
                    if (user.getText().toString().equals("")) {
                        user.setBackgroundResource(R.drawable.editext1_required);

                    }

                    if (password.getText().toString().equals("")) {
                        password.setBackgroundResource(R.drawable.editext1_required);

                    }

                } else {
                    r_alert1.setVisibility(View.GONE);

                    if (utente.equalsIgnoreCase("admin")) {
                    /*Intent intent = new Intent(getApplicationContext(), HomeAdmin.class);
                    startActivity(intent);
                    finish();*/
                    } else {
                        Intent intent = new Intent(getApplicationContext(), HomeUser.class);
                        startActivity(intent);
                        finish();
                    }
                }
            }
        });
    }


}
