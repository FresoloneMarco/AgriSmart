package com.example.agrismart;

public class Risorse {
    private String title;
    private String quantity;

    public Risorse(String title, String quantity) {
        this.title = title;
        this.quantity = quantity;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getTitle() {
        return title;
    }

}
