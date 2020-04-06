package main.java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 螺旋矩阵，主要是设定4个边界，随着顺时针遍历的时候，边界在缩小
 */
public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {

        int m = matrix.length;
        if(m == 0){
            return new ArrayList<>();
        }
        int n = matrix[0].length;

        List<Integer> list = new ArrayList<>(m * n);

        int up = 0;
        int left = 0;
        int right = n - 1;
        int down = m - 1;

        while (true) {
            for (int i = left; i <= right; i++) {
                list.add(matrix[up][i]);
            }
            if(++up > down){
                break;
            }
            for (int i = up; i <= down; i++) {
                list.add(matrix[i][right]);
            }
            if(--right < left){
                break;
            }
            for (int i = right; i >= left; i--) {
                list.add(matrix[down][i]);
            }
            if(--down < up){
                break;
            }
            for (int i = down; i >= up; i--) {
                list.add(matrix[i][left]);
            }
            if(++left > right){
                break;
            }
        }
        return list;

    }


    public static void main(String[] args) {

        int[][] board = new int[3][3];

        board[0][0] = 1;
        board[0][1] = 2;
        board[0][2] = 3;
        board[1][0] = 4;
        board[1][1] = 5;
        board[1][2] = 6;
        board[2][0] = 7;
        board[2][1] = 8;
        board[2][2] = 9;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + ",");
            }
            System.out.println();
        }

        System.out.println("Hello world");
        SpiralMatrix spiralMatrix = new SpiralMatrix();

        List<Integer> list = spiralMatrix.spiralOrder(board);

        System.out.println(list);
    }
}
