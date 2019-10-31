import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by jingjie on 2018/5/10.
 */
public class RomanToInteger {
    static Map<Character, Integer> map = new HashMap<Character, Integer>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public static int romanToInt(String s) {
        int num = 0;
        int preNum = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int nextNum = map.get(chars[i]);
            if(nextNum > preNum){
                num = num - preNum - preNum + nextNum;
            } else{
                num = num + nextNum;
            }
            preNum = nextNum;
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }
}
