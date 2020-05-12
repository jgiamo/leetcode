package main.java;

import java.util.Stack;

/**
 * 最大子数组乘机
 */
public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        if(nums.length<=0){
            return 0;
        }
        int max=nums[0];
        int currentMax = nums[0], currentMin=nums[0];
        for(int i=1;i<nums.length;i++){
            int temp = currentMax;
            currentMax = Math.max(currentMax*nums[i],Math.max(currentMin*nums[i], nums[i]));
            currentMin = Math.min(temp*nums[i],Math.min(currentMin*nums[i], nums[i]));
            max = Math.max(currentMax, max);
        }
        return max;
    }

    public static void main(String[] args) {


        MaximumProductSubarray maximumProductSubarray = new MaximumProductSubarray();
        maximumProductSubarray.maxProduct(new int[]{2,3,4,1,-1,3});


    }

}
