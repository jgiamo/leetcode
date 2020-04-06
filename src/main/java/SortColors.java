package main.java;

import java.util.Arrays;

/**
 * 对颜色排序，相同颜色的数字放在一起。希望通过一次遍历达成
 * 思路和快排有点像
 */
public class SortColors {

    public void sortColors(int[] nums) {
        int posA = 0;
        int posB = nums.length - 1;
        int i = posA;
        while(i <= posB){
            if (nums[i] == 0) {
                swap(nums, i, posA);
                i++;
                posA++;
            } else if (nums[i] == 2) {
                swap(nums,i ,posB);
                posB--;
            } else {
                i++;
                continue;
            }
        }
    }

    public void swap(int[] nums, int posA, int posB) {
        int tmp = nums[posA];
        nums[posA] = nums[posB];
        nums[posB] = tmp;
    }

//    public void sortColors(int[] nums) {
//        int[] size = new int[3];
//        for (int i = 0; i < nums.length; i++) {
//            size[nums[i]]++;
//        }
//        int j = 0;
//        for (int i = 0; i < size.length; i++) {
//            for(int k=0;k<size[i];k++) {
//                nums[j++] = i;
//            }
//        }
//    }


    public static void main(String[] args) {
        SortColors sortColors = new SortColors();

        int[] array = new int[]{2, 0, 2, 1, 1, 0, 0};
        sortColors.sortColors(array);
        System.out.println(Arrays.toString(array));

    }

}
