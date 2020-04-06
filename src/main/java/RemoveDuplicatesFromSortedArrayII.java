package main.java;

import java.util.LinkedList;
import java.util.List;

/**
 * 删除有序数组中，重复出现超过2次的元素。每个元素最多出现2次
 */
public class RemoveDuplicatesFromSortedArrayII {

    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        int currentIndex = 1;

        int preNum = nums[0];
        int currentNumAppearTime = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == preNum) {
                currentNumAppearTime++;
            } else {
                preNum = nums[i];
                currentNumAppearTime = 1;
            }


            if (currentNumAppearTime <= 2) {
                nums[currentIndex++] = nums[i];
            }

        }
        return currentIndex;

    }


    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArrayII removeDuplicatesFromSortedArrayII = new RemoveDuplicatesFromSortedArrayII();

        int[] array = new int[]{0, 0, 1, 1, 1, 3, 3, 3, 3, 4};
        int len = removeDuplicatesFromSortedArrayII.removeDuplicates(array);

        for (int i = 0; i < len; i++) {
            System.out.print(array[i]);
            System.out.print(" ");
        }
        System.out.println("hello world");
    }

}
