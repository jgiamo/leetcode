package main.java;

/**
 * 旋转数组找最小值，包含重复元素
 */
public class FindMinimumInRotatedSortedArrayII {

    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right]) left = mid + 1;
            else if (nums[mid] < nums[right]) right = mid;
            else right = right - 1;
        }
        return nums[left];
    }

    public static void main(String[] args) {


        FindMinimumInRotatedSortedArrayII findMinimumInRotatedSortedArrayII = new FindMinimumInRotatedSortedArrayII();
        findMinimumInRotatedSortedArrayII.findMin(new int[]{2,3,4,-2,-1,0});


    }

}
