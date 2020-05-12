package main.java;

import java.util.HashMap;
import java.util.Map;

/**
 * 一个数组的主要元素，即个数大于n/2的元素。除了使用HashMap外，摩尔投票法，确实巧妙
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {
        int time = 1;
        int num = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == num) {
                time++;
            } else {
                time--;
            }
            if (time == 0) {
                num = nums[i];
                time = 1;
            }
        }
        return num;
    }

//    public int majorityElement(int[] nums) {
//        Map<Integer, Integer> map = new HashMap<>();
//        int size = nums.length / 2;
//        for (int i = 0; i < nums.length; i++) {
//            if (map.containsKey(nums[i])) {
//                int currentTime = map.get(nums[i]);
//                if (currentTime == size) {
//                    return nums[i];
//                }
//                map.put(nums[i], currentTime + 1);
//            } else {
//                map.put(nums[i], 1);
//            }
//        }
//        return nums[0];
//    }


    public static void main(String[] args) {
        MajorityElement majorityElement = new MajorityElement();

        System.out.println(majorityElement.majorityElement(new int[]{1, 2, 3, 4, 1, 1, 1}));
    }

}
