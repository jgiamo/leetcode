public class LongestPalindrome {

    public static int expandAroundCenter(String s, int i, int j) {
        while (i >= 0 && j < s.length()) {
            if (s.charAt(i) == s.charAt(j)) {
                i--;
                j++;
            } else {
                break;
            }
        }
        return j - i - 1;
    }


    public static String longestPalindrome(String s) {
        if(s.length() == 0){
            return s;
        }
        int start = 0;
        int end = 0;
        int len = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            if (len1 > len2) {
                if (len < len1) {
                    start = i - len1 / 2;
                    end = i + len1 / 2;
                    len = end - start + 1;
                }
            } else {
                if (len < len2) {
                    start = i - len2 / 2 + 1;
                    end = i + len2 / 2;
                    len = end - start + 1;
                }
            }
        }
        return s.substring(start, end + 1);
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println(longestPalindrome(""));
        System.out.println("hello world");
    }
}
