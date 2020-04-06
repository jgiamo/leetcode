package main.java;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import sun.awt.image.ImageWatched.Link;

public class CombinationSum2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<>();

        List<Integer> list = new LinkedList<>();

        Arrays.sort(candidates);

        backtrack(result, list, candidates, target, 0, 0);

        return result;
    }

    public void backtrack(List<List<Integer>> result, List<Integer> list, int[] candidates,
        int target, int startIndex, int sum) {

        if (sum == target) {
            result.add(new LinkedList<>(list));
            return;
        }


        for (int i = startIndex; i < candidates.length; i++) {

            // i>startIndex,代表在这层中只有i==startIndex的情况，而避免重复
            if (i > startIndex && i - 1 >= 0 && candidates[i - 1] == candidates[i]) {
                continue;
            }
            list.add(candidates[i]);
            if (sum + candidates[i] <= target) {
                backtrack(result, list, candidates, target, i + 1, sum + candidates[i]);
            }
            list.remove(list.size() - 1);
        }

    }


    public static void main(String[] args) {
        CombinationSum2 combinationSum = new CombinationSum2();
        int[] candidates = new int[]{10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> list = combinationSum.combinationSum2(candidates, target);

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            System.out.println();
        }
        System.out.println("hello world");
    }

}
