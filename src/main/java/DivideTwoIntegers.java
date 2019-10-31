public class DivideTwoIntegers {

    public static int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean isNegative = false;
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            isNegative = true;
        }
        dividend = dividend < 0 ? dividend : -dividend;
        divisor = divisor < 0 ? divisor : -divisor;

        int result = divideNum(dividend, divisor);

        if (isNegative) {
            result = -result;
        }
        return result;

    }

    public static int divideNum(int dividend, int divisor) {
        if (dividend > divisor) {
            return 0;
        }

        int num = 1;
        int sum = divisor;
        while (sum > dividend - sum) {
            sum += sum;
            num += num;
        }
        return num + divideNum(dividend - sum, divisor);
    }

    public static void main(String[] args) {
        System.out.println(divide(-2147483648, 3));
        System.out.println("hello world");
    }
}
