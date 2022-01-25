package com.it_academy.kanaplianik_calculator;

public class FirstNumber {
    private boolean isIncorrect;
    private double parseDiv1;
    private Sign sign;
    private Console console;

    public FirstNumber(Sign sign, Console console) {
        this.sign = sign;
        this.console = console;
    }

    public void scan() {
        console.println("Введите " + sign.firstArgName() + ":");
        String somethingToDivide1 = console.nextLine();

        try {
            parseDiv1 = Double.parseDouble(somethingToDivide1);
            Double d1 = parseDiv1;
            if (d1.isInfinite()) {
                console.println("Данная программа не рассчитана для работы с очень большими цифрами");
                isIncorrect = true;
                return;
            }
            isIncorrect = false;
        } catch (Exception exDiv1) {
            console.println("Невозможно распарсить " + sign.firstArgName());
            isIncorrect = true;
        }
    }

    public boolean isIncorrect() {
        return isIncorrect;
    }

    public double getValue() {
        return parseDiv1;
    }
}
