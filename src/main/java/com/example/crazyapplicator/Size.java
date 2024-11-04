package com.example.crazyapplicator;

public class Size extends Option {
    private String size;

    public Size(String size, float price) {
        super(price);
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return size;
    }
}