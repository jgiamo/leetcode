package main.java;

/**
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 * 从边界考虑向里面扩展。看了网上的解法，我的这里的flag数组其实没有必要，在原数组上使用另一个字符替换边界O就可以了，在最后遍历的时候还原回来就可以了
 */
public class SurroundedRegions {

    public void solve(char[][] board) {
        if(board.length <= 2 ){
            return;
        }
        int row = board.length;
        int column = board[0].length;

        boolean[][] flag = new boolean[row][column];

        //从四条边开始搜索
        int i, j;
        i = 0;
        for (j = 1; j < column - 1; j++) {
            expand(flag, board, i, j, row, column);
        }

        i = row - 1;
        for (j = 1; j < column - 1; j++) {
            expand(flag, board, i, j, row, column);
        }

        j = 0;
        for (i = 1; i < row - 1; i++) {
            expand(flag, board, i, j, row, column);
        }

        j = column - 1;
        for (i = 1; i < row - 1; i++) {
            expand(flag, board, i, j, row, column);
        }

        for (i = 1; i < row - 1; i++) {
            for (j = 1; j < column - 1; j++) {
                if (!flag[i][j] && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void expand(boolean[][] flag, char[][] board, int rowNum, int columnNum, int rowLimit,
        int columnLimit) {

        //从这个点开始向4周开始扩展，碰到O或者X就标记true，碰到X停止搜索
        flag[rowNum][columnNum] = true;
        if (board[rowNum][columnNum] == 'X') {
            return;
        }
        if (rowNum + 1 < rowLimit) {
            if (!flag[rowNum + 1][columnNum]) {
                expand(flag, board, rowNum + 1, columnNum, rowLimit, columnLimit);
            }
        }
        if (rowNum - 1 >= 0) {
            if (!flag[rowNum - 1][columnNum]) {
                expand(flag, board, rowNum - 1, columnNum, rowLimit, columnLimit);
            }
        }
        if (columnNum + 1 < columnLimit) {
            if (!flag[rowNum][columnNum + 1]) {
                expand(flag, board, rowNum, columnNum + 1, rowLimit, columnLimit);
            }
        }
        if (columnNum - 1 >= 0) {
            if (!flag[rowNum][columnNum - 1]) {
                expand(flag, board, rowNum, columnNum - 1, rowLimit, columnLimit);
            }
        }
    }


    public static void main(String[] args) {
        SurroundedRegions surroundedRegions = new SurroundedRegions();

        char[][] board = new char[3][3];

        board[0][0] = 'X';
        board[0][1] = 'X';
        board[0][2] = 'X';
        board[1][0] = 'X';
        board[1][1] = 'O';
        board[1][2] = 'X';
        board[2][0] = 'X';
        board[2][1] = 'X';
        board[2][2] = 'X';

        surroundedRegions.solve(board);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + ",");
            }
            System.out.println();
        }


    }

}
