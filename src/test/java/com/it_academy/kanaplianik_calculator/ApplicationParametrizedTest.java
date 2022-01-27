package com.it_academy.kanaplianik_calculator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith (Parameterized.class)
public class ApplicationParametrizedTest {
    private static ConsoleFake console;

    private Number firstNumberFake;
    private Sign sign;
    private Number secondNumberFake;
    private String expectedResult;

    public ApplicationParametrizedTest(double firstNumberFake, String sign, double secondNumberFake, String expectedResult) {
        this.firstNumberFake = new NumberFake(firstNumberFake);
        this.sign = new SignFake(sign);
        this.secondNumberFake = new NumberFake(secondNumberFake);
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        Object[][] data = new Object[][] {
                {10, "+", 2, "Сумма: 12,00"},  //0
                {100000, "+", 23, "Сумма: 100023,00"}, //1
                {100000, "+", 23, "Сумма: 100023,00"}, //2
                {-200, "+", 55, "Сумма: -145,00"}, //3
                {77, "+", -177, "Сумма: -100,00"},//4
                {0, "+", 0, "Сумма: 0,00"}, //5
                {0, "+", 0.44, "Сумма: 0,44"},//6

                {100000, "-", 23, "Разность: 99977,00"},//7
                {123.4, "-", 0.4, "Разность: 123,00"},
                {88, "-", -0.47, "Разность: 88,47"},
                {-123, "-", -123, "Разность: 0,00"},
                {666, "-", 777, "Разность: -111,00"},
                {99, "-", -99, "Разность: 198,00"},
                {5, "-", 0, "Разность: 5,00"}, //13

                {100000, "*", 1, "Произведение: 100000,00"},//14
                {88, "*", -5, "Произведение: -440,00"},
                {-10, "*", 6, "Произведение: -60,00"},
                {-8, "*",-4, "Произведение: 32,00"},
                {8, "*",0, "Произведение: 0,00"},
                {0.46, "*",1.77, "Произведение: 0,81"},

                {100000, "/", 1, "Частное: 100000,00"},
                {100000, "/", 55, "Частное: 1818,18"},
                {10, "/", 10, "Частное: 1,00"},
                {96778, "/", 98, "Частное: 987,53"},
                {10, "/", 666, "Частное: 0,02"},
                {777.77, "/", 51.1, "Частное: 15,22"},
        };

        return Arrays.asList(data);
    }

    @Test
    public void checkingOfWorkingCalculationWithVariousSignAndVariousNumbers() {
        console = new ConsoleFake();
        Application application = new Application(console);
        application.calculate(sign, firstNumberFake, secondNumberFake);

        assertEquals(expectedResult, expectedResult, console.o.get(0));

    }
}
