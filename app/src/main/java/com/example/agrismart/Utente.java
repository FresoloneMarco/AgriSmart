package com.example.agrismart;

import android.media.Image;
import android.widget.ImageView;

import java.util.ArrayList;

public class Utente {
    private String nome;
    private String cognome;
    private String email;
    private String password;
    private String role;
    private ArrayList <Mansione> mansioni;


    public Utente(String nome, String cognome, String email, String password, String role, ArrayList<Mansione> mansioni){
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.password = password;
        this.role = role;
        this.mansioni = mansioni;

    }


    public ArrayList<Mansione> getMansioni() {
        return mansioni;
    }

    public void setMansioni(ArrayList<Mansione> mansioni) {
        this.mansioni = mansioni;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
