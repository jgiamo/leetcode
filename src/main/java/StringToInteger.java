public class StringToInteger {

    public static int otherMyAtoi(String str) {
        int index = 0, sign = 1, total = 0;
        //1. Empty string
        if(str.length() == 0) return 0;

        //2. Remove Spaces
        while(str.charAt(index) == ' ' && index < str.length())
            index ++;

        //3. Handle signs
        if(str.charAt(index) == '+' || str.charAt(index) == '-'){
            sign = str.charAt(index) == '+' ? 1 : -1;
            index ++;
        }

        //4. Convert number and avoid overflow
        while(index < str.length()){
            int digit = str.charAt(index) - '0';
            if(digit < 0 || digit > 9) break;

            //check if total will be overflow after 10 times and add digit
            if(Integer.MAX_VALUE/10 < total || Integer.MAX_VALUE/10 == total && Integer.MAX_VALUE %10 < digit)
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

            total = 10 * total + digit;
            index ++;
        }
        return total * sign;
    }
    public static int myAtoi(String str) {
        boolean start = false;
        int num = 0;
        boolean isMinus = false;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!start) {
                if (ch == ' ') {
                    continue;
                } else if (ch >= 48 && ch <= 57) {
                    num = num * 10 + ch - 48;
                    start = true;
                } else if (ch == '+') {
                    start = true;
                } else if (ch == '-') {
                    start = true;
                    isMinus = true;
                } else {
                    break;
                }
            } else {
                if (ch >= 48 && ch <= 57) {
                    if (!isMinus) {
                        if (num > (Integer.MAX_VALUE - ch + 48) / 10) {
                            return Integer.MAX_VALUE;
                        }
                        num = num * 10 + ch - 48;
                    } else {
                        if (num < (Integer.MIN_VALUE + ch - 48) / 10) {
                            return Integer.MIN_VALUE;
                        }
                        num = num * 10 - ch + 48;
                    }
                } else {
                    break;
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("42"));
        System.out.println(myAtoi("    -42"));
        System.out.println(myAtoi("4193 with words"));
        System.out.println(myAtoi("words and 987"));
        System.out.println(myAtoi("-91283472332"));
        System.out.println(otherMyAtoi("-2147483647"));
        System.out.println("hello world");
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }
}
