package com.example.agrismart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class HomeUser extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Toolbar toolbar;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout2);
        toolbar=findViewById(R.id.toolbar);
        drawerLayout= findViewById(R.id.drawer2);
        navigationView=findViewById(R.id.navigationView);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        actionBarDrawerToggle.syncState();


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        drawerLayout.closeDrawer(GravityCompat.START);

        if(menuItem.getItemId() == R.id.home_btn){
            Intent intent = new Intent(getApplicationContext(), HomeUser.class);
            startActivity(intent);

        }

        if(menuItem.getItemId()==R.id.magazzino_btn){
            Intent intent = new Intent(getApplicationContext(), Serre.class);
            startActivity(intent);
        }

        if(menuItem.getItemId()==R.id.membri_btn){

        }

        if(menuItem.getItemId()==R.id.serre_btn){

        }

        if(menuItem.getItemId()==R.id.raccolto_btn){

        }

        if(menuItem.getItemId()==R.id.turni_btn){

        }
        return true;
    }
}
