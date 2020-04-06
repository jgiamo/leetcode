package main.java;

import java.util.HashMap;
import java.util.Map;

public class FirstMissingPositive {

    //空间太多
//    public int firstMissingPositive(int[] nums) {
//        Map<Integer, Boolean> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] <= 0) {
//                continue;
//            }
//            map.put(nums[i], true);
//        }
//        int missNum = 1;
//        for (; missNum < Integer.MAX_VALUE; missNum++) {
//            if (map.containsKey(missNum)) {
//                continue;
//            } else {
//                break;
//            }
//        }
//        return missNum;
//    }

    public int firstMissingPositive(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] <= 0) {
                i++;
            } else if (nums[i] > nums.length) {
                i++;
            } else if (nums[i] == i + 1) {
                i++;
            } else {
                int changePos = nums[i]-1;
                if(nums[changePos] == nums[i]){
                    i++;
                    continue;
                }
                int tmp = nums[i];
                nums[i] = nums[changePos];
                nums[changePos] = tmp;
            }
        }

        for (i = 0; i < nums.length; i++) {
            if (nums[i] == i + 1) {
                continue;
            } else {
                break;
            }
        }
        return i+1;
    }


    public static void main(String[] args) {
        int[] array = new int[]{1, 1};
        FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
        System.out.println(firstMissingPositive.firstMissingPositive(array));

        System.out.println();
    }
}
