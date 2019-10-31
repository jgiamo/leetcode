public class LongestCommonPrefix {

    public static String getCommonPrefix(String str1, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str1.length() && i < str2.length(); i++) {
            if (str1.charAt(i) == str2.charAt(i)) {
                stringBuilder.append(str1.charAt(i));
            } else {
                break;
            }
        }
        return stringBuilder.toString();
    }

    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            if(prefix.length() == 0){
                break;
            }
            prefix = getCommonPrefix(prefix, strs[i]);
        }
        return prefix;
    }

    public static void main(String[] args) {
        String[] strings = new String[]{"ad", "acx", "acsd"};
        System.out.println(longestCommonPrefix(strings));
    }
}
