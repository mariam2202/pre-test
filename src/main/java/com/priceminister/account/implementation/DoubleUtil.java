package com.priceminister.account.implementation;

public class DoubleUtil {

    public static boolean isPositive(Double amount) {
        return Double.compare(amount, Double.valueOf(0.0)) >= 0;
    }
}
