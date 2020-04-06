package main.java;

import java.util.LinkedList;
import java.util.List;

/**
 * 回溯法
 */
public class WordSearch {

    public boolean exist(char[][] board, String word) {
        if (board.length == 0) {
            return false;
        }

        int m = board.length;
        int n = board[0].length;

        boolean[][] use = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean isExist = backTrack(board, use, word, 0, i, j);
                if (isExist) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backTrack(char[][] board, boolean[][] use, String word, int wordIndex, int row,
        int column) {

        if (board[row][column] != word.charAt(wordIndex++)) {
            return false;
        }
        if (wordIndex == word.length()) {
            return true;
        }
        use[row][column] = true;
        //可以往上遍历
        if (row > 0 && !use[row - 1][column]) {
            if (backTrack(board, use, word, wordIndex, row - 1, column)) {
                return true;
            }
        }
        //可以往左遍历
        if (column > 0 && !use[row][column - 1]) {
            if (backTrack(board, use, word, wordIndex, row, column - 1)) {
                return true;
            }
        }

        //可以往下遍历
        if (row < board.length - 1 && !use[row + 1][column]) {
            if (backTrack(board, use, word, wordIndex, row + 1, column)) {
                return true;
            }
        }

        //可以往右遍历
        if (column < board[0].length - 1 && !use[row][column + 1]) {
            if (backTrack(board, use, word, wordIndex, row, column + 1)) {
                return true;
            }
        }

        use[row][column] = false;
        return false;


    }


    public static void main(String[] args) {
        WordSearch wordSearch = new WordSearch();

        char[][] board = new char[3][3];

        board[0][0] = 'A';
        board[0][1] = 'B';
        board[0][2] = 'B';
        board[1][0] = 'C';
        board[1][1] = 'C';
        board[1][2] = 'A';
        board[2][0] = 'D';
        board[2][1] = 'E';
        board[2][2] = 'C';

        System.out.println(wordSearch.exist(board, "BB"));

    }

}
