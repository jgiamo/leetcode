package main.java;

/**
 * 全排列，顺序给出第k个排列的值
 */
public class PermutationSequence {

    public String getPermutation(int n, int k) {
        int baseN = 1;
        for (int i = 1; i <= n - 1; i++) {
            baseN = baseN * i;
        }

        StringBuilder stringBuilder = new StringBuilder();

        boolean[] used = new boolean[n];
        //改成k是从0开始
        k = k - 1;
        for (int i = n - 1; i >= 1; i--) {
            stringBuilder.append(getNumber(n, used, k / baseN));
            k = k % baseN;
            baseN = baseN / i;
        }
        stringBuilder.append(getNumber(n, used, 0));

        return stringBuilder.toString();
    }

    //获取第k个数字，k是从0开始的
    public int getNumber(int n, boolean[] used, int k) {
        int pos = 0;
        for (int i = 1; i <= n; i++) {
            if (used[i - 1]) {
                continue;
            }
            if (pos == k) {
                used[i - 1] = true;
                return i;
            }
            pos++;
        }
        return 0;

    }


    public static void main(String[] args) {
        PermutationSequence permutationSequence = new PermutationSequence();

        System.out.println(permutationSequence.getPermutation(4, 9));
    }
}
