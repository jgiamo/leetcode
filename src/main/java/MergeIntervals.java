package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * 合并区间。先排序的话这个问题会简单很多
 */
public class MergeIntervals {


    public int[][] merge(int[][] intervals) {

        if(intervals.length <= 1){
            return intervals;
        }
        List<int[]> result = new LinkedList<>();

        //可以直接使用Arrays.sort函数排序，可以不用申请这个list
        List<int[]> list = new ArrayList<>(intervals.length);
        for (int i = 0; i < intervals.length; i++) {
            list.add(intervals[i]);
        }
        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int rightBoudary = list.get(0)[1];
        result.add(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i)[0] <= rightBoudary) {
                if (list.get(i)[1] > rightBoudary) {
                    rightBoudary = list.get(i)[1];
                    result.get(result.size()-1)[1] = rightBoudary;
                    continue;
                } else {
                    //这种情况直接跳过即可
                    continue;
                }
            }
            result.add(list.get(i));
            rightBoudary = list.get(i)[1];
        }

        int[][] output= new int[result.size()][];
        for(int i = 0;i<result.size();i++){
            output[i] = new int[2];
            output[i][0] = result.get(i)[0];
            output[i][1] = result.get(i)[1];
        }

        return output;
    }

    public static void main(String[] args) {
        MergeIntervals mergeIntervals = new MergeIntervals();

        int arrayA[][] = new int[3][2];
        arrayA[0] = new int[]{1, 3};
        arrayA[1] = new int[]{2, 6};
        arrayA[2] = new int[]{8, 10};

        int[][] array = mergeIntervals.merge(arrayA);

        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }

    }

}
