package main.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 */
public class PalindromePartitioning {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }

        List<String> list = new ArrayList<>();
        traceStr(result, list, 0, s);
        return result;
    }


    public void traceStr(List<List<String>> result, List<String> list, int startIndex, String s) {
        if (startIndex == s.length()) {
            result.add(new ArrayList<>(list));
            return;
        }
        List<String> palindromeList = getPalindromeAtFirstIndex(startIndex, s);
        for (int i = 0; i < palindromeList.size(); i++) {
            String prefix = palindromeList.get(i);
            list.add(prefix);
            traceStr(result, list, startIndex + prefix.length(), s);
            list.remove(list.size() - 1);
        }

    }

    Map<Integer, List<String>> map = new HashMap<>();

    public List<String> getPalindromeAtFirstIndex(int startIndex, String s) {
        if (map.containsKey(startIndex)) {
            return map.get(startIndex);
        }
        List<String> palindromeList = new ArrayList<>();

        for (int i = startIndex; i < s.length(); i++) {
            int startPox = startIndex;
            int endPos = i;
            boolean flag = true;
            while (startPox <= endPos) {
                if (s.charAt(startPox) == s.charAt(endPos)) {
                    startPox++;
                    endPos--;
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                palindromeList.add(s.substring(startIndex, i+1));
            }

        }
        return palindromeList;

    }


    public static void main(String[] args) {
        PalindromePartitioning palindromePartitioning = new PalindromePartitioning();

        List<List<String>> lists = palindromePartitioning.partition("aab");

        for (List<String> list : lists) {
            System.out.println(list);
        }


    }

}
