package main.java;

/**
 * 在m*n的网格中，从左上角移动到右下脚有多少步，但是网格中可能存在障碍物
 * 动态规划
 */
public class UniquePathsII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            result[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            }
            result[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(obstacleGrid[i][j] != 1){
                    result[i][j] = result[i][j-1] + result[i-1][j];
                }
            }
        }

        return result[m-1][n-1];

    }



    public static void main(String[] args) {
        UniquePathsII uniquePathsII = new UniquePathsII();
        int[][] a = new int[3][3];
        a[0][0] = 0;
        a[0][1] = 0;
        a[0][2] = 0;

        a[1][0] = 0;
        a[1][1] = 1;
        a[1][2] = 0;

        a[2][0] = 0;
        a[2][1] = 0;
        a[2][2] = 0;
        System.out.println(uniquePathsII.uniquePathsWithObstacles(a));
        System.out.println("hello world");
    }

}
