package com.company;

import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Player {

    private String name, symbol;

    Player(String name, String symbol) {
        setName(name);
        setSymbol(symbol);
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public int selectRow() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Select a row (Enter a number between 0 and 3): ");

        int row = scan.nextInt();

        while (row < 0 || row > 2) {
            System.out.println("Please enter 0, 1, 2");
            row = scan.nextInt();
        }

        return row;
    }

    public int selectColumn() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Select a column (Enter a number between 0 and 3): ");

        int column = scan.nextInt();

        while (column < 0 || column > 2) {
            System.out.println("Please enter 0, 1, 2");
            column = scan.nextInt();
        }

        return column;
    }

}
