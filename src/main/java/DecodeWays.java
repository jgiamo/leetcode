package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个字符串，有多少种编码方式.
 * 虽然很快想到了方法，但是边界处理的太不好了，试了7，8次才过
 */
public class DecodeWays {


    public int numDecodings(String s) {
        int[] array = new int[s.length() + 1];

        array[0] = 1;
        if (s.charAt(0) == '0') {
            array[0] = 0;
            return 0;
        }
        array[1] = 1;
        for (int i = 2; i <= s.length(); i++) {
            if (s.charAt(i - 2) == '1') {
                if (s.charAt(i - 1) == '0') {
                    array[i] = array[i - 2];
                } else {
                    array[i] = array[i - 1] + array[i - 2];
                }
            } else if (s.charAt(i - 2) == '2') {
                if (s.charAt(i - 1) >= '1' && s.charAt(i - 1) <= '6') {
                    array[i] = array[i - 1] + array[i - 2];
                } else if (s.charAt(i - 1) == '0') {
                    array[i] = array[i - 2];
                } else{
                    array[i] = array[i-1];
                }
            }  else if(s.charAt(i-1) == '0') {
                array[i] =0;
                break;
            }else{
                array[i] = array[i - 1];
            }
        }

        return array[s.length()];
    }


    public static void main(String[] args) {
        DecodeWays decodeWays = new DecodeWays();

        System.out.println(decodeWays.numDecodings("10100"));
    }

}
