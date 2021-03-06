package main.java;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class HouseRobber {

    public int rob(int[] nums) {
        if(nums.length<1){
            return 0;
        }
        int[] dp = new int[nums.length+1];
        dp[0]=0;dp[1]=nums[0];

        for(int i=1;i<nums.length;i++){
            dp[i+1]=Math.max(nums[i]+dp[i-1],dp[i]);
        }
        return dp[nums.length];
    }


}
