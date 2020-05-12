package main.java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 杨辉三角
 *
 * 注意下，数字是从1开始，下标是从0开始，所以都是i-2/j-2
 */
public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>(numRows);

        for (int i = 1; i <= numRows; i++) {
            List<Integer> list = new ArrayList<>(numRows);
            for (int j = 1; j <= i; j++) {
                if (j == 1) {
                    list.add(1);
                    continue;
                }
                if (j == i) {
                    list.add(1);
                    continue;
                }
                list.add(result.get(i-2).get(j-2) + result.get(i-2).get(j-1));
            }

            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {

        PascalsTriangle pascalsTriangle = new PascalsTriangle();

        int numRows = 5;
        List<List<Integer>> lists = pascalsTriangle.generate(numRows);

        for (List list : lists) {
            System.out.println(list);
        }
        System.out.println();
    }
}
