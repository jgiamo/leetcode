package main.java;

import java.util.Random;

/**
 * 数组中第k大的元素
 */
public class KthLargestElementInAnArray {

    private static Random random = new Random(System.currentTimeMillis());

    public int findKthLargest(int[] nums, int k) {
        return find(nums, k, 0, nums.length - 1);
    }

    public int find(int[] nums, int k, int start, int end) {
        if (end > start) {
            int randomIndex = start + 1 + random.nextInt(end - start);
            int tmp = nums[start];
            nums[start] = nums[randomIndex];
            nums[randomIndex] = tmp;
        }

        //从大到小快排
        while (start < end) {
            if (nums[start] < nums[end]) {
                int tmp = nums[end];
                nums[end] = nums[start + 1];
                nums[start + 1] = nums[start];
                nums[start] = tmp;
                start++;
            } else {
                end--;
            }
        }
        if (start + 1 == k) {
            return nums[start];
        } else if (start + 1 > k) {
            return find(nums, k, 0, start - 1);
        } else {
            return find(nums, k, start + 1, nums.length-1);
        }
    }

    public static void main(String[] args){
        KthLargestElementInAnArray kthLargestElementInAnArray = new KthLargestElementInAnArray();
        System.out.println(kthLargestElementInAnArray.findKthLargest(new int[]{5,2,4,1,3,6,0},4));
    }


}

