package main.java;

/**
 * 搜索二维数组，关键是怎么转换成一维数组中的二分查找  ***
 */
public class Search2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length <= 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;

        int start = 0;
        int end = m * n - 1;
        while(start <= end){
            int index = (start + end) /2;

            int posX = index / n;
            int posY = index % n;
            if(matrix[posX][posY] < target){
                 start = index + 1;
            }else if(matrix[posX][posY] > target){
                 end = index - 1;
            }else {
                return true;
            }
        }
        return false;
    }

//    public boolean searchMatrix(int[][] matrix, int target) {
//        if (matrix.length <= 0) {
//            return false;
//        }
//        int m = matrix.length;
//        int n = matrix[0].length;
//
//        int rowUp = 0;
//        int rowDown = m - 1;
//
//        int columnLeft = 0;
//        int columnRight = n - 1;
//
//        int column = (columnLeft + columnRight + 1) / 2;
//        int row = (rowUp + rowDown + 1) / 2;
//        while (row != rowUp && row!= rowDown) {
//            if (matrix[row][column] < target) {
//                rowUp = row;
//            } else if (matrix[row][column] > target) {
//                rowDown = row;
//            } else {
//                return true;
//            }
//            row = (rowUp + rowDown + 1) / 2;
//        }
//
//        boolean isPre = true;
//        if (matrix[row][column] < target) {
//            isPre = false;
//        }
//
//        if (isPre) {
//            if (matrix[row][0] < target) {
//                return isExist(matrix[row], 1, column - 1, target);
//            } else if (matrix[row][n - 1] > target) {
//                if (row - 1 >= 0) {
//                    return isExist(matrix[row - 1], column + 1, n - 1, target);
//                }
//            } else {
//                return true;
//            }
//
//
//        } else {
//            if (matrix[row][n - 1] > target) {
//                return isExist(matrix[row], column + 1, n - 2, target);
//            } else if (matrix[row][n - 1] < target) {
//                if (row + 1 <= n - 1) {
//                    return isExist(matrix[row + 1], 0, column - 1, target);
//                }
//            } else {
//                return true;
//            }
//
//        }
//
//        return false;
//    }
//
//    public boolean isExist(int[] array, int minPos, int maxPos, int target) {
//        while (minPos < maxPos) {
//            int pos = (minPos + maxPos + 1) / 2;
//            if (array[pos] < target) {
//                minPos = pos;
//            } else if (array[pos] > target) {
//                maxPos = pos;
//            } else {
//                return true;
//            }
//        }
//        return false;
//    }


    public static void main(String[] args) {
        Search2DMatrix searchMatrix = new Search2DMatrix();

        int[][] board = new int[3][3];

        board[0][0] = 1;
        board[0][1] = 3;
        board[0][2] = 4;
        board[1][0] = 5;
        board[1][1] = 6;
        board[1][2] = 8;
        board[2][0] = 10;
        board[2][1] = 13;
        board[2][2] = 14;

        System.out.println(searchMatrix.searchMatrix(board, 8));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + ",");
            }
            System.out.println();
        }


    }

}
