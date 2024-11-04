package com.example.crazyapplicator;

public class Colors extends Option {
    private String color;
    private String color_hexa;

    public Colors(String color, String color_hexa, float price) {
        super(price);
        this.color = color;
        this.color_hexa = color_hexa;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor_hexa() {
        return color_hexa;
    }

    public void setColor_hexa(String color_hexa) {
        this.color_hexa = color_hexa;
    }

    @Override
    public String toString() {
        return color;
    }
}
