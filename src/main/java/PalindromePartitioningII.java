package main.java;


/**
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。求最少的分割次数。 ***
 * 这种题目就不能想着用递归回溯的方法。得用dp去解决。这道题两种动态规划，
 * 第一种是dp[i]表示s(0-i)的最小分割次数，
 * 第二种是判断内部所有的子串是否是会问子串用。dp[left][right],这里需要考虑遍历的顺序，是反直觉的
 */
public class PalindromePartitioningII {

    public int minCut(String s) {
        if (s.length() <= 1) {
            return 0;
        }

        int[] dp = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i] = i;
        }

        boolean[][] isPalindrome = new boolean[s.length()][s.length()];

        for(int right = 0;right<s.length();right++){
            for(int left = 0; left <= right;left++){
                if(s.charAt(left) == s.charAt(right) && (right-left <=2 || isPalindrome[left+1][right-1])){
                    isPalindrome[left][right] = true;
                }
            }
        }

        for (int i = 1; i < s.length(); i++) {
            if (isPalindrome[0][i]) {
                dp[i] = 0;
                continue;
            }
            for (int j = 1; j <= i; j++) {
                //在最坏的情况下，j=i，一定会走这个if，单个字符也是回文的。
                if (isPalindrome[j][i]) {
                    dp[i] = Math.min(dp[j-1] + 1, dp[i]);
                }
            }
        }

        return dp[s.length()-1];
    }

    public boolean checkPalindrome(String s, int startIndex, int endIndex) {
        while (startIndex <= endIndex) {
            if (s.charAt(startIndex++) != s.charAt(endIndex--)) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        PalindromePartitioningII palindromePartitioningII = new PalindromePartitioningII();
        System.out.println(palindromePartitioningII.minCut(
            "aab"));
    }
//        System.out.println(palindromePartitioningII.minCut(
//            "apjesgpsxoeiokmqmfgvjslcjukbqxpsobyhjpbgdfruqdkeiszrlmtwgfxyfostpqczidfljwfbbrflkgdvtytbgqalguewnhvvmcgxboycffopmtmhtfizxkmeftcucxpobxmelmjtuzigsxnncxpaibgpuijwhankxbplpyejxmrrjgeoevqozwdtgospohznkoyzocjlracchjqnggbfeebmuvbicbvmpuleywrpzwsihivnrwtxcukwplgtobhgxukwrdlszfaiqxwjvrgxnsveedxseeyeykarqnjrtlaliyudpacctzizcftjlunlgnfwcqqxcqikocqffsjyurzwysfjmswvhbrmshjuzsgpwyubtfbnwajuvrfhlccvfwhxfqthkcwhatktymgxostjlztwdxritygbrbibdgkezvzajizxasjnrcjwzdfvdnwwqeyumkamhzoqhnqjfzwzbixclcxqrtniznemxeahfozp"));
//    }

}
