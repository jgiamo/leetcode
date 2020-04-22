package main.java;


/**
 * 计算字符串s的子序列中t出现的个数。
 */
public class DistinctSubsequences {

    int num = 0;

    public int numDistinct(String s, String t) {

        return num;
    }

    public int trace(String s, String t, int sPos, int tPos, int currentLen) {
        int leftLength = s.length() - (t.length() - currentLen);
        for (int i = sPos; i <= leftLength; i++) {
            if()
        }
    }

    public static void main(String[] args) {

        DistinctSubsequences distinctSubsequences = new DistinctSubsequences();

        System.out.println(distinctSubsequences.numDistinct("", ""));

        System.out.println("hello world");
    }

}
