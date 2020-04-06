package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 字母异位词分组,对于顺序不同的字符串，将他们分到同一个组里
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String,List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] ch = strs[i].toCharArray();
            Arrays.sort(ch);

            String key = String.valueOf(ch);
            if(!map.containsKey(key)){
                map.put(key, new LinkedList<>());
            }
            map.get(key).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"abc","cba","cca","def","acc"};
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        List<List<String>> lists = groupAnagrams.groupAnagrams(strs);

        for (int i = 0; i < lists.size(); i++) {
            List<String> list = lists.get(i);
            System.out.println(list);
        }
        System.out.println("Hello world");
    }

}
