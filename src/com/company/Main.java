package com.company;

import java.util.Objects;

public class Main {

    public static void main(String[] args) {

        int row, column;

        Board board = new Board();

        Player p1 = new Player("Player 1", "X");
        Player p2 = new Player("Player 2", "O");

        int moves = 9;

        while (board.checkWinner().equals("-") && moves > 0) {

            if (moves % 2 == 1) {
                System.out.println("Player 1's turn");
                row = p1.selectRow();
                column = p1.selectColumn();
                board.markTile(row, column, p1);
            } else {
                System.out.println("Player 2's turn");
                row = p2.selectRow();
                column = p2.selectColumn();
                board.markTile(row, column, p2);
            }

            moves--;
            board.printBoard();
        }

        if (moves == 0 && board.checkWinner().equals("-")) {
            System.out.println("Draw. Everybody's a winner.");
        } else if (board.checkWinner().equals(p1.getSymbol())) {
            System.out.println("Player 1 Wins");
        } else {
            System.out.println("Player 2 Wins.");
        }

    }
}
