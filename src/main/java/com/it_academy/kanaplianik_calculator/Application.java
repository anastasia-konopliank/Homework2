package com.it_academy.kanaplianik_calculator;

import java.text.DecimalFormat;

public class Application {
    private Console console;

    public static void main(String[] args) {
        new Application(new SystemConsole()).start();
    }

    public Application(Console console) {

        this.console = console;
    }

    public void start() {
        Sign sign = new Sign(console);
        do {
            sign.scan();
        } while (sign.isIncorrect());

        FirstNumber firstNumber = new FirstNumber(sign, console);
        do {
            firstNumber.scan();
        } while (firstNumber.isIncorrect());


        if (firstNumber.isIncorrect()) {
            return;
        }

        SecondNumber secondNumber = new SecondNumber(sign, console);
        do {
            secondNumber.scan();
        } while (secondNumber.isIncorrect());



        if (secondNumber.isIncorrect()) {
            return;
        }

        switch (sign.getValue()) {
            case ("/"):

                double divResult = firstNumber.getValue() / secondNumber.getValue();
                String formattedDuvResult = new DecimalFormat("#0.00").format(divResult);
                console.println("Частное: " + formattedDuvResult);

                break;
            case ("*"):

                double mulResult = firstNumber.getValue() * secondNumber.getValue();
                String formattedMulResult = new DecimalFormat("#0.00").format(mulResult);
                console.println("Произведение: " + formattedMulResult);
                break;
            case ("+"):
                double addResult = firstNumber.getValue() + secondNumber.getValue();
                String formattedAddResult = new DecimalFormat("#0.00").format(addResult);
                console.println("Сумма: " + formattedAddResult);
                break;
            case ("-"):

                double subResult = firstNumber.getValue() - secondNumber.getValue();
                String formattedSubResult = new DecimalFormat("#0.00").format(subResult);
                console.println("Разность: " + formattedSubResult);
                break;
            default:
                console.println("Вы ввели не знак операции");
                break;
        }
    }
}
