import java.util.*;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resultList = new LinkedList<>();
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == null) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                int sum = nums[i] + nums[j];
                if (map.get(-sum) != null) {
                    if (-sum < nums[j]) {
                        continue;
                    }
                    if (-sum == nums[i] || -sum == nums[j]) {
                        if (nums[i] == nums[j]) {
                            if (map.get(-sum) < 3) {
                                continue;
                            }
                        }
                        if (map.get(-sum) < 2) {
                            continue;
                        }
                    }
                    List<Integer> list = new LinkedList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(-sum);
                    resultList.add(list);
                    while (j + 1 < nums.length && nums[j] == nums[j + 1]) {
                        j++;
                    }
                }
            }
            while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                i++;
            }
        }

        return resultList;
    }

    public static List<Integer> generateList(int a, int b, int c) {
        List<Integer> list = new LinkedList<>();
        if (a < b) {
            if (a < c) {
                list.add(a);
                if (b < c) {
                    list.add(b);
                    list.add(c);
                } else {
                    list.add(c);
                    list.add(b);
                }
            } else {
                list.add(c);
                list.add(a);
                list.add(b);
            }
        } else {
            if (b < c) {
                list.add(b);
                if (a < c) {
                    list.add(a);
                    list.add(c);
                } else {
                    list.add(c);
                    list.add(a);
                }
            } else {
                list.add(c);
                list.add(b);
                list.add(a);
            }
        }
        return list;
    }

    public static List<List<Integer>> anthoerThreeSum(int[] nums) {
        List<List<Integer>> resultList = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int target = -nums[i];
            map.clear();
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (map.get(target - nums[j]) != null) {
                    resultList.add(generateList(nums[i], nums[j], target - nums[j]));
                }
                map.put(nums[j], 1);
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        int[] a = new int[]{-1, 0, 1, 2, -1, -4};
        int[] b = new int[]{-1, 0, 1, 0};
        System.out.println(threeSum(a));
        System.out.println("hello");
    }
}
