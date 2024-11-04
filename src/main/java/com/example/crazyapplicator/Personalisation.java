package com.example.crazyapplicator;

public class Personalisation extends Option {
    private String description;

    public Personalisation(String description, float price) {
        super(price);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
