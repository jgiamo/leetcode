package main.java;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定字符串，将字符串还原成ip地址。回溯法
 */
public class RestoreIPAddresses {

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new LinkedList<>();

        generateAddress(result, new StringBuilder(), s, 0, 0);

        return result;
    }

    public void generateAddress(List<String> result, StringBuilder currentStr, String s,
        int startPos, int time) {

        if (time == 4 && startPos == s.length()) {
            result.add(new String(currentStr.substring(0, currentStr.length() - 1)));
            return;
        }
        if (time >= 4 || startPos >= s.length()) {
            return;
        }

        currentStr.append(s.charAt(startPos)).append(".");
        generateAddress(result, currentStr, s, startPos + 1, time + 1);
        currentStr.delete(currentStr.length() - 2, currentStr.length());

        if (startPos + 2 <= s.length() && s.charAt(startPos) != '0') {
            currentStr.append(s.substring(startPos, startPos + 2)).append(".");
            generateAddress(result, currentStr, s, startPos + 2, time + 1);
            currentStr.delete(currentStr.length() - 3, currentStr.length());
        }

        if (startPos + 3 <= s.length() && s.charAt(startPos) != '0'
            && Integer.valueOf(s.substring(startPos, startPos + 3)) <= 255) {
            currentStr.append(s.substring(startPos, startPos + 3)).append(".");
            generateAddress(result, currentStr, s, startPos + 3, time + 1);
            currentStr.delete(currentStr.length() - 4, currentStr.length());
        }

    }

    public static void main(String[] args) {
        RestoreIPAddresses restoreIPAddresses = new RestoreIPAddresses();
        List<String> list = restoreIPAddresses.restoreIpAddresses("010010");

        for (String l : list) {
            System.out.println(l);
        }

        System.out.println(Integer.valueOf("02"));
    }

}
