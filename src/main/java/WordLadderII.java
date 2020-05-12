package main.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 将一个单词在给定集合中一步一步转化成另一个单词，这道题真的是难题  *****
 * 如果用BFS这道题会简单很多，一开始用DFS的方法，现在看来不可避免的会重复计算，超时。另外计算两个单词的是否差一个字符，用26个字母遍历的方法确实在大数据量下会非常快
 */
public class WordLadderII {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new LinkedList<>();
        List<String> list = new LinkedList<>();
        if (!wordList.contains(endWord)) {
            return result;
        }

        Set<String> wordSet = new HashSet<>(wordList);
        Queue<List<String>> queue = new LinkedList();
        list.add(beginWord);
        queue.add(list);
        Set<String> usedWord = new HashSet<>();
        usedWord.add(beginWord);
        boolean isDone = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            //同一层可以重复单词，所有在这一层遍历时不使用
            Set<String> levelUsedWord = new HashSet<>();
            for (int i = 0; i < size; i++) {
                List<String> currentList = queue.poll();
                String lastWord = currentList.get(currentList.size() - 1);

                List<String> nextWordList = getNeighbor(lastWord, wordSet);
                for (String matchWord : nextWordList) {
                    if (usedWord.contains(matchWord)) {
                        continue;
                    }
                    List<String> newList = new ArrayList<>(currentList);
                    newList.add(matchWord);
                    if (matchWord.equals(endWord)) {
                        isDone = true;
                        result.add(newList);
                    }

                    queue.add(new ArrayList<>(newList));
                    levelUsedWord.add(matchWord);
                }
            }
            usedWord.addAll(levelUsedWord);
            if (isDone) {
                break;
            }
        }
        return result;
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
        WordLadderII wordLadderII = new WordLadderII();
        wordLadderII.findLadders("", "", new LinkedList<>());

    }
}
