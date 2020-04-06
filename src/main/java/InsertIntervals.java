package main.java;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 插入区间，这道题花了很多时间，最关键是需要想清楚。
 * 这里分为三个阶段。第一阶段，第三阶段，分别是插入区间没有覆盖到的部分
 * 第二阶段，就是要循环判断这个合并区间的边界
 */
public class InsertIntervals {


    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> result = new LinkedList<>();
        int i = 0;

        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i++]);
        }

        int leftPosition = newInterval[0];
        int rightPosition =  newInterval[1];
        if (i < intervals.length) {
            if (intervals[i][0] < leftPosition) {
                leftPosition = intervals[i][0];
            }
            while (i < intervals.length) {
                if (newInterval[1] < intervals[i][0]) {
                    break;
                }
                if (newInterval[1] >= intervals[i][0] && newInterval[1] <= intervals[i][1]) {
                    rightPosition = intervals[i][1];
                    i++;
                    break;
                }
                i++;
            }
        }

        result.add(new int[]{leftPosition, rightPosition});

        while (i < intervals.length && intervals[i][0] > newInterval[1]) {
            result.add(intervals[i++]);
        }

        int[][] output = new int[result.size()][];
        for (int j = 0; j < result.size(); j++) {
            output[j] = new int[2];
            output[j][0] = result.get(j)[0];
            output[j][1] = result.get(j)[1];
        }
        return output;

    }

    public static void main(String[] args) {
        InsertIntervals insertIntervals = new InsertIntervals();

        int arrayA[][] = new int[3][2];
        arrayA[0] = new int[]{1, 3};
        arrayA[1] = new int[]{4, 6};
        arrayA[2] = new int[]{8, 10};

        int[][] array = insertIntervals.insert(arrayA, new int[]{4, 10});

        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }

    }

}
