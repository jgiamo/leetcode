public class SearchInRotatedSortedArray {

    /**
     * You are given a target value to search. If found in the array return its index, otherwise
     * return -1. You may assume no duplicate exists in the array. Your algorithm's runtime
     * complexity must be in the order of O(log n)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        if (nums.length < 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int middle = (start + end) / 2;
            if (target == nums[middle]) {
                return middle;
            }
            //左边有序
            if (nums[start] < nums[middle]) {
                if(target >= nums[start] && target < nums[middle]){
                    end = middle-1;
                }else{
                    start = middle+1;
                }
            } else if (nums[start] > nums[middle]) {
                if(target > nums[middle] && target <= nums[end]){
                    start = middle + 1;
                }else{
                    end = middle-1;
                }
            } else {
                start = start+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{6, 7, 8, 9, 1, 2, 3, 4, 6};
        System.out.println(search(arr, 3));
    }
}
