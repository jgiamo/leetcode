package main.java;

import java.util.LinkedList;
import java.util.List;

/**
 * 求平方根。我这里用了二分法
 * 还可以用牛顿迭代法，进一步加速，求精确值
 */
public class Sqrt {

    public int mySqrt(int x) {
        if(x == 0){
            return 0;
        }
        long left = 1;
        long right = x;
        while (left < right - 1) {
            long num = (left + right) / 2;
            long mulityNum = num * num;
            if (mulityNum > x) {
                right = num;
            } else if (mulityNum < x) {
                left = num;
            } else {
                return (int)num;
            }
        }
        return (int)left;
    }


//    public int mySqrt(int x) {
//        if(x <= 1){
//            return x;
//        }
//        double num = x/2;
//        double alpha = 0.00001;
//        double error = 0.000001;
//
//        double left = num * num - x;
//        while(left > error || left < -error){
//            if(left > 0){
//                num = num - alpha * 2 * num;
//            }else if(left <0){
//                num = num + alpha * 2 * num ;
//            }
//            else{
//                return (int) num;
//            }
//            left = num * num - x;
//        }
//        return (int)(num+error);
//    }


    public static void main(String[] args) {
        Sqrt sqrt = new Sqrt();

        System.out.println(sqrt.mySqrt(2147395599));

    }

}
