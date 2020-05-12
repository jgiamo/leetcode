package main.java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * 将一个单词在给定集合中一步一步转化成另一个单词，求最短路径的长度，比起上一题简单很多 层序遍历，是对于BFS的好工具
 */
public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        Set<String> wordSet = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        int minPath = 1;
        while (!queue.isEmpty()) {
            minPath++;

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String lastWord = queue.poll();
                List<String> matchWordList = getNeighbor(lastWord, wordSet);
                for (String matchWord : matchWordList) {
                    if (visited.contains(matchWord)) {
                        continue;
                    }
                    if (matchWord.equals(endWord)) {
                        return minPath + 1;
                    }
                    queue.add(matchWord);
                    visited.add(matchWord);
                }
            }
        }
        return 0;
    }

    public List<String> getNeighbor(String word, Set<String> dict) {
        List<String> nextWordList = new ArrayList<>();
        char[] array = word.toCharArray();
        for (int i = 0; i < array.length; i++) {
            char oldChar = array[i];
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (ch == oldChar) {
                    continue;
                }
                array[i] = ch;
                if (dict.contains(String.valueOf(array))) {
                    nextWordList.add(String.valueOf(array));
                }
            }
            array[i] = oldChar;

        }
        return nextWordList;
    }

//    public boolean check(String word1, String word2) {
//        String key1 = word1 + word2;
//        if (chechMap.containsKey(key1)) {
//            return chechMap.get(key1);
//        }
//        int len = word1.length();
//        int error = 0;
//        boolean flag = true;
//        for (int i = 0; i < len; i++) {
//            if (word1.charAt(i) != word2.charAt(i)) {
//                if (++error > 1) {
//                    flag = false;
//                    break;
//                }
//            }
//        }
//        String key2 = word2 + word1;
//        chechMap.put(key1, flag);
//        chechMap.put(key2, flag);
//        return flag;
//    }
//
//    List<List<String>> result = new LinkedList<>();

//
//    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
//        List<String> list = new LinkedList<>();
//        if(!wordList.contains(endWord)){
//            return result;
//        }
//        boolean [] used = new boolean[wordList.size()];
//        list.add(beginWord);
//        trace(list, used, beginWord, endWord, wordList);
//        return result;
//    }
//
//    public void trace(
//        List<String> list,
//        boolean[] used,
//        String currentWord,
//        String endWord,
//        List<String> wordList) {
//
//        if (check(currentWord, endWord)) {
//            list.add(endWord);
//            if (result.size() == 0) {
//                result.add(new ArrayList<>(list));
//            } else if (result.get(0).size() > list.size()) {
//                result.clear();
//                result.add(new ArrayList<>(list));
//            } else if (result.get(0).size() == list.size()) {
//                result.add(new ArrayList<>(list));
//            }
//            list.remove(list.size()-1);
//            return;
//
//        }
//        for (int i = 0; i < wordList.size(); i++) {
//            if (used[i]) {
//                continue;
//            }
//            if (check(currentWord, wordList.get(i))) {
//                used[i] = true;
//                list.add(wordList.get(i));
//                trace(list, used, wordList.get(i), endWord, wordList);
//                list.remove(list.size() - 1);
//                used[i] = false;
//            }
//        }
//    }

    public static void main(String[] args) {
        WordLadder wordLadder = new WordLadder();
        List<String> wordList = new LinkedList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        wordLadder.ladderLength("hit", "cog", wordList);

    }
}
