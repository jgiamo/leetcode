import java.util.Arrays;

public class ThreeSumCloset {
    public static int compareAndSet(int a, int b) {
        if (Math.abs(a) < Math.abs(b)) {
            return a;
        } else {
            return b;
        }
    }

    public static int threeSumClosest(int[] nums, int target) {
        int closetDistance = target - nums[0] - nums[1] - nums[2];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int nextTarget = target - nums[i];
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int distance = nextTarget - nums[j] - nums[k];
                if (distance > 0) {
                    j++;
                } else if (distance < 0) {
                    k--;
                } else {
                    return target;
                }
                closetDistance = compareAndSet(closetDistance, distance);
            }
        }
        return target - closetDistance;
    }

    public static void main(String[] args) {
        int[] c = new int[]{1, 2, 5, 10, 11};
        int[] d = new int[]{1, 1, 1, 0};
        System.out.println(threeSumClosest(c, 12));
    }
}
