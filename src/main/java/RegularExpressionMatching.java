public class RegularExpressionMatching {
    public static boolean rMatch(String s, String p, int sPos, int pPos) {
        if (sPos == -1 && pPos == -1) {
            return true;
        }
        if (pPos == -1) {
            return false;
        }
        if (p.charAt(pPos) == '*') {
            if (pPos >= 1) {
                char pChar = p.charAt(pPos - 1);
                if (pChar != '*') {
                    if (rMatch(s, p, sPos, pPos - 2)) {
                        return true;
                    }
                    while (sPos >= 0) {
                        if (pChar == '.' || s.charAt(sPos) == pChar) {
                            if (rMatch(s, p, sPos - 1, pPos - 2)) {
                                return true;
                            }
                        } else {
                            break;
                        }
                        sPos--;
                    }
                }
            }
            return false;
        } else {
            if (sPos >= 0 && pPos >= 0 && (p.charAt(pPos) == '.' || p.charAt(pPos) == s.charAt(sPos))) {
                return rMatch(s, p, sPos - 1, pPos - 1);
            } else {
                return false;
            }
        }
    }

    public static boolean isMatch(String s, String p) {
        return rMatch(s, p, s.length() - 1, p.length() - 1);
    }


    public static void main(String[] args) {
        System.out.println(isMatch("aaaa", "aaaaa"));
    }
}
