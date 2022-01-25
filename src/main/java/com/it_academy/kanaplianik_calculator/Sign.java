package com.it_academy.kanaplianik_calculator;

public class Sign {
    private Console console;

    private String sign;

    public Sign(Console console) {

        this.console = console;
        this.sign = "unknown";

    }

    public String firstArgName() {
        switch (sign) {
            case ("/"):
                return "делимое";
            case ("*"):
                return "множитель";
            case ("+"):
                return "слагаемое";
            case ("-"):
                return "уменьшаемое";
        }

        return "unknown";
    }

    public String secondArgName() {
        switch (sign) {
            case ("/"):
                return "делитель";

            case ("*"):
                return "второй множитель";

            case ("+"):
                return "второе слагаемое";

            case ("-"):
                return "вычитаемое";

            default:
                return "Вы ввели не знак операции";
        }
    }

    public String getValue() {
        return sign;
    }

    public String resultName() {
        switch (sign) {
            case ("/"):
                return "Частное";
            case ("*"):
                return "Произведение";
            case ("+"):
                return "Сумма";
            case ("-"):
                return "Разность";
            default:
                return "Вы ввели не знак операции";
        }
    }

    public void scan() {
        console.println("Введите знак операции: ");
        String scannedSign = console.nextLine();
        sign = scannedSign;
    }

    public boolean isIncorrect() {
        if (!sign.equals("+") && !sign.equals("-") &&!sign.equals("*") && !sign.equals("/")) {
            console.println("Это не знак операции!!!");
            return true;
        }
        else return false;
    }
}
