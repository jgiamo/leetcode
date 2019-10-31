import java.util.*;

/**
 * Created by jingjie on 2018/4/10.
 */
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap();
        Map<Integer, Integer> secondMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            } else {
                secondMap.put(nums[i], i);
            }
        }

        for (Integer num : map.keySet()) {
            if (map.containsKey(target - num)) {
                result[0] = map.get(num);
                if (num == (target - num)) {
                    result[1] = secondMap.get(target - num);
                } else {
                    result[1] = map.get(target - num);
                }
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[5];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        arr[3] = 5;
        arr[4] = 6;
        System.out.println(Arrays.toString(twoSum(arr, 5)));
        System.out.println("hello world");
    }
}
