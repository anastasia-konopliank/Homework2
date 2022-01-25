package com.it_academy.kanaplianik_calculator;

import java.util.Scanner;

public class SystemConsole implements Console {

    public String nextLine() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void println(String value) {
        System.out.println(value);
    }
}
