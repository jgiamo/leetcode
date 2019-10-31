import java.nio.file.StandardWatchEventKinds;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.Callable;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Math.max;
import static java.util.Arrays.asList;

public class Main {

    public static int LCS(String str1, String str2) {
        if (str1.length() < 1 || str2.length() < 1) {
            return 0;
        }
        if (str1.charAt(str1.length() - 1) == str2.charAt(str2.length() - 1)) {
            return LCS(str1.substring(0, str1.length() - 1), str2.substring(0, str2.length() - 1)) + 1;
        } else {
            return max(LCS(str1.substring(0, str1.length() - 1), str2), LCS(str2.substring(0, str2.length() - 1), str1));
        }
    }

    public static int LCSNoRecursive(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();

        int[][] c = new int[len1 + 1][];
        for (int i = 0; i < len1 + 1; i++) {
            c[i] = new int[len2 + 1];
        }

        for (int i = 1; i < len1 + 1; i++) {
            for (int j = 1; j < len2 + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                } else if (c[i][j - 1] > c[i - 1][j]) {
                    c[i][j] = c[i][j - 1];
                } else {
                    c[i][j] = c[i - 1][j];
                }
            }
        }
        return c[len1][len2];
    }

    public static int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;

        return n + 1;
    }

    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println("hello world");
        };
        Callable<String> callable = () -> {
            System.out.println("hello callable");
            return "hello";
        };

        try {
            System.out.println(callable.call());
        } catch (Exception e) {
            System.out.println("yes");
        }

        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < 50; i++) {
            list.add(i);
        }


        long count = list.stream().filter(oneList -> oneList > 30).count();

        long count2 = list.stream().filter(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer < 40;
            }
        }).count();

        System.out.println(count);
        System.out.println(count2);

        BinaryOperator<Long> add = (x, y) -> x + y;

        List<Integer> myList = Stream.of(asList(1,2),asList(4,5)).flatMap(numbers -> numbers.stream()).collect(Collectors.toList());

        System.out.println(myList);

        int maxInt = myList.stream().max((Integer a, Integer b) -> a.compareTo(b)).get();

        int minInt = myList.stream().min(Integer::compare).get();

        int result = myList.stream().reduce(1, (a,b)-> a*b);

        System.out.println(maxInt);
        System.out.println(minInt);
        System.out.println(result);
        System.out.println(tableSizeFor(-5));
//        Integer[] a = new Integer[10];
//        String str1 = new String("abcdef");
//        String str2 = new String("zcdnwq");
//        System.out.print(LCSNoRecursive(str1, str2));
//        System.out.println("Hello World!");
    }
}
