package main.java;

import java.lang.ref.Reference;

public class SudokuSolver {

    public void solveSudoku(char[][] board) {
        int[][] row = new int[10][];
        int[][] column = new int[10][];
        int[][] cell = new int[10][];

        for (int i = 0; i < 10; i++) {
            row[i] = new int[10];
            column[i] = new int[10];
            cell[i] = new int[10];
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char ch = board[i][j];
                if (ch == '.') {
                    continue;
                }
                int num = ch - '0';
                row[i][num] = 1;
                column[j][num] = 1;
                cell[i / 3 * 3 + j / 3][num] = 1;
            }
        }
        trackback(board, row, column, cell, 0, 0);
    }


    public boolean trackback(char[][] board, int[][] row, int[][] column, int[][] cell,
        int rowIndex,
        int columnIndex) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (i <= rowIndex && j < columnIndex) {
                    continue;
                }
                if (board[i][j] >= '1' && board[i][j] <= '9') {
                    continue;
                } else {
                    for (int k = 1; k < 10; k++) {
                        if (row[i][k] == 0 && column[j][k] == 0
                            && cell[i / 3 * 3 + j / 3][k] == 0) {
                            row[i][k] = 1;
                            column[j][k] = 1;
                            cell[i / 3 * 3 + j / 3][k] = 1;
                            board[i][j] = (char) (k + '0');

                            boolean ret = trackback(board, row, column, cell, i, j + 1);
                            if (ret) {
                                return true;
                            }

                            row[i][k] = 0;
                            column[j][k] = 0;
                            cell[i / 3 * 3 + j / 3][k] = 0;
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {

        char[][] board = new char[9][];
        for (int i = 0; i < 9; i++) {
            board[i] = new char[9];
            for (int j = 0; j < 9; j++) {
                board[i][j] = '.';
            }
        }

        board[0][0] = '5';
        board[0][1] = '3';
        board[0][4] = '7';
        board[1][0] = '6';
        board[1][3] = '1';
        board[1][4] = '9';
        board[1][5] = '5';
        board[2][1] = '9';
        board[2][2] = '8';
        board[2][7] = '6';

        board[3][0] = '8';
        board[3][4] = '6';
        board[3][8] = '3';

        board[4][0] = '4';
        board[4][3] = '8';
        board[4][5] = '3';
        board[4][8] = '1';

        board[5][0] = '7';
        board[5][4] = '2';
        board[5][8] = '6';
        board[6][1] = '6';
        board[6][6] = '2';
        board[6][7] = '8';

        board[7][3] = '4';
        board[7][4] = '1';
        board[7][5] = '9';
        board[7][8] = '5';

        board[8][4] = '8';
        board[8][7] = '7';
        board[8][8] = '9';

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Hello world");
        SudokuSolver sudokuSolver = new SudokuSolver();

        sudokuSolver.solveSudoku(board);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }


    }
}
