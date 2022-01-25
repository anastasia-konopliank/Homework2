package com.it_academy.kanaplianik_calculator;

import java.util.ArrayList;
import java.util.List;

public class ConsoleFake {
    public List<String> i = new ArrayList<>();
    public List<String> o = new ArrayList<>();

    private int currentLine = 0;

    public String nextLine() {
        var itemToReturn = i.get(currentLine);
        currentLine++;
        return itemToReturn;
    }

    public void println(String value) {
        o.add(value);
    }
}
