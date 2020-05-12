package main.java;

import java.math.BigInteger;

/**
 *
 */
public class MaxPointsOnALine {

    public int maxPoints(int[][] points) {
        if (points.length < 3) {
            return points.length;
        }

        int i = 0;
        for (; i < points.length - 1; i++) {
            if (points[i][0] != points[i + 1][0] || points[i][1] != points[i + 1][1]) {
                break;
            }
        }
        if (i == points.length - 1) {
            return points.length;
        }
        int maxSum = 2;
        for (i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if (points[i][0] == points[j][0] && points[i][1] == points[j][1]) {
                    continue;
                }
                int sum = 2;
                for (int k = 0; k < points.length; k++) {
                    if (k == i || k == j) {
                        continue;
                    }
                    if (isLine(points[i][0], points[i][1], points[j][0], points[j][1], points[k][0],
                        points[k][1])) {
                        sum++;
                    }
                }
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }

    public boolean isLine(int x1, int y1, int x2, int y2, int x3, int y3) {
        BigInteger bigIntegerX1 = BigInteger.valueOf(x1);
        BigInteger bigIntegerY1 = BigInteger.valueOf(y1);
        BigInteger bigIntegerX2 = BigInteger.valueOf(x2);
        BigInteger bigIntegerY2 = BigInteger.valueOf(y2);
        BigInteger bigIntegerX3 = BigInteger.valueOf(x3);
        BigInteger bigIntegerY3 = BigInteger.valueOf(y3);

        return bigIntegerY2.subtract(bigIntegerY1).multiply(bigIntegerX3.subtract(bigIntegerX2))
            .equals(
                bigIntegerY3.subtract(bigIntegerY2).multiply(bigIntegerX2.subtract(bigIntegerX1)));
    }

    public static void main(String[] args) {

        int[][] points = new int[3][2];
        points[0] = new int[]{1, 1};
        points[1] = new int[]{2, 2};
        points[2] = new int[]{3, 3};

        MaxPointsOnALine maxPointsOnALine = new MaxPointsOnALine();
        maxPointsOnALine.maxPoints(points);

    }

}
