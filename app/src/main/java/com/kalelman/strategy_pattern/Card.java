package com.kalelman.strategy_pattern;

public class Card implements Strategy {

    @Override
    public String processPayment(float price) {
        return String.format("%.2f", price + 0.5f);
    }
}
