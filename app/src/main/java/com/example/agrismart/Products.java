package com.example.agrismart;

public class Products {
    private String title;
    private String subtitle;
    private String quantity;

    public Products(String title, String subtitle, String quantity) {
        this.title = title;
        this.subtitle = subtitle;
        this.quantity = quantity;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getTitle() {
        return title;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
