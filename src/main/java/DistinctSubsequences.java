package main.java;


/**
 * 计算字符串s的子序列中t出现的个数。
 */
public class DistinctSubsequences {


    public int numDistinct(String s, String t) {
        int[][] array = new int[t.length() + 1][s.length() + 1];

        for (int j = 0; j <= s.length(); j++) {
            array[0][j] = 1;
        }

        for (int i = 1; i <= t.length(); i++) {
            for (int j = i; j <= s.length(); j++) {
                array[i][j] = array[i][j - 1];
                if (s.charAt(j - 1) == t.charAt(i - 1)) {
                    array[i][j] = array[i][j] + array[i - 1][j - 1];
                }
            }
        }
        return array[t.length()][s.length()];
    }

    public static void main(String[] args) {

        DistinctSubsequences distinctSubsequences = new DistinctSubsequences();

        System.out.println(distinctSubsequences.numDistinct("rabbbit", "rabbit"));

        System.out.println("hello world");
    }

}
