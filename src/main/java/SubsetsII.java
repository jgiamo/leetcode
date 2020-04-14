package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 求子集,用递归实现，对于解决重复的问题，一个方法是记录当前层用过的数字，并且数组一开始要排序好。如果不排序，那还是有可能出现重复
 */
public class SubsetsII {


    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);

            addSubsets(result, new ArrayList<>(), nums, 0);

        return result;
    }

    public void addSubsets(List<List<Integer>> result, List<Integer> list, int[] nums, int startPos) {
        result.add(new ArrayList<>(list));

        for (int i = startPos; i < nums.length; i++) {
            if (i > startPos && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            addSubsets(result, list, nums, i + 1);
            list.remove(list.size() - 1);

        }
        return;

    }


    public static void main(String[] args) {
        SubsetsII subsetsII = new SubsetsII();

        int[] nums = new int[]{4, 4, 4, 1, 4};
        List<List<Integer>> lists = subsetsII.subsetsWithDup(nums);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

}
