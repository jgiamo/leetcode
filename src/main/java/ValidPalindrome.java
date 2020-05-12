package main.java;

/**
 * 检测是否是回文串
 */
public class ValidPalindrome {


    public int max = 0;

    public boolean checkCh(char ch){
        if((ch>='0' && ch <='9')|| (ch>='a' && ch<='z') || (ch>='A' && ch<='Z')){
            return true;
        }
        return false;
    }

    public boolean isPalindrome(String s) {
        int start=0;
        int end = s.length() - 1;
        while(start < end){
            while(start <= end){
                if(checkCh(s.charAt(start))){
                    break;
                }
                start++;
            }

            while(end >= start){
                if(checkCh(s.charAt(end))){
                    break;
                }
                end--;
            }
            if(end<start){
                return true;
            }
            if(Character.toLowerCase(s.charAt(start++)) != Character.toLowerCase(s.charAt(end--))){
                return false;
            }

        }

        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome validPalindrome = new ValidPalindrome();
        System.out.println(validPalindrome.isPalindrome(""));

    }
}
