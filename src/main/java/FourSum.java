import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new LinkedList<>();
        Arrays.sort(nums);
        if (nums.length < 4) {
            return list;
        }
        if (nums[0] * 4 > target || nums[nums.length - 1] * 4 < target) {
            return list;
        }
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                int k = j + 1;
                int l = nums.length - 1;
                while (k < l) {
                    int sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum > target) {
                        l--;
                    } else if (sum < target) {
                        k++;
                    } else {
                        list.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        l--;
                        while (k > 0 && k < l && nums[k] == nums[k - 1]) {
                            k++;
                        }
                        while (l < nums.length - 1 && k < l && nums[l] == nums[l + 1]) {
                            l--;
                        }
                    }
                }
                while (j < nums.length - 2 && nums[j] == nums[j + 1]) {
                    j++;
                }
            }
            while (i < nums.length - 3 && nums[i] == nums[i + 1]) {
                i++;
            }
        }

        return list;
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{1, 0, -1, 0, -2, 2};
        int[] arr = new int[]{0, 0, 0, 0};
        int target = 0;
        System.out.println(fourSum(arr, target));
        System.out.println("hello");
    }
}
