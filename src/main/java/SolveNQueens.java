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
 */
public class SolveNQueens {

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> list = new LinkedList<>();
        char[][] chessboard = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chessboard[i][j] = '.';
            }
        }

        boolean[] column = new boolean[n];
        boolean[] diagonal = new boolean[2 * n - 1];
        boolean[] nDiagonal = new boolean[2 * n - 1];

        dfs(list, chessboard, column, diagonal, nDiagonal, 0, n, 0);
        return list;
    }

    public void dfs(List<List<String>> list, char[][] chessboard,
        boolean[] column,
        boolean[] diagonal, boolean[] nDiagonal, int placeNum, int n, int rowNum) {

        if (placeNum == n) {
            list.add(transferOutput(chessboard, n));
            return;
        }

        for (int j = 0; j < n; j++) {
            if (column[j] || diagonal[rowNum + j] || nDiagonal[n - rowNum - 1 + j]) {
                continue;
            }
            placeNum++;
            column[j] = true;
            diagonal[rowNum + j] = true;
            nDiagonal[n - 1 - rowNum + j] = true;
            chessboard[rowNum][j] = 'Q';
            dfs(list, chessboard, column, diagonal, nDiagonal, placeNum, n, rowNum + 1);
            chessboard[rowNum][j] = '.';
            column[j] = false;
            diagonal[rowNum + j] = false;
            nDiagonal[n - 1 - rowNum + j] = false;
            placeNum--;
        }
    }

    public List<String> transferOutput(char[][] chessboard, int n) {
        List<String> result = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            String str = String.valueOf(chessboard[i]);
            result.add(str);
        }
        return result;
    }


    public static void main(String[] args) {
        SolveNQueens solveNQueens = new SolveNQueens();

        List<List<String>> lists = solveNQueens.solveNQueens(1);

        for (List<String> list : lists) {
            System.out.println(list);
        }
    }

}
