package main.java;

import java.util.LinkedList;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> list = new LinkedList<>();

        backtrack(result, list, candidates, target, 0, 0);

        return result;
    }

    public void backtrack(List<List<Integer>> result, List<Integer> list, int[] candidates,
        int target, int startIndex, int sum) {

        if(sum == target){
            result.add(new LinkedList<>(list));
            return;
        }

        for(int i= startIndex; i < candidates.length;i++){
            list.add(candidates[i]);
            if(sum + candidates[i] <= target){
                backtrack(result, list, candidates, target, i, sum + candidates[i]);
            }
            list.remove(list.size() - 1);
        }

    }

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        int[] candidates = new int[]{4, 5, 6, 3, 7};
        int target = 15;
        List<List<Integer>> list = combinationSum.combinationSum(candidates, target);

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            System.out.println();
        }
        System.out.println("hello world");
    }

}
