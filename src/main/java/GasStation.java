package main.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * <p>
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升
 * <p>
 * 找到可以绕圈一周的起点。
 *
 * 一开始只能两次遍历。看了题解后，一次遍历。
 * 感觉不好理解，因为只有唯一解，如果A出发到B，如果不能倒B，那么AB之间的点也不能到B
 */
public class GasStation {


    public int canCompleteCircuit(int[] gas, int[] cost) {

        int[] left = new int[gas.length];
        for (int i = 0; i < gas.length; i++) {
            left[i] = gas[i] - cost[i];
        }

        int currentLeft = 0;
        int sumLeft = 0;
        int startIndex = 0;
        for (int i = 0; i < left.length; i++) {
            currentLeft = currentLeft + left[i];
            sumLeft = sumLeft + left[i];
            if (currentLeft < 0) {
                startIndex = i + 1;
                currentLeft = 0;
            }
        }
        return sumLeft>=0? startIndex : -1 ;
    }


    public static void main(String[] args) {
        GasStation gasStation = new GasStation();

        System.out.println(
            gasStation.canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));


    }

}
