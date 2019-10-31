import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LetterCombinations {


    public static List<String> letterCombinations(String digits) {
        LinkedList<String> list = new LinkedList<>();
        if (digits.isEmpty()) {
            return list;
        }
        String[] letters = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        list.add("");
        for (int i = 0; i < digits.length(); i++) {
            int listSize = list.size();
            for (int j = 0; j < listSize; j++) {
                String s = list.get(0);
                list.remove(s);
                for (char ch : letters[digits.charAt(i) - '2'].toCharArray()) {
                    list.add(s + ch);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));

    }
}
