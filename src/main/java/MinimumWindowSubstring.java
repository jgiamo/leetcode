package main.java;

import java.util.HashMap;
import java.util.Map;

/**
 * 在字符串s里找到最小的窗口，包含t的所有字符
 */
public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        String res = s;
        int posX = 0;
        int posY = 0;
        Map<Character, Integer> mapDict = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            if (mapDict.containsKey(t.charAt(i))) {
                mapDict.put(t.charAt(i), mapDict.get(t.charAt(i)) + 1);
            } else {
                mapDict.put(t.charAt(i), 1);
            }
        }

        Map<Character, Integer> currentDict = new HashMap<>();
        int satisfyLen = 0;

        while (posY < s.length()) {
            while (posY < s.length()) {
                Character addCh = s.charAt(posY);
                //必须是t里面包含的字符
                if (mapDict.containsKey(addCh)) {
                    int currentNum = currentDict.getOrDefault(addCh, 0);
                    currentDict.put(addCh, ++currentNum);
                    //数量第一次超过时，该字符满足条件
                    if (currentNum == mapDict.get(addCh)) {
                        satisfyLen++;
                    }
                    if (satisfyLen == mapDict.keySet().size()) {
                        posY++;
                        break;
                    }
                }
                posY++;
            }
            if (satisfyLen == mapDict.keySet().size()) {
                while (posX <= posY) {
                    Character removeCh = s.charAt(posX);
                    if (mapDict.containsKey(removeCh)) {
                        int currentNum = currentDict.getOrDefault(removeCh, 0);
                        currentDict.put(removeCh, --currentNum);
                        if (currentNum < mapDict.get(removeCh)) {
                            posX++;
                            satisfyLen--;//也许直接用这个当作循环判断条件更好
                            break;
                        }
                    }
                    posX++;
                }
                if (posY - posX + 1 < res.length()) {
                    res = s.substring(posX - 1, posY);
                }
            }
        }

        if (posX == 0 && satisfyLen < mapDict.keySet().size() && res == s) {
            return "";
        }
        return res;
    }


    public static void main(String[] args) {
        MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();

        System.out.println(minimumWindowSubstring.minWindow("a", "aa"));


    }

}
