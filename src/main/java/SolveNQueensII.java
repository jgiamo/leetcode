package main.java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * n皇后问题，回溯法+剪枝叶
 * 这道题其实和数独那道题一样，只不过除了行和列的判断，还需要加上主对角线，副对角线
 *
 * 关于剪枝，一开始我是用行和列遍历，需要记录当前的位置，然后下次递归时，需要判断跳过。其实有更简单的方法，
 * 因为要n个，所有每一行必定要存在一个且只有一个，所以遍历的时候，只需要遍历列就可以了，因为行每次当会加1
 * 这里的解法是我第一次写的解法，没有上面的优化
 */

public class SolveNQueensII {

    int num = 0;

    public int totalNQueens(int n) {
        boolean[] row = new boolean[n];
        boolean[] column = new boolean[n];
        boolean[] diagonal = new boolean[2 * n - 1];
        boolean[] nDiagonal = new boolean[2 * n - 1];

        dfs(row, column, diagonal, nDiagonal, 0, n, 0, -1);
        return num;
    }


    public void dfs(boolean[] row,
        boolean[] column,
        boolean[] diagonal, boolean[] nDiagonal, int placeNum, int n, int startRow,
        int startColumn) {

        if (placeNum == n) {
            num++;
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i < startRow || (i == startRow && j <= startColumn)) {
                    continue;
                }
                if (row[i] || column[j] || diagonal[i + j] || nDiagonal[n - i - 1 + j]) {
                    continue;
                }
                placeNum++;
                row[i] = true;
                column[j] = true;
                diagonal[i + j] = true;
                nDiagonal[n - 1 - i + j] = true;
                dfs(row, column, diagonal, nDiagonal, placeNum, n, i, j);
                row[i] = false;
                column[j] = false;
                diagonal[i + j] = false;
                nDiagonal[n - 1 - i + j] = false;
                placeNum--;
            }
        }
    }


    public static void main(String[] args) {
        SolveNQueensII solveNQueens = new SolveNQueensII();

        int n = solveNQueens.totalNQueens(1);

        System.out.println(n);
    }

}
