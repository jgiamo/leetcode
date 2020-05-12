package main.java;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角,从后往前，这样就可以只用一个数组
 */
public class PascalsTriangleII {

    //这里的rowIndex从0开始
//    public List<Integer> getRow(int rowIndex) {
//        List<List<Integer>> result = new ArrayList<>(rowIndex);
//
//        for (int i = 0; i <= rowIndex; i++) {
//            List<Integer> list = new ArrayList<>(rowIndex);
//            for (int j = 0; j <= i; j++) {
//                if (j == 0) {
//                    list.add(1);
//                    continue;
//                }
//                if (j == i) {
//                    list.add(1);
//                    continue;
//                }
//                list.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
//            }
//
//            result.add(list);
//        }
//        return result.get(rowIndex);
//    }
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            for (int j = i - 1; j > 0; j--) {
                result.set(j, result.get(j) + result.get(j - 1));
            }
            result.add(1);
        }

        return result;
    }

    public static void main(String[] args) {

        PascalsTriangleII pascalsTriangleII = new PascalsTriangleII();

        int numRow = 5;
        List<Integer> list = pascalsTriangleII.getRow(numRow);

        System.out.println(list);

        System.out.println();
    }
}
