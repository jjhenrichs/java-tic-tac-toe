package com.company;

import java.util.Objects;
import java.util.Scanner;

public class Board {

    private String[][] board = {{"-", "-", "-"}, {"-", "-", "-"}, {"-", "-", "-"}};

    Board() {
        printBoard();
    }

    // Print the board
    public void printBoard() {
        for (int i = 0; i < board.length; i++) {

            // The top border
            if (i == 0) {
                System.out.println(" _____ _____ _____ _____");             // Top border line
                System.out.println("|  X  |  0  |  1  |  2  |");            // Column label
            }

           for (int j = 0; j < board[i].length; j++) {

               if (j == 0) {
                   System.out.println("|_____|_____|_____|_____|");         // Border the separates the rows
                   System.out.print("|  "+i+"  |  "+board[i][j]+"  |");     // row label + first tile space
               } else {
                   System.out.print("  "+board[i][j]+"  |");                // Remaining tile spaces
               }
           }

           System.out.println();
        }

        System.out.println("|_____|_____|_____|_____|");                    //Bottom border
    }

    // Clears the board
    public void clearBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = "-";
            }
        }
        printBoard();
    }

    // Check for winner
    public String checkWinner() {

        // Top row
        if (board[0][0].equals(board[0][1]) && board[0][1].equals(board[0][2])) {
            return board[0][0];
        }

        // Middle row
        if (board[1][0].equals(board[1][1]) && board[1][1].equals(board[1][2])) {
            return board[1][0];
        }

        // Bottom row
        if (board[2][0].equals(board[2][1]) && board[2][1].equals(board[2][2])) {
            return board[2][0];
        }

        // Left column
        if (board[0][0].equals(board[1][0]) && board[1][0].equals(board[2][0])) {
            return board[0][0];
        }

        // Middle column
        if (board[0][1].equals(board[1][1]) && board[1][1].equals(board[2][1])) {
            return board[0][1];
        }

        // Right column
        if (board[0][2].equals(board[1][2]) && board[1][2].equals(board[2][2])) {
            return board[0][2];
        }

        // Top-left to bottom-right diagonal
        if (board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2])) {
            return board[0][0];
        }

        // Top-right to bottom-left diagonal
        if (board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0])) {
            return board[0][2];
        }

        return "-";
    }

    public void markTile(int row, int column, Player p) {

        while (!board[row][column].equals("-")) {
            System.out.println("That spot has already been taken, "+p.getName());
            row = p.selectRow();
            column = p.selectColumn();
        }
        board[row][column] = p.getSymbol();
    }
}
