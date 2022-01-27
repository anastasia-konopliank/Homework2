package com.it_academy.kanaplianik_calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ApplicationTest {
    private static ConsoleFake console;
    private static Application application;

    @BeforeEach
    public void init() {
        console = new ConsoleFake();
        application = new Application(console);
    }

    @DisplayName("Checking positive case of working program. Input:-,22,13 Expected result: Разность: 9,00")
    @Test
    public void PositiveCaseOfWorkingProgramWithOneExpectedResult() {
        console.i.add("-");
        console.i.add("22");
        console.i.add("13");
        application.start();
        Assertions.assertEquals("Разность: 9,00", console.o.get(3), "Разность: 9,00");
    }

    @DisplayName("Checking positive case of working program. Input: k,-,22,13 Expected result: Это не знак операции!!!, Разность: 9,00")
    @Test
    public void PositiveCaseOfWorkingProgramWithTwoExpectedResultWhenTryingToTapeSignIsIncorrect() {
        console.i.add("k");
        console.i.add("-");
        console.i.add("22");
        console.i.add("13");
        application.start();
        Assertions.assertEquals("Это не знак операции!!!", console.o.get(1), "Это не знак операции!!!");
        Assertions.assertEquals("Разность: 9,00", console.o.get(5), "Разность: 9,00");
    }

}
