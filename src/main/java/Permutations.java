package main.java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 全排列，递归，深度搜索
 */
public class Permutations {

    List<List<Integer>> lists = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean[] useFlag = new boolean[nums.length];
        List<Integer> permutation = new ArrayList<>(nums.length);
        combine(nums, permutation, useFlag);
        return lists;
    }

    public void combine(int[] nums, List<Integer> permutation, boolean[] useFlag) {
        for (int i = 0; i < nums.length; i++) {
            if (useFlag[i]) {
                continue;
            } else {
                permutation.add(nums[i]);
                useFlag[i] = true;
                combine(nums, permutation, useFlag);
                useFlag[i] = false;
                permutation.remove(permutation.size() - 1);
            }
        }
        if (permutation.size() == nums.length) {
            lists.add(new ArrayList<>(permutation));
        }
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        Permutations permutations = new Permutations();
        List<List<Integer>> lists = permutations.permute(nums);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
        System.out.println("hello world");
    }

}
