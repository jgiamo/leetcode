package main.java;

public class SearchInRotatedSortedArrayII {


    /**
     * 选注数组中搜索是否存在一个数。 原数组：0，0，1，2，2，5，6。旋转数组：2，5，6，0，0，1，2 问题的关键在于如何创建一个适合二分搜索的场景
     * 这种题目有意思，关键是如何将这样一个问题转换成二分查找
     */
    public boolean search(int[] nums, int target) {
        if(nums.length <= 0){
            return false;
        }
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int middle = (start + end) / 2;
            if (target == nums[middle]) {
                return true;
            }
            //左半部分有序
            if (nums[start] < nums[middle]) {
                if (target < nums[middle] && target >= nums[start]) {
                    end = middle - 1;
                } else {
                    start = middle + 1;
                }
                //右半部分有序
            } else if (nums[start] > nums[middle]) {
                if (target > nums[middle] && target <= nums[end]) {
                    start = middle + 1;
                } else {
                    end = middle - 1;
                }
                //无法判断有序，这里只能遍历查找
            } else {
                start = start + 1;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        SearchInRotatedSortedArrayII searchInRotatedSortedArrayII = new SearchInRotatedSortedArrayII();
        int[] arr = new int[]{6, 7, 8, 9, 1, 2, 3, 4, 6};

        System.out.println(searchInRotatedSortedArrayII.search(arr, 3));
    }
}
