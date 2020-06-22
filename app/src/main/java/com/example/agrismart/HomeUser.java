package com.example.agrismart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.widget.Button;

import com.example.agrismart.fragments.HomeFragment;
import com.example.agrismart.fragments.MagazzinoFragment;
import com.example.agrismart.fragments.MansioniFragment;
import com.example.agrismart.fragments.MansioniListFragment;
import com.example.agrismart.fragments.MembriFragment;
import com.example.agrismart.fragments.RaccoltoFragment;
import com.example.agrismart.fragments.SerreFragment;
import com.google.android.material.navigation.NavigationView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class HomeUser extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    private Gson gson;
    private SharedPreferences.Editor editor;
    private Utente loggedUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        gson = new Gson();
        editor = sharedPreferences.edit();
        String loggedUserJson = sharedPreferences.getString("loggedUser", "");
        Type typeUtente = new TypeToken<Utente>() {
        }.getType();
        loggedUser = gson.fromJson(loggedUserJson, typeUtente);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setCheckedItem(R.id.home_btn);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new HomeFragment()).commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.home_btn:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new HomeFragment()).commit();
                break;
            case R.id.serre_btn:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new SerreFragment()).commit();
                break;
            case R.id.magazzino_btn:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new MagazzinoFragment()).commit();
                break;
            case R.id.membri_btn:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new MembriFragment()).commit();
                break;
            case R.id.raccolto_btn:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new RaccoltoFragment()).commit();
                break;
            case R.id.turni_btn:
                if (loggedUser.getRole().equals("admin")) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new MansioniFragment()).commit();
                } else {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new MansioniListFragment()).commit();
                }
                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent miaActivity = new Intent(getApplicationContext(), HomeUser.class);
            startActivity(miaActivity);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


}
