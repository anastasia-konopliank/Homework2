package com.it_academy.kanaplianik_calculator;

public class SecondNumber {
    private boolean isParsingIncorrect;
    private double parseDiv2;
    private Sign sign;
    private Console console;

    public SecondNumber(Sign sign, Console console) {
        this.sign = sign;
        this.console = console;

    }

    public void scan() {
        console.println("Введите " + sign.secondArgName() + ":");
        String somethingToDivide1 = console.nextLine();

        try {
            parseDiv2 = Double.parseDouble(somethingToDivide1);
            Double d2 = parseDiv2;
            if (d2.isInfinite()) {
                console.println("Данная программа не рассчитана для работы с очень большими цифрами");
                isParsingIncorrect = true;
                return;


            }
            isParsingIncorrect = false;
        } catch (Exception exDiv2) {
            console.println("Невозможно распарсить " + sign.secondArgName());
            isParsingIncorrect = true;
        }
    }

    public boolean isIncorrect() {
        if (!isParsingIncorrect && parseDiv2 == 0) {
            console.println("Нельзя делить на ноль");
            return true;
        }

        return isParsingIncorrect;
    }

    public double getValue() {
        return parseDiv2;
    }
}
