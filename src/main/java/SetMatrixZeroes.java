package main.java;

/**
 * 矩阵置0，要求O（1）的空间复杂度
 * 先标记空间，第二次遍历时在置0。
 *
 * 还有个方法，可以用首行首列当作标识位。还需要一个额外空间来标记首行首列的标志。
 */
public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    setFlag(matrix, i, j, m, n);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == -10000) {
                    matrix[i][j] = 0;
                }
            }
        }

    }

    public void setFlag(int[][] matrix, int row, int column, int m, int n) {
        for (int i = 0; i < m; i++) {
            if (matrix[i][column] != 0) {
                matrix[i][column] = -10000;
            }
        }
        for (int j = 0; j < n; j++) {
            if (matrix[row][j] != 0) {
                matrix[row][j] = -10000;
            }

        }
    }

    public static void main(String[] args) {
        SetMatrixZeroes setMatrixZeroes = new SetMatrixZeroes();

        int[][] board = new int[3][3];

        board[0][0] = 1;
        board[0][1] = 2;
        board[0][2] = 3;
        board[1][0] = 0;
        board[1][1] = 5;
        board[1][2] = 6;
        board[2][0] = 7;
        board[2][1] = 8;
        board[2][2] = 9;

        setMatrixZeroes.setZeroes(board);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + ",");
            }
            System.out.println();
        }


    }

}
