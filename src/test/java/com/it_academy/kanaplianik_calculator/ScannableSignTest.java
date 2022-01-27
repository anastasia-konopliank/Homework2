package com.it_academy.kanaplianik_calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ScannableSignTest {
    private static ScannableSign scannableSign;
    private static ConsoleFake console;

    @BeforeAll
    public static void init() {
        console = new ConsoleFake();
        scannableSign = new ScannableSign(console);
    }


    @DisplayName("For sign (/) - first argument word should be: делимое")
    @Test
    public void firstArgName_whenDivide_shouldBeCorrect() {
        console.i.add("/");
        scannableSign.scan();
        var firstArg = scannableSign.firstArgName();
        Assertions.assertEquals("делимое", firstArg, "should be: делимое");
    }

    @DisplayName("For sign (/) - second argument word should be: делитель")
    @Test
    public void value_whenDivide_shouldBeCorrect() {
        console.i.add("/");
        scannableSign.scan();
        var secondArg = scannableSign.secondArgName();
        Assertions.assertEquals("делитель", secondArg, "should be: делитель");
        Assertions.assertEquals("/", scannableSign.getValue(), "/ expected");
    }

    @DisplayName("For sign (*) - first argument word should be: множитель")
    @Test
    public void firstArgName_whenMultiply_shouldBeCorrect() {
        console.i.add("*");
        scannableSign.scan();
        var firstArg = scannableSign.firstArgName();
        Assertions.assertEquals("множитель", firstArg, "should be: множитель");
    }

    @DisplayName("For sign (+) - first argument word should be: слагаемое")
    @Test
    public void firstArgName_whenAdd_shouldBeCorrect() {
        console.i.add("+");
        scannableSign.scan();
        var firstArg = scannableSign.firstArgName();
        Assertions.assertEquals("слагаемое", firstArg, "should be: слагаемое");
    }

    @DisplayName("For sign (-) - first argument word should be: уменьшаемое")
    @Test
    public void firstArgName_whenSubstract_shouldBeCorrect() {
        console.i.add("-");
        scannableSign.scan();
        var firstArg = scannableSign.firstArgName();
        Assertions.assertEquals("уменьшаемое", firstArg, "should be: уменьшаемое");
    }

    @DisplayName("For sign (*) - second argument word should be: второй множитель")
    @Test
    public void secondArgName_whenMultiply_shouldBeCorrect() {
        console.i.add("*");
        scannableSign.scan();
        var secondArg = scannableSign.secondArgName();
        Assertions.assertEquals("второй множитель", secondArg, "should be: второй множитель");
    }

    @DisplayName("For sign (+) - second argument word should be: второе слагаемое")
    @Test
    public void secondArgName_whenAdd_shouldBeCorrect() {
        console.i.add("+");
        scannableSign.scan();
        var secondArg = scannableSign.secondArgName();
        Assertions.assertEquals("второе слагаемое", secondArg, "should be: второе слагаемое");
    }

    @DisplayName("For sign (-) - second argument word should be: вычитаемое")
    @Test
    public void secondArgName_whenSubstract_shouldBeCorrect() {
        console.i.add("-");
        scannableSign.scan();
        var secondArg = scannableSign.secondArgName();
        Assertions.assertEquals("вычитаемое", secondArg, "should be: вычитаемое");
    }

    @DisplayName("For sign (/) - resultName word should be: Частное")
    @Test
    public void resultName_whenDivide_shouldBeCorrect() {
        console.i.add("/");
        scannableSign.scan();
        var resultName = scannableSign.resultName();
        Assertions.assertEquals("Частное", resultName, "should be: Частное");
    }

    @DisplayName("For sign (-) - resultName word should be: Разность")
    @Test
    public void resultName_whenSubstract_shouldBeCorrect() {
        console.i.add("-");
        scannableSign.scan();
        var resultName = scannableSign.resultName();
        Assertions.assertEquals("Разность", resultName, "should be: Разность");
    }

    @DisplayName("For sign (*) - resultName word should be: Произведение")
    @Test
    public void resultName_whenMultiply_shouldBeCorrect() {
        console.i.add("*");
        scannableSign.scan();
        var resultName = scannableSign.resultName();
        Assertions.assertEquals("Произведение", resultName, "should be: Произведение");
    }

    @DisplayName("For sign (+) - resultName word should be: Сумма")
    @Test
    public void resultName_whenAdd_shouldBeCorrect() {
        console.i.add("+");
        scannableSign.scan();
        var resultName = scannableSign.resultName();
        Assertions.assertEquals("Сумма", resultName, "should be: Сумма");
    }


    @DisplayName("If sign is incorrect should show message: Это не знак операции!!!")
    @Test
    public void IfSignIsIncorrectShouldShowMessage() {
        console.i.add("h");
        scannableSign.scan();
        boolean signIncorrect = scannableSign.isIncorrect();
        Assertions.assertEquals("Это не знак операции!!!", console.o.get(1), "Это не знак операции!!!");
        Assertions.assertTrue(signIncorrect, "Sign is incorrect but no special message");
    }

    @DisplayName("If sign is incorrect should show message: Вы ввели не знак операции")
    @Test
    public void IfSignIsIncorrectShouldShowRightMessageForResultName() {
        console.i.add("h");
        scannableSign.scan();
        boolean signIncorrect = scannableSign.isIncorrect();
        Assertions.assertEquals("Вы ввели не знак операции", scannableSign.resultName(), "Вы ввели не знак операции");
    }

    @DisplayName("If sign is incorrect should show message to first number: Вы ввели не знак операции")
    @Test
    public void IfSignIsIncorrectShouldShowRightMessageForFirstNumber() {
        console.i.add("h");
        scannableSign.scan();
        boolean signIncorrect = scannableSign.isIncorrect();
        Assertions.assertEquals("Вы ввели не знак операции", scannableSign.firstArgName(), "Вы ввели не знак операции");
    }

    @DisplayName("If sign is incorrect should show message to second number: Вы ввели не знак операции")
    @Test
    public void IfSignIsIncorrectShouldShowRightMessageForSecondNumber() {
        console.i.add("h");
        scannableSign.scan();
        boolean signIncorrect = scannableSign.isIncorrect();
        Assertions.assertEquals("Вы ввели не знак операции", scannableSign.secondArgName(), "Вы ввели не знак операции");
    }

}

