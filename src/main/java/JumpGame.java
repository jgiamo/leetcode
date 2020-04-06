package main.java;

public class JumpGame {


    public boolean canJump(int[] nums) {

        int max = nums[0];
        int i = 1;
        for (; i <= max && i < nums.length; i++) {
            max = Math.max(i + nums[i], max);
        }
        if(max >= nums.length-1){
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        JumpGame jumpGame = new JumpGame();

        int array[] = new int[]{2,3,1,1,4};
        System.out.println(jumpGame.canJump(array));
    }

}
