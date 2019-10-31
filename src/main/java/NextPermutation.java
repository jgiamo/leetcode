import java.util.Arrays;

public class NextPermutation {

    public static void swapNum(int[] numArr, int posA, int posB) {
        int tmpNum = numArr[posA];
        numArr[posA] = numArr[posB];
        numArr[posB] = tmpNum;
    }

    public static void reverseArray(int[] nums, int start, int end) {
        while (end > start) {
            swapNum(nums, start, end);
            start++;
            end--;
        }
    }

    public static void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        for (; i >= 0; i--) {
            if (nums[i] >= nums[i + 1]) {
                continue;
            } else {
                for (int j = nums.length - 1; j > i; j--) {
                    if (nums[i] < nums[j]) {
                        swapNum(nums, i, j);
                        break;
                    }
                }
                reverseArray(nums, i + 1, nums.length - 1);
                break;
            }
        }
        if (i == -1) {
            reverseArray(nums, i + 1, nums.length - 1);
        }
    }

    public static void main(String[] args) {
        int a[] = new int[]{5, 1, 1};
//        int a[] = new int[]{1, 3, 6, 5, 4};
        nextPermutation(a);
        System.out.println(Arrays.toString(a));
    }
}
