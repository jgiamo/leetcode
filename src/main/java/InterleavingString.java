package main.java;

import java.util.LinkedList;
import java.util.List;

/**
 * 字符串是否由另外两个字符串交错组成。
 * 动态规划或者递归
 */
public class InterleavingString {

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }
        int m = s1.length();
        int n = s2.length();
        boolean[][] array = new boolean[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 & j == 0) {
                    array[i][j] = true;
                } else if (i == 0) {
                    array[i][j] = array[i][j - 1] && (s2.charAt(j - 1) == s3.charAt(i + j - 1));
                } else if (j == 0) {
                    array[i][j] = array[i - 1][j] && (s1.charAt(i - 1) == s3.charAt(i + j - 1));
                } else {
                    array[i][j] =
                        (array[i][j - 1] && (s2.charAt(j - 1) == s3.charAt(i + j - 1))) || (
                            array[i - 1][j] && (s1.charAt(i - 1) == s3.charAt(i + j - 1)));
                }
            }
        }
        return array[m][n];

    }

//    public boolean isInterleave(String s1, String s2, String s3) {
//        if (s3.length() != s1.length() + s2.length()) {
//            return false;
//        }
//        return trace(s1,s2,s3,0,0,0);
//
//    }
//
//    public boolean trace(String s1, String s2, String s3, int i, int j, int k) {
//        if (k >= s3.length()) {
//            return true;
//        }
//        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
//            if (trace(s1, s2, s3, i + 1, j, k + 1)) {
//                return true;
//            }
//        }
//        if (j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
//            if (trace(s1, s2, s3, i, j + 1, k + 1)) {
//                return true;
//            }
//        }
//        return false;
//    }


    public static void main(String[] args) {
        InterleavingString interleavingString = new InterleavingString();

        System.out.println(interleavingString.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
    }

}
