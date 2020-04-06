package main.java;


/**
 * 最大子序列之和，动态规划
 * 这里的动态规划，每一步只和上一步有关，实际上不需要用数组存储，用常数存储就可以了
 */

public class MaximumSubarray {

    public int maxSubArray(int[] nums) {

        int maxSumArray[] = new int[nums.length];
        int max = nums[0];
        maxSumArray[0] = max;

        for (int i = 1; i < nums.length; i++) {
            if (maxSumArray[i - 1] >= 0) {
                maxSumArray[i] = maxSumArray[i - 1] + nums[i];
            } else{
                maxSumArray[i] = nums[i];
            }
            max = Math.max(max, maxSumArray[i]);
        }

        return max;
    }


    public static void main(String[] args) {
        MaximumSubarray maximumSubarray = new MaximumSubarray();

        int[] array = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maximumSubarray.maxSubArray(array));
    }

}
