package com.example.splash;

public class marketprice {

        private String name;
        private Float price;
        private int thumb;

    public marketprice(String name, Float price, int thumb) {
        this.name = name;
        this.price = price;
        this.thumb = thumb;
    }

    public marketprice() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public int getThumb() {
        return thumb;
    }

    public void setThumb(int thumb) {
        this.thumb = thumb;
    }
}
