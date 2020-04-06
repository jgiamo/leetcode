package main.java;

import java.util.LinkedList;
import java.util.List;

/**
 * easy 爬楼梯，一次爬1或者2阶梯，总共有多少种爬法
 */
public class Subsets {

    List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;
        for (int k = 0; k <= len; k++) {
            List<Integer> list = new LinkedList<>();
            backtrack(list, nums, 0, k, 0);
        }
        return result;
    }

    public void backtrack(List<Integer> list, int[] nums, int start, int k, int currentLen) {
        if (currentLen == k) {
            result.add(new LinkedList<>(list));
        }
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            backtrack(list, nums, i + 1, k, currentLen + 1);

            list.remove(list.size() - 1);
        }
    }


    public static void main(String[] args) {
        Subsets subsets = new Subsets();

        int[] nums = new int[]{3, 4, 5, 6, 7};
        List<List<Integer>> lists = subsets.subsets(nums);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

}
