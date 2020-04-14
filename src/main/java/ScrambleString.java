package main.java;

import java.util.HashMap;
import java.util.Map;

/**
 * 扰乱字符串，用的递归，动态规划没想出来。这题可以重新做下 ***
 */
public class ScrambleString {

    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        if (s1.length() != s2.length()) {
            return false;
        }
        int len = s1.length();
        Map<Character, Integer> map = new HashMap<>();

        for(int i=0;i<len;i++){
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            map.put(c1, map.getOrDefault(c1,0)+1);
            map.put(c2, map.getOrDefault(c2, 0)-1);
        }

        for(Character key : map.keySet()){
            if(map.get(key)!=0){
                return false;
            }
        }

        for (int i = 1; i < len; i++) {
            if (isScramble(s1.substring(0,i), s2.substring(0,i)) && isScramble(s1.substring(i),
                s2.substring(i))) {
                return true;
            }
            if (isScramble(s1.substring(0,i), s2.substring(len - i)) && isScramble(s1.substring(i),
                s2.substring(0, len- i))) {
                return true;
            }

        }

        return false;
    }

    public static void main(String[] args) {

        ScrambleString scrambleString = new ScrambleString();

        System.out.println(scrambleString.isScramble("", ""));

        System.out.println("hello world");
    }
}
