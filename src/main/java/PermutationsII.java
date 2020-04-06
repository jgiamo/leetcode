package main.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 全排列，递归，深度搜索，去重
 */
public class PermutationsII {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> lists = new LinkedList<>();

        boolean[] useFlag = new boolean[nums.length];
        List<Integer> permutation = new ArrayList<>();
        DFS(lists, nums, permutation, useFlag);
        return lists;
    }

    public void DFS(List<List<Integer>> lists, int[] nums, List<Integer> permutation,
        boolean[] useFlag) {
        if (nums.length == permutation.size()) {
            lists.add(new ArrayList<>(permutation));
        }

        //这一层中，使用过的数字记录
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (useFlag[i]) {
                continue;
            } else {
                if(map.containsKey(nums[i])){
                    continue;
                } else{
                    map.put(nums[i], true);
                }
                permutation.add(nums[i]);
                useFlag[i] = true;

                DFS(lists, nums, permutation, useFlag);

                useFlag[i] = false;
                permutation.remove(permutation.size() - 1);

            }
        }
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 3};
        PermutationsII permutations = new PermutationsII();
        List<List<Integer>> lists = permutations.permuteUnique(nums);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
        System.out.println("hello world");
    }

}
