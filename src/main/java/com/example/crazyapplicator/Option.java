package com.example.crazyapplicator;

public abstract class Option {
    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    private float price;

    public Option(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Option{" +
                "price=" + price +
                '}';
    }
}