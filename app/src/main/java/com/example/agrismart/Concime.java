package com.example.agrismart;

public class Concime {
    private String nome;
    private int max_qty;
    private int qty;

    public Concime(String nome, int max_qty, int qty){
        this.nome = nome;
        this.qty = qty;
        this.max_qty = max_qty;
    }

    public int getMax_qty() {
        return max_qty;
    }

    public int getQty() {
        return qty;
    }

    public String getNome() {
        return nome;
    }

    public void setMax_qty(int max_qty) {
        this.max_qty = max_qty;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
