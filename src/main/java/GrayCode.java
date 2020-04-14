package main.java;

import java.util.LinkedList;
import java.util.List;

/**
 * 格雷码
 */
public class GrayCode {

    public List<Integer> grayCode(int n) {
        List<Integer> result = new LinkedList<>();
        result.add(0);
        int head = 1;
        for (int i = 1; i <= n; i++) {
            int len = result.size();
            for (int j = len - 1; j >=0; j--) {
                result.add(result.get(j) + head);
            }
            head <<= 1;
        }
        return result;
    }

    public static void main(String[] args) {

        GrayCode grayCode = new GrayCode();

        List<Integer> list = grayCode.grayCode(3);

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }

    }
}
