package main.java;


/**
 * 两数相乘，模仿乘法操作，先乘后加 由于数字比较大，所以不能用那种结果移位操作，而是需要每一位相乘
 */
public class MultiplyStrings {


    /**
     * 第二种方法，速度更快。知道每两位相乘的数字会在最终数字的第几位出现，就可以通过一次遍历，计算出各个位数的值，再遍历一遍完成进位运算。
     */
    public String multyply2(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int a[] = new int[num1.length() + num2.length()];
        for (int i = 0; i < num1.length(); i++) {
            int n1 = num1.charAt(num1.length() - i - 1) - '0';
            for (int j = 0; j < num2.length(); j++) {
                int n2 = num2.charAt(num2.length() - j - 1) - '0';
                a[i + j] = a[i + j] + n1 * n2;
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        //从最低位开始依次往上加
        for (int i = 0; i < a.length - 1; i++) {
            a[i + 1] = a[i + 1] + a[i] / 10;
            stringBuilder.append(a[i] % 10);
        }
        if (a[a.length - 1] > 0) {
            stringBuilder.append(a[a.length - 1]);
        }

        return stringBuilder.reverse().toString();
    }

    public String multiply(String num1, String num2) {

        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        String result = "0";

        for (int i = 0; i < num2.length(); i++) {
            int posNum = num2.charAt(i) - '0';
            StringBuilder stringBuilder = new StringBuilder();
            for (int m = i; m < num2.length() - 1; m++) {
                stringBuilder.append("0");
            }

            int lastCarry = 0;
            for (int j = num1.length() - 1; j >= 0; j--) {
                int tmpNum = num1.charAt(j) - '0';
                int n = posNum * tmpNum + lastCarry;
                lastCarry = n / 10;
                stringBuilder.append(n % 10);
            }
            if (lastCarry > 0) {
                stringBuilder.append(lastCarry);
            }

            result = addStrings(result, stringBuilder.reverse().toString());
        }
        return result;
    }


    /**
     * 这里直接使用两数相加的代码
     */
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
        String num1 = "123";
        String num2 = "456";
        MultiplyStrings multiplyStrings = new MultiplyStrings();
        System.out.println(multiplyStrings.multyply2(num1, num2));
    }

}
