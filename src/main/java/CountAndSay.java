package main.java;

public class CountAndSay {

    public String countAndSay(int n) {
        if(n == 1){
            return "1";
        }
        String lastStr = countAndSay(n - 1);
        char lastCh = '#';
        int appearNum = 1;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < lastStr.length(); i++) {
            char currentCh = lastStr.charAt(i);
            if (lastCh == '#') {
                lastCh = currentCh;
                continue;
            }
            if (lastCh == currentCh) {
                appearNum++;
            } else {
                stringBuilder.append(appearNum).append(lastCh);
                lastCh = currentCh;
                appearNum = 1;
                continue;
            }
        }
        stringBuilder.append(appearNum).append(lastCh);

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        CountAndSay countAndSay = new CountAndSay();
        System.out.println(countAndSay.countAndSay(6));

    }
}
