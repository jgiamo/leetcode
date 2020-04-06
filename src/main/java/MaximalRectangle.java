package main.java;

/**
 * 最大矩形面积 ***
 */
public class MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {

        if (matrix.length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];

        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else {
                    //这种情况下，这个点作为矩形右下角的面积。问题变成了直方图的最大面积
                    if (j >= 1) {
                        dp[i][j] = dp[i][j - 1] + 1;
                    } else{
                        dp[i][j] = 1;
                    }
                    int width = dp[i][j];
                    for (int k = i; k >= 0; k--) {
                        if (dp[k][j] == 0) {
                            break;
                        }
                        width = Math.min(width, dp[k][j]);
                        maxArea = Math.max(maxArea, (i -k + 1) * width);
                    }
                }
            }
        }
        return maxArea;
    }


    public static void main(String[] args) {
        MaximalRectangle maximalRectangle = new MaximalRectangle();

        char[][] board = new char[4][5];

        board[0][0] = '1';
        board[0][1] = '0';
        board[0][2] = '1';
        board[0][3] = '0';
        board[0][4] = '0';
        board[1][0] = '1';
        board[1][1] = '0';
        board[1][2] = '1';
        board[1][3] = '1';
        board[1][4] = '1';
        board[2][0] = '1';
        board[2][1] = '1';
        board[2][2] = '1';
        board[2][3] = '1';
        board[2][4] = '1';
        board[3][0] = '1';
        board[3][1] = '0';
        board[3][2] = '0';
        board[3][3] = '1';
        board[3][4] = '0';

        System.out.println(maximalRectangle.maximalRectangle(board));

    }

}
