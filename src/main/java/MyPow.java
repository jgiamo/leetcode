package main.java;


/**
 * 实现x的n次幂
 */
public class MyPow {

    public double pow(double x, long n) {
        if (n == 0) {
            return 1;
        }

        double half = pow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

    public double myPow(double x, int n) {
        if (n == 0 || x == 1) {
            return 1;
        }
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        return pow(x, N);
    }

//    public double myPow(double x, int n) {
//        if (n == 0 || x == 1) {
//            return 1;
//        }
//        long N = n;
//        if (N < 0) {
//            x = 1 / x;
//
//            N = -N;
//        }
//
//        double result = 1;
//        for (int i = 0; i < N; i++) {
//            result = result * x;
//        }
//        return result;
//    }

    public static void main(String[] args) {
        MyPow myPow = new MyPow();
        System.out.println(myPow.myPow(2.0, -2147483648));
    }

}
