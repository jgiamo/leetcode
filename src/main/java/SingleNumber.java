package main.java;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 异或操作，相同的数位是相同的全部会变成0
 */
public class SingleNumber {


    public int singleNumber(int[] nums) {
        int singleNum = 0;
        for (int i = 0; i < nums.length; i++) {
            singleNum = nums[i] ^ singleNum;
        }
        return singleNum;
    }


    public static void main(String[] args) {
        SingleNumber singleNumber = new SingleNumber();

        System.out.println(
            singleNumber.singleNumber(new int[]{1,2,2,3,3}));


    }

}
