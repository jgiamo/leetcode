package main.java;

import java.util.ArrayList;
import java.util.List;

/**
 * 一个数组的主要元素，个数大于n/3的元素。
 *
 * 如果只是求其中一个元素，投票法每次加2就行了。
 * 现在要求两个元素，使用了这个方法，感觉没有完全弄明白。需要重复刷下     *****
 */
public class MajorityElementII {

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if(nums==null || nums.length==0){
            return result;
        }
        int firstNum = nums[0];
        int firstTime = 0;

        int secondNum = nums[0];
        int secondTime = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == firstNum) {
                firstTime++;
                continue;
            }
            if (nums[i] == secondNum) {
                secondTime++;
                continue;
            }
            if (firstTime == 0) {
                firstNum = nums[i];
                firstTime++;
                continue;
            }
            if (secondTime == 0) {
                secondNum = nums[i];
                secondTime++;
                continue;
            }
            firstTime--;
            secondTime--;
        }
        secondTime = 0;
        firstTime = 0;
        for (int num : nums) {
            if (num == firstNum) {
                firstTime++;
            } else if (num == secondNum) {
                secondTime++;
            }
        }
        if (firstTime > nums.length / 3) {
            result.add(firstNum);
        }
        if (secondTime > nums.length / 3) {
            result.add(secondNum);
        }
        return result;


    }


    public static void main(String[] args) {
        MajorityElementII majorityElement = new MajorityElementII();

        System.out.println(majorityElement.majorityElement(new int[]{2,2,1,3}));
    }

}
