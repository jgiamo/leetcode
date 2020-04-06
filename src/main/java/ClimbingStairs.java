package main.java;

/**
 * easy
 * 爬楼梯，一次爬1或者2阶梯，总共有多少种爬法
 */
public class ClimbingStairs {

    public int climbStairs(int n) {
        int[] array = new int[n + 1];
        array[0] = 1;
        array[1] = 1;
        for (int i = 2; i <= n; i++) {
            array[i] = array[i - 2] + array[i - 1];
        }
        return array[n];
    }


    public static void main(String[] args) {
        ClimbingStairs climbingStairs = new ClimbingStairs();

        System.out.println(climbingStairs.climbStairs(3));

    }

}
