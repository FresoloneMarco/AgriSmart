package com.example.agrismart;

import android.widget.ImageView;

public class Membro {
    private String nome;
    private String cognome;
    private ImageView proPic;

    public Membro(String nome , String cognome){
        this.nome = nome;
        this.cognome =cognome;
    }

    public String getNome() {
        return nome;
    }

    public ImageView getProPic() {
        return proPic;
    }

    public String getCognome() {
        return cognome;
    }
}
