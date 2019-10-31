import java.util.LinkedList;
import java.util.List;

public class GenerateParentheses {

    public static void generate(List<String> list, String str, int loop, int putNum, int n) {
        str = str + "(";
        if (loop == n) {
            while (putNum < n) {
                str = str + ")";
                putNum++;
            }
            list.add(str);
            return;
        }

        generate(list, str, loop + 1, putNum, n);
        for (int i = 0; i < loop - putNum; i++) {
            str = str + ")";
            generate(list, str, loop + 1, putNum + i + 1, n);
        }
        return;
    }

    public static List<String> generateParenthesis(int n) {
        List<String> list = new LinkedList<>();
        String str = "";

        generate(list, str, 1, 0, n);
        return list;
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
        System.out.println("hello world");
    }
}
