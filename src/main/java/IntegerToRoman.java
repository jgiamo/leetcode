public class IntegerToRoman {

    public static StringBuilder generateString(int tmp, char a, char b, char c) {
        StringBuilder stringBuilder = new StringBuilder();
        if (tmp >= 0 && tmp < 4) {
            for (int i = 1; i <= tmp; i++) {
                stringBuilder.append(a);
            }
        } else if (tmp == 4) {
            stringBuilder.append(a).append(b);
        } else if (tmp >= 5 && tmp < 9) {
            stringBuilder.append(b);
            for (int i = 6; i <= tmp; i++) {
                stringBuilder.append(a);
            }
        } else {
            stringBuilder.append(a).append(c);

        }
        return stringBuilder;
    }

    public static String intToRoman(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        int tmp = num / 1000;
        num = num % 1000;
        stringBuilder.append(generateString(tmp, 'M', '1', '1'));

        tmp = num / 100;
        num = num % 100;
        stringBuilder.append(generateString(tmp, 'C', 'D', 'M'));

        tmp = num / 10;
        num = num % 10;
        stringBuilder.append(generateString(tmp, 'X', 'L', 'C'));

        tmp = num/1;
        stringBuilder.append(generateString(tmp, 'I', 'V', 'X'));

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(1994));
        System.out.println("hello ");
    }
}
