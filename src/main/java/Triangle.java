package main.java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import sun.awt.image.ImageWatched.Link;

/**
 * 三角形中，计算最短路径
 */
public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        int[] array = new int[triangle.size()];
        for (int i = 0; i < triangle.size(); i++) {
            List<Integer> list = triangle.get(i);
            for (int j = list.size() - 1; j >= 0; j--) {
                if (j == 0) {
                    array[j] = array[j] + list.get(j);
                    continue;
                }
                if (j == list.size() - 1) {
                    array[j] = array[j-1] + list.get(j);
                    continue;
                }
                array[j] = Math.min(array[j], array[j - 1]) + list.get(j);
            }
        }
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            min = Math.min(min, array[i]);
        }
        return min;

    }

    public static void main(String[] args) {

        List<Integer> list0 = new LinkedList<>();
        list0.add(2);
        List<Integer> list1 = new LinkedList<>();
        list1.add(3);
        list1.add(4);
        List<Integer> list2 = new LinkedList<>();
        list2.add(6);
        list2.add(5);
        list2.add(7);
        List<Integer> list3 = new LinkedList<>();
        list3.add(4);
        list3.add(1);
        list3.add(8);
        list3.add(3);

        List<List<Integer>> list = new LinkedList<>();
        list.add(list0);
        list.add(list1);
        list.add(list2);
        list.add(list3);
        Triangle triangle = new Triangle();

        int sum = triangle.minimumTotal(list);

        System.out.println(sum);

        System.out.println();
    }
}
