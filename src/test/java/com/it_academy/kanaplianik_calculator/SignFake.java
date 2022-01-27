package com.it_academy.kanaplianik_calculator;

public class SignFake implements Sign {

    private String sign;

    public SignFake(String sign) {

        this.sign = sign;
    }

    @Override
    public String getValue() {
        return sign;
    }

    @Override
    public String secondArgName() {
        return "secondArg";
    }

    @Override
    public String firstArgName() {
        return "firstArg";
    }
}
