package com.example.crazyapplicator;

import java.util.ArrayList;

public class Velo {
    private String type;
    private String img_link;
    private float price;
    private ArrayList<Option> personalisation;

    public Velo(String type, String img_link, float price, ArrayList<Option> personalisation) {
        this.type = type;
        this.img_link = img_link;
        this.price = price;
        this.personalisation = personalisation;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImg_link() {
        return img_link;
    }

    public void setImg_link(String img_link) {
        this.img_link = img_link;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public ArrayList<Option> getPersonalisation() {
        return personalisation;
    }

    public void setPersonalisation(ArrayList<Option> personalisation) {
        this.personalisation = personalisation;
    }
}