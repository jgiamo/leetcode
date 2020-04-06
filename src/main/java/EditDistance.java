package main.java;

import java.util.Stack;

/**
 * 将一个单词转化成另一个单词的最少步数
 * 动态规划
 */
public class EditDistance {

    public int minDistance(String word1, String word2) {
        int lenA = word1.length();
        int lenB = word2.length();
        int[][] distance = new int[lenA+1][lenB+1];
        for (int i = 1; i <= lenA; i++) {
            distance[i][0] = distance[i-1][0] + 1;
        }
        for (int j = 1; j <= lenB; j++) {
            distance[0][j] = distance[0][j - 1] + 1;
        }
        for (int i = 1; i <= lenA; i++) {
            for (int j = 1; j <= lenB; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    distance[i][j] = distance[i - 1][j - 1] ;
                } else {
                    distance[i][j] = Math.min(Math.min(distance[i - 1][j - 1], distance[i - 1][j]),
                        distance[i][j - 1]) + 1;
                }
            }
        }
        return distance[lenA][lenB];
    }

    public static void main(String[] args) {
        EditDistance editDistance = new EditDistance();

        System.out.println(editDistance.minDistance("horse", "ros"));

    }

}
