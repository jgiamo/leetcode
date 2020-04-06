package main.java;

import java.util.Arrays;

/**
 * 加1个数字 Easy
 */
public class AddBinary {

    public String addBinary(String a, String b) {
        int lenA = a.length() - 1;
        int lenB = b.length() - 1;
        int carry = 0;
        StringBuilder result = new StringBuilder(Math.max(lenA, lenB) + 1 + 1);
        while (lenA >= 0 || lenB >= 0) {
            int numA = 0;
            int numB = 0;
            if (lenA >= 0) {
                numA = a.charAt(lenA--) - '0';
            }
            if (lenB >= 0) {
                numB = b.charAt(lenB--) - '0';
            }
            int sum = numA + numB + carry;

            carry = sum / 2;
            sum = sum % 2;
            result.append(sum);
        }

        if (carry > 0) {
            result.append(carry);
        }
        return result.reverse().toString();
    }


    public static void main(String[] args) {
        AddBinary addBinary = new AddBinary();

        System.out.println(addBinary.addBinary("0", "0"));
        System.out.println("hello world");
    }

}
