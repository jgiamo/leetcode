package main.java;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * <p>
 * 这道题如果没有上面一题承接就有些难了。   ***
 */
public class WordBreakII {


    public List<String> wordBreak(String s, List<String> wordDict) {

        Set<String> wordSet = new HashSet<>(wordDict);
        List<String> result = new LinkedList<>();
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        if (!dp[s.length()]) {
            return result;
        }

        LinkedList<String> wordList = new LinkedList<>();
        dfs(result, s, s.length(), wordSet, dp, wordList);

        return result;

    }

    public void dfs(List<String> result, String s, int endIndex, Set<String> wordSet, boolean[] dp,
        LinkedList<String> matchList) {

        if (wordSet.contains(s.substring(0, endIndex))) {
            matchList.addFirst(s.substring(0, endIndex));

            StringBuilder stringBuilder = new StringBuilder();
            for (String word : matchList) {
                stringBuilder.append(word);
                stringBuilder.append(" ");
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            result.add(stringBuilder.toString());

            matchList.removeFirst();

        }
        for (int i = 1; i <= endIndex; i++) {
            if (dp[i]) {
                String str = s.substring(i, endIndex);
                if (wordSet.contains(str)) {
                    matchList.addFirst(str);
                    dfs(result, s, i, wordSet, dp, matchList);
                    matchList.removeFirst();
                }
            }
        }
    }

    public static void main(String[] args) {

        WordBreakII wordBreakII = new WordBreakII();

        wordBreakII.wordBreak("sas", new LinkedList<>());

        System.out.println("hello world");
    }

}
