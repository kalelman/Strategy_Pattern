package com.kalelman.strategy_pattern;

public class SinglePrice {

    private static SinglePrice singlePrice = new SinglePrice();

    private float price;

    private SinglePrice () {

    }

    public static SinglePrice getInstance() {

        return singlePrice;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
