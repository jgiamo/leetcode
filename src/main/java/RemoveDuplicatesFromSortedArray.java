public class RemoveDuplicatesFromSortedArray {
    public static int removeDuplicates(int[] nums) {
        int pos = 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[pos] == nums[i]){
                continue;
            }else{
                pos ++;
                nums[pos] = nums[i];
            }
        }
        return pos + 1;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 4, 5, 5, 6};
        System.out.println(removeDuplicates(nums));
    }
}
