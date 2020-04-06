package main.java;

import java.util.Arrays;

/**
 * 加1个数字
 * Easy
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        int carry = 1;
        int i = digits.length - 1;
        while (carry > 0 && i >= 0) {
            digits[i] = digits[i] + 1;
            if (digits[i] == 10) {
                digits[i--] = 0;
            } else {
                carry = 0;
            }
        }
        if (carry == 1) {
            int[] newArray = new int[digits.length + 1];
            newArray[0] = 1;
            return newArray;
        }

        return digits;
    }


    public static void main(String[] args) {
        PlusOne plusOne = new PlusOne();

        int[] array = new int[]{9};

        System.out.println(Arrays.toString(plusOne.plusOne(array)));
        System.out.println("hello world");
    }

}
