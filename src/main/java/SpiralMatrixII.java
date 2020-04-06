package main.java;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵，主要是设定4个边界，随着顺时针遍历的时候，边界在缩小
 */
public class SpiralMatrixII {

    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int i = 0, j = 0;

        int left = 0;
        int up = 0;
        int right = n - 1;
        int down = n - 1;
        int m = 1;
        while(true){

            for (j = left; j <= right; j++) {
                result[up][j] = m++;
            }
            if(++up > down){
                break;
            }
            for (i = up; i <= down; i++) {
                result[i][right] = m++;
            }
            if(--right < left){
                break;
            }
            for (j = right; j >= left; j--) {
                result[down][j] = m++;
            }
            if(--down < up){
                break;
            }

            for (i = down; i >= up; i--) {
                result[i][left] = m++;
            }
            if(++left > right){
                break;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        SpiralMatrixII spiralMatrixII = new SpiralMatrixII();

        int n = 4;
        int[][] array = spiralMatrixII.generateMatrix(n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(array[i][j] + ",");
            }
            System.out.println();
        }
    }
}
