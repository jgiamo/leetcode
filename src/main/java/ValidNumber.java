package main.java;

/**
 * hard.
 * 是否是个有效数字
 * 这题确实复杂，传统的方法考虑的情况过于复杂 ***
 * 更好的方法是列出所有情况，用状态机的方法转移
 */
public class ValidNumber {

    public boolean isNumber(String s) {

        s = s.trim();
        if (s.length() == 0) {
            return false;
        }
        boolean isScienceExpress = false;
        boolean isHasDot = false;
        boolean isHasNum = false;
        boolean isHasNumAfterE = true;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                if (i == 0 || (i >= 1 && s.charAt(i - 1) == 'e')) {
                    continue;
                } else {
                    return false;
                }
            } else if (s.charAt(i) == 'e') {
                if(!isHasNum || isScienceExpress){
                    return false;
                }
                isScienceExpress = true;
                isHasNumAfterE = false;
            } else if (s.charAt(i) == '.') {
                if (isScienceExpress || isHasDot) {
                    return false;
                }
                isHasDot = true;
            } else if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                isHasNum = true;
                isHasNumAfterE = true;

            } else {
                return false;
            }

        }

        return isHasNum && isHasNumAfterE;
    }


    public static void main(String[] args) {
        ValidNumber validNumber = new ValidNumber();
        System.out.println(validNumber.isNumber("2e0"));
        System.out.println("hello world");
    }

}
