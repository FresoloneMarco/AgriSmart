package com.example.agrismart;

public class Mansione {
    String nome;
    String descrizione;
    String serra;

    public Mansione(){}
    public Mansione(String nome, String descrizione, String serra) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.serra = serra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getSerra() {
        return serra;
    }

    public void setSerra(String serra) {
        this.serra = serra;
    }
}
