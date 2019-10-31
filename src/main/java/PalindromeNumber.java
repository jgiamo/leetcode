public class PalindromeNumber {
    public static boolean isPalindromeOtherWay(int x) {
        int num = 0;
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        while (x != 0) {
            if (num == x) {
                return true;
            }
            if (num > x) {
                return num / 10 == x;
            }

            num = num * 10 + x % 10;
            x = x / 10;
        }
        return true;
    }

    public static boolean isPalindrome(int x) {
        int y = x;
        long num = 0;
        while (x > 0) {
            num = num * 10 + x % 10;
            x = x / 10;
        }
        return (int) num == y;
    }

    public static void main(String[] args) {
        System.out.println(isPalindromeOtherWay(-121));
    }
}
