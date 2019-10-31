import java.util.*;

public class SubstringwithConcatenationofAllWords {

    public static List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> wordsMap = new HashMap<>();
        List<Integer> result = new LinkedList<>();
        if(words.length <= 0){
            return result;
        }
        for (String word : words) {
            wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);
        }

        int wordLen = words[0].length();
        int wordCount = words.length;
        int strLen = s.length();
        for (int i = 0; i <= strLen - wordLen * wordCount; i++) {
            int j = 0;
            Map<String, Integer> seenWordMap = new HashMap<>();
            for (; j < wordCount; j++) {
                String matchingStr = s.substring(i + j * wordLen, i + (j + 1) * wordLen);
                if (wordsMap.containsKey(matchingStr)) {
                    if (seenWordMap.getOrDefault(matchingStr, 0) < wordsMap.get(matchingStr)) {
                        seenWordMap.put(matchingStr, seenWordMap.getOrDefault(matchingStr, 0) + 1);
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
            if (j == wordCount) {
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {

        String[] words = new String[]{"word", "good", "best", "good"};
        System.out.println(findSubstring("wordgoodgoodgoodbestword", words));
        Set<String> set = new HashSet<>();

        set.add("a");
        set.add("bb");
        set.add("c");
        set.add("d");

        Set<String> bSet = new HashSet<>();
        bSet.add("gg");
        bSet.add("b");
        bSet.add("c");
        bSet.add("df");

        System.out.println(set);
        set.removeAll(bSet);
        System.out.println(set);
        System.out.println(bSet);


    }
}
