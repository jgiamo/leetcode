package main.java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 旋转图像
 */
public class RotateImage {

    //将数组分成4个模块，每个模块旋转4次即可。旋转坐标i,j->j,n-1-i
    public void rotate(int[][] matrix) {

        int n = matrix.length;
        for (int i = 0; i < n / 2 + n % 2; i++) {
            for (int j = 0; j < n / 2; j++) {

                //完成4次旋转，4个点的坐标分别是(i,j)(j,n-1-i)(n-1-i,n-1-j)(n-1-j,i)
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = temp;

            }
        }
    }


    public static void main(String[] args) {
        int[][] matrix = new int[3][3];

        matrix[0][0] = 1;
        matrix[0][1] = 2;
        matrix[0][2] = 3;
        matrix[1][0] = 4;
        matrix[1][1] = 5;
        matrix[1][2] = 6;
        matrix[2][0] = 7;
        matrix[2][1] = 8;
        matrix[2][2] = 9;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        RotateImage rotateImage = new RotateImage();
        rotateImage.rotate(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("hello world");
    }

}
