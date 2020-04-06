package main.java;

import java.util.LinkedList;
import java.util.List;

/**
 * easy 爬楼梯，一次爬1或者2阶梯，总共有多少种爬法
 */
public class Combinations {

    List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        List<Integer> list = new LinkedList<>();
        dfs(list, 1, n, k, 0);

        return result;
    }

    public void dfs(List<Integer> list, int start, int n, int k, int currentLen) {
        if (currentLen == k) {
            result.add(new LinkedList<>(list));
            return;
        }
        for (int i = start; i <= n; i++) {
            list.add(i);
            dfs(list, i + 1, n, k, currentLen + 1);
            list.remove(list.size()-1);
        }
    }


    public static void main(String[] args) {
        Combinations combinations = new Combinations();

        List<List<Integer>> lists = combinations.combine(4, 2);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

}
