package main.java;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 字符串中，最后一个单词的长度
 */
public class LengthOfLastWord {


    public int lengthOfLastWord(String s) {
        int currentLen = 0;
        int lastWordLen = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                if(currentLen > 0) {
                    lastWordLen = currentLen;
                    currentLen = 0;
                }
                continue;
            }
            currentLen++;
        }
        if (currentLen > 0) {
            lastWordLen = currentLen;
        }
        return lastWordLen;
    }

    public static void main(String[] args) {
        LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();

        String str = "hello world  ";
        System.out.println(lengthOfLastWord.lengthOfLastWord(str));

    }

}
