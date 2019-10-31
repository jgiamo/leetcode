import java.util.Stack;

public class LongestValidParentheses {

    public static int longestValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        int maxLen = 0;
        for (int i = 0; i < s.length() - maxLen; i++) {
            int j = i;
            stack.clear();
            for (; j < s.length(); j++) {
                if (s.charAt(j) == ')') {
                    if (!stack.isEmpty() && stack.pop() == '(') {
                        if (stack.isEmpty()) {
                            int len = j - i + 1;
                            if (len > maxLen) {
                                maxLen = len;
                            }
                        }
                    } else {
                        break;
                    }
                } else {
                    stack.push('(');
                }
            }
        }
        return maxLen;
    }

    public static int anotherLongestValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {

        }
        for (int i = 0; i < s.length() - maxLen; i++) {
            int j = i;
            stack.clear();
            for (; j < s.length(); j++) {
                if (s.charAt(j) == ')') {
                    if (!stack.isEmpty() && stack.pop() == '(') {
                        if (stack.isEmpty()) {
                            int len = j - i + 1;
                            if (len > maxLen) {
                                maxLen = len;
                            }
                        }
                    } else {
                        break;
                    }
                } else {
                    stack.push('(');
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String str = "()(())";
//        String str = ")()()(";
        System.out.println(longestValidParentheses(str));
        System.out.println("hello world");
    }
}
