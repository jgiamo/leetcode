public class SearchInRotatedSortedArray {

    /**
     * You are given a target value to search. If found in the array return its index, otherwise return -1.
     * You may assume no duplicate exists in the array.
     * Your algorithm's runtime complexity must be in the order of O(log n)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int middle = start + (end - start) >> 1;
            if (nums[middle] < target) {
//                if()
            } else {

            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{6, 7, 8, 9, 1, 2, 3, 4, 6};
        System.out.println(search(arr, 3));
    }
}
