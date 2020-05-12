package main.java;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 *
 * 状态转移00->01->11。用两个数字分别表示这种状态转移
 */
public class SingleNumberII {


//    public int singleNumber(int[] nums) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
//        }
//        for(Integer i : map.keySet()){
//            if(map.get(i) == 1){
//                return i;
//            }
//        }
//        return 0;
//    }

    public int singleNumber(int[] nums) {
        int ones = 0;
        int twos = 0;
        //由于先算第一位ones，所以算twos的时候ones是已经更新过的，所以要取反
        for (int i = 0; i < nums.length; i++) {
           ones = ones ^ nums[i] & ~twos;
           twos = twos ^ nums[i] & ~ones;
        }
        return ones;
    }


    public static void main(String[] args) {
        SingleNumberII singleNumberII = new SingleNumberII();

        System.out.println(
            singleNumberII.singleNumber(new int[]{1,1,1,3}));


    }

}
