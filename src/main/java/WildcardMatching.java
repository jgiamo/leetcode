package main.java;

public class WildcardMatching {

    /**
     * 动态规划，0行0列代表空串匹配
     */
    public boolean isMatch(String s, String p) {
        int lenStr = s.length();
        int lenPattern = p.length();
        boolean flag[][] = new boolean[lenStr + 1][];
        for (int i = 0; i < lenStr + 1; i++) {
            flag[i] = new boolean[lenPattern + 1];
        }
        //空串匹配
        flag[0][0] = true;
        for (int j = 1; j < lenPattern + 1; j++) {
            flag[0][j] = flag[0][j-1] && (p.charAt(j - 1) == '*');
        }

        for (int i = 1; i < lenStr + 1; i++) {
            for (int j = 1; j < lenPattern + 1; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    flag[i][j] = flag[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    flag[i][j] = flag[i - 1][j] || flag[i][j - 1];
                }
            }
        }
        return flag[lenStr][lenPattern];
    }


    /**
     * 递归方法不过超时了
     */
    public boolean isMatch2(String s, String p) {

        int lenStr = s.length();
        int lenPattern = p.length();
        return match(s, lenStr - 1, p, lenPattern - 1);
    }

    public boolean match(String s, int sPos, String p, int pPos) {
        if (sPos == -1 && pPos == -1) {
            return true;
        } else if (pPos == -1) {
            return false;
        } else if (sPos == -1) {
            boolean flag = true;
            for (int i = 0; i <= pPos; i++) {
                flag = flag && (p.charAt(i) == '*');
            }
            return flag;
        }

        if (s.charAt(sPos) == p.charAt(pPos) || p.charAt(pPos) == '?') {
            return match(s, sPos - 1, p, pPos - 1);
        } else if (p.charAt(pPos) == '*') {
            return match(s, sPos - 1, p, pPos) || match(s, sPos, p, pPos - 1);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String s = "mississippi";
        String p = "m??*ss*?i*pi";

        WildcardMatching wildcardMatching = new WildcardMatching();
        System.out.println(wildcardMatching.isMatch(s, p));
    }

}
