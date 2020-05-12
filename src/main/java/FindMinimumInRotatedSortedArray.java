package main.java;

/**
 * 旋转数组找最小值，不包含重复元素
 */
public class FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        while(start < end){
            int middle=(start + end)/2;
            //比两边都大，最大的应该在右边
            if(nums[middle] >= nums[start] && nums[middle] > nums[end]){
                start = middle + 1;
                //比两边都小，最小的应该在左边
            }else if(nums[middle] < nums[start] && nums[middle] < nums[end]){
                if(nums[middle]<nums[middle-1]){
                    return nums[middle];
                }
                end = middle - 1;
                //从小到大排序的情况
            }else if(nums[middle] >= nums[start] && nums[middle] < nums[end]){
                return nums[start];
            }
        }
        return nums[start];
    }

    public static void main(String[] args) {


        FindMinimumInRotatedSortedArray findMinimumInRotatedSortedArray = new FindMinimumInRotatedSortedArray();
        findMinimumInRotatedSortedArray.findMin(new int[]{2,3,4,-2,-1,0});


    }

}
