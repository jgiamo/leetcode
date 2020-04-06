package main.java;

public class JumpGameII {


    //贪心算法，这里可以这样做，是因为跳的步数是最大的步数，你可以选择其中任何一步
    public int jump2(int[] nums) {

        int maxPos = 0;
        int end = 0;
        int step = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPos = Math.max(maxPos, nums[i] + i);
            //end表示当前这个阶段跳的最远距离
            if (i == end) {
                end = maxPos;
                step++;
            }
        }
        return step;
    }


    //动态规划，但是和贪心比起来，慢了
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int[] steps = new int[nums.length];
        steps[0] = 0;

        for (int i = 0; i < steps.length; i++) {
            int longestStep = nums[i];
            for (int j = i + 1; j <= longestStep + i && j < steps.length; j++) {
                if (steps[j] == 0 || steps[i] + 1 < steps[j]) {
                    steps[j] = steps[i] + 1;
                }
            }
        }
        return steps[nums.length - 1];
    }

    public static void main(String[] args) {
        JumpGameII jumpGameII = new JumpGameII();

        int array[] = new int[]{2, 3, 1, 1, 1, 4};
        System.out.println(jumpGameII.jump(array));
    }

}
