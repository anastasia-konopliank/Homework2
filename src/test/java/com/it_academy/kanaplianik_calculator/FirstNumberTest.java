package com.it_academy.kanaplianik_calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FirstNumberTest {
    private static ConsoleFake console;
    private static SignFake signFake;

    @BeforeEach
    public void init() {
        console = new ConsoleFake();
    }

    @DisplayName("If first number is ggg should show message: Невозможно распарсить firstArg")
    @Test
    public void IfFirstNumberIsIncorrectShouldShowRightMessage() {
        signFake = new SignFake("/");
        FirstNumber firstNumber = new FirstNumber(signFake, console);
        console.i.add("ggg");
        firstNumber.scan();
        boolean isIncorrect = firstNumber.isIncorrect();
        Assertions.assertEquals("Невозможно распарсить firstArg", console.o.get(1), "Невозможно распарсить firstArg");
    }

    @DisplayName("If first number is really big should show message: Данная программа не рассчитана для работы с очень большими цифрами")
    @Test
    public void IfFirstNumberIsTooLongShouldShowRightMessage() {
        signFake = new SignFake("+");
        FirstNumber firstNumber = new FirstNumber(signFake, console);
        console.i.add("100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
        firstNumber.scan();
        boolean isIncorrect = firstNumber.isIncorrect();
        Assertions.assertEquals("Данная программа не рассчитана для работы с очень большими цифрами", console.o.get(1), "Данная программа не рассчитана для работы с очень большими цифрами");
    }

    @DisplayName("Output word for first number should be: Введите firstArg:")
    @Test
    public void TestingOutputWordForFirstNumberShouldBeCorrect() {
        signFake = new SignFake("/");
        console.i.add("7");
        FirstNumber firstNumber = new FirstNumber(signFake, console);
        firstNumber.scan();
        boolean isIncorrect = firstNumber.isIncorrect();
        Assertions.assertEquals("Введите firstArg:", console.o.get(0), "Введите firstArg:");
    }

    @DisplayName("Putting 5 to getValue method, expected result 5")
    @Test
    public void TestingGetValueMethod() {
        signFake = new SignFake("/");
        console.i.add("5");
        FirstNumber firstNumber = new FirstNumber(signFake, console);
        firstNumber.scan();
        boolean isIncorrect = firstNumber.isIncorrect();
        Assertions.assertEquals(5, firstNumber.getValue(), "Expect 5");
    }
}
