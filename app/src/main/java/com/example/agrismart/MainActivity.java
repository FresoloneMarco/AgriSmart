package com.example.agrismart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ImageButton login_button;
    private ArrayList<Seme> semi;
    private ArrayList<Trattamento> trattamenti;
    private ArrayList<Concime> concimi;
    private ArrayList<Mansione> mansioni;
    private ArrayList<Utente> utenti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int i;
        semi = new ArrayList<>();
        trattamenti = new ArrayList<>();
        concimi = new ArrayList<>();
        mansioni = new ArrayList<>();
        utenti = new ArrayList<>();


        /* --- CREAZIONE RISORSE --- */
        for(i=0; i < 10; i++){
            Seme s = new Seme("Seme #" + i, 10, i);
            Trattamento t = new Trattamento("Trattamento #" + i, 10, i);
            Concime c = new Concime("Concime #" + i, 10, i);

            semi.add(s);
            trattamenti.add(t);
            concimi.add(c);
        }
        /* --- FINE CREAZIONE RISORSE --- */

        /* --- CREAZIONE MANSIONI --- */
        for(i=0; i<3; i++){
            Mansione m = new Mansione("Mansione " + i, "Questa è la mansione n° " + i, "1");
            mansioni.add(m);
        }
       /*--- FINE CREAZIONE MANSIONI --- */

        /*--- CREAZIONE UTENTI --- */
        for(i=0; i<6; i++){
            Utente u = new Utente("Utente "+ i, "Cognome " + i, "utente" + i + "@gmail.com", "password"+i, "operaio", mansioni);
            utenti.add(u);
        }
        Utente u = new Utente("Paolo "+ i, "Schiavo " + i, "admin@gmail.com", "admin", "admin", mansioni);
            utenti.add(u);
        /*--- FINE CREAZIONE UTENTI ---*/


        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String jsonSemi = gson.toJson(semi);
        String jsonTrattamenti = gson.toJson(trattamenti);
        String jsonConcimi  = gson.toJson(concimi);
        String jsonMansioni = gson.toJson(mansioni);
        String jsonUtenti   = gson.toJson(utenti);

        editor.putString("mansione_completata", "no").commit();
        editor.putString("concimi", jsonConcimi);
        editor.putString("semi", jsonSemi);
        editor.putString("trattamenti", jsonTrattamenti);
        editor.putString("utenti", jsonUtenti);
        editor.commit();

        login_button = findViewById(R.id.login_button1);

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
