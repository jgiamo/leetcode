public class ImplementStrStr {

    public static int strStr(String haystack, String needle) {
        if(needle.length() == 0){
            return 0;
        }
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int j = 0;
            for (; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if(j == needle.length()){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("adasdascxzcz", "asd"));
        System.out.println("hello world");
    }
}
