package com.example.agrismart;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Login extends AppCompatActivity {

    private Button login_button;
    private EditText user;
    private EditText password;
    private TextView r_alert1;
    private Gson gson;
    private SharedPreferences.Editor editor;
    private ArrayList<Utente> utenti;
    private Utente loggedUser;
    private Boolean loggable;


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

        /* RETRIEVE DATI DA SHARED PREFERENCES */
        utenti = new ArrayList<>();
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        gson = new Gson();
        editor = sharedPreferences.edit();
        String utentiJson = sharedPreferences.getString("utenti", "");
        Type typeUtenti = new TypeToken<ArrayList<Utente>>() {
        }.getType();
        utenti = gson.fromJson(utentiJson, typeUtenti);
        /* FINE RETRIEVE */


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
                    loggable = false;
                    for (Utente u : utenti) {
                        if (user.getText().toString().equals(u.getEmail()) && password.getText().toString().equals(u.getPassword())) {
                            loggedUser = new Utente(u.getNome(), u.getCognome(), u.getEmail(), u.getPassword(), u.getRole(), u.getMansioni());
                            String jsonLoggedUser = gson.toJson(loggedUser);
                            editor.putString("loggedUser", jsonLoggedUser);
                            editor.commit();
                            loggable = true;
                                Intent intent = new Intent(getApplicationContext(), HomeUser.class);
                                startActivity(intent);
                                finish();

                        }
                    }
                    if (loggable == false)
                        Toast.makeText(Login.this, "I dati inseriti non sono corretti !", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}
