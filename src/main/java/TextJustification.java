package main.java;

import java.util.LinkedList;
import java.util.List;

/**
 * hard
 * 文本左右对齐,比较麻烦的一道题目，所有细节要考虑清除
 */
public class TextJustification {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list = new LinkedList<>();
        int currentLineLen = words[0].length();
        int lastPos = 0;
        for (int i = 1; i < words.length; i++) {
            if (currentLineLen + 1 + words[i].length() <= maxWidth) {
                currentLineLen = currentLineLen + 1 + words[i].length();
            } else {
                //中间会有几个间隙
                int intervel = i - 1 - lastPos;
                //中间差几个空格
                int lackChar = maxWidth - currentLineLen + intervel;
                //每个间隙平均差多少空格
                int everyBlankNum = (intervel == 0 ? lackChar : lackChar / (intervel));
                //剩余的空格（从左向右下分）
                int leftBlack = (intervel == 0 ? 0 : lackChar % (intervel));

                StringBuilder stringBuilder = new StringBuilder(maxWidth);
                for (int j = lastPos; j <= i - 1; j++) {
                    stringBuilder.append(words[j]);
                    if (intervel == 0 || j != i - 1) {
                        for (int k = 0; k < everyBlankNum; k++) {
                            stringBuilder.append(" ");
                        }
                        if (leftBlack-- > 0) {
                            stringBuilder.append(" ");
                        }
                    }

                }

                list.add(stringBuilder.toString());

                currentLineLen = words[i].length();
                lastPos = i;
            }
        }
        StringBuilder stringBuilder = new StringBuilder(maxWidth);
        for (int i = lastPos; i < words.length; i++) {
            stringBuilder.append(words[i]).append(" ");
        }
        for (int i = stringBuilder.length(); i < maxWidth; i++) {
            stringBuilder.append(" ");
        }
        list.add(stringBuilder.substring(0, maxWidth));

        return list;
    }


    public static void main(String[] args) {
//        String[] words = new String[]{"This", "is", "an", "example", "of", "text",
//            "justification."};
//        String[] words = new String[]{"What", "must", "be", "acknowledgment", "shall", "be"};
                String[] words = new String[]{"for", "your", "country"};
        TextJustification textJustification = new TextJustification();
        List<String> list = textJustification.fullJustify(words, 16);

        for (String str : list) {
            System.out.println(str);
        }

    }

}
