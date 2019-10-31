public class ReverseInteger {
    public static int reverse(int x) {
        int num = 0;
        while (x != 0) {
            int remainder = x % 10;
            x = x / 10;
            if (num > 0 && num > (Integer.MAX_VALUE - remainder) / 10) {
                return 0;
            }
            if (num < 0 && num < (Integer.MIN_VALUE - remainder) / 10) {
                return 0;
            }
            num = remainder + num * 10;
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(reverse(1463847412));
        System.out.println("hello world");
    }
}
