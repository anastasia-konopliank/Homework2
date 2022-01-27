package com.it_academy.kanaplianik_calculator;

public class NumberFake implements Number {

    private double number;

    public NumberFake(double number) {

        this.number = number;
    }

    @Override
    public double getValue() {
        return number;
    }
}
