package com.it_academy.kanaplianik_calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SecondNumberTest {
    private static ConsoleFake console;
    private static SignFake signFake;

    @BeforeEach
    public void init() {
        console = new ConsoleFake();
    }

    @DisplayName("If second number is 0 should show message: Нельзя делить на ноль")
    @Test
    public void IfSecondNumberIsZeroShouldShowRightMessage() {
        signFake = new SignFake("/");
        SecondNumber secondNumber = new SecondNumber(signFake, console);
        console.i.add("0");
        secondNumber.scan();
        boolean isIncorrect = secondNumber.isIncorrect();
        Assertions.assertEquals("Нельзя делить на ноль", console.o.get(1), "Нельзя делить на ноль");
        Assertions.assertTrue(isIncorrect, "Number is zero, but no message for this case");
    }

    @DisplayName("If second number is yyy should show message: Невозможно распарсить secondArg")
    @Test
    public void IfSecondNumberIsIncorrectShouldShowRightMessage() {
        signFake = new SignFake("/");
        SecondNumber secondNumber = new SecondNumber(signFake, console);
        console.i.add("yyy");
        secondNumber.scan();
        Assertions.assertEquals("Невозможно распарсить secondArg", console.o.get(1), "Невозможно распарсить secondArg");
    }

    @DisplayName("If second number is really big should show message: Данная программа не рассчитана для работы с очень большими цифрами")
    @Test
    public void IfSecondNumberIsTooLongShouldShowRightMessage() {
        signFake = new SignFake("+");
        SecondNumber secondNumber = new SecondNumber(signFake, console);
        console.i.add("100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
        secondNumber.scan();
        Assertions.assertEquals("Данная программа не рассчитана для работы с очень большими цифрами", console.o.get(1), "Данная программа не рассчитана для работы с очень большими цифрами");
    }

    @DisplayName("Output word should be: Введите secondArg:")
    @Test
    public void TestingOutputWordShouldBeCorrect() {
        signFake = new SignFake("/");
        console.i.add("4");
        SecondNumber secondNumber = new SecondNumber(signFake, console);
        secondNumber.scan();
        Assertions.assertEquals("Введите secondArg:", console.o.get(0), "Введите secondArg:");
    }

    @DisplayName("Putting 4 to getValue method, expected result 4")
    @Test
    public void TestingGetValueMethod() {
        signFake = new SignFake("/");
        console.i.add("4");
        SecondNumber secondNumber = new SecondNumber(signFake, console);
        secondNumber.scan();
        boolean isIncorrect = secondNumber.isIncorrect();
        Assertions.assertEquals(4, secondNumber.getValue(), "Expect 4");
    }

}
