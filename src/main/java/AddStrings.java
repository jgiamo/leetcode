package main.java;


/**
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 * 重点：索引溢出，进位处理，添加上一步进位
 */
public class AddStrings {

    public String addStrings(String num1, String num2) {

        int maxLen = Math.max(num1.length(), num2.length());
        StringBuilder stringBuilder = new StringBuilder();
        int lastCarry = 0;
        for (int i = 0; i < maxLen; i++) {
            int n1 = 0, n2 = 0;
            if (i < num1.length()) {
                n1 = num1.charAt(num1.length() - 1 - i) - '0';
            }
            if (i < num2.length()) {
                n2 = num2.charAt(num2.length() - 1 - i) - '0';
            }
            int n = n1 + n2 + lastCarry;
            lastCarry = n / 10;
            stringBuilder.append(n % 10);
        }
        if (lastCarry == 1) {
            stringBuilder.append('1');
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        String num1 = "498828660196";
        String num2 = "498828660196";
         num1 = "408";
         num2 = "5";
        AddStrings addStrings = new AddStrings();
        System.out.println(addStrings.addStrings(num1, num2));
    }
}
