public class ZigZagConversion {
    public static String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }
        StringBuilder stringBuilder = new StringBuilder(s.length());
        int cycleNum = 2 * numRows - 2;
        int cycles = s.length() / (cycleNum);
        int leftStrLen = s.length() % (cycleNum);

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < cycles; j++) {
                stringBuilder.append(s.charAt(i + j * cycleNum));
                if (i > 0 && i < numRows - 1) {
                    stringBuilder.append(s.charAt(i + j * cycleNum + 2 * (numRows - i - 1)));
                }
            }
            if (leftStrLen > i) {
                stringBuilder.append(s.charAt(cycleNum * cycles + i));
            }
            if (i > 0 && i < numRows - 1 && leftStrLen > i + 2 * (numRows - i - 1)){
                stringBuilder.append(s.charAt(cycleNum * cycles + i + 2 * (numRows - i - 1)));
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING" , 4));
        System.out.println("hello world");
    }
}
