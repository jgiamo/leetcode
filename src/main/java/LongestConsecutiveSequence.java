package main.java;


import java.util.HashMap;
import java.util.Map;
import sun.nio.cs.ext.MacHebrew;

/**
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 * 用Map记录当前序列的最大的长度，这里最重要的问题是，只要更新边界数值位置的长度就可以。数值区域内部的的数字没有必要更新
 */
public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                int leftLength = map.getOrDefault(nums[i]-1, 0);
                int rightLength = map.getOrDefault(nums[i] + 1, 0);

                int sumLength = leftLength + rightLength + 1;
                max = Math.max(sumLength, max);

                map.put(nums[i], sumLength);
                map.put(nums[i] - leftLength, sumLength);
                map.put(nums[i] + rightLength, sumLength);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence longestConsecutiveSequence = new LongestConsecutiveSequence();
        System.out.println(
            longestConsecutiveSequence.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }
}
