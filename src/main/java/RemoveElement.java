public class RemoveElement {
    public static int removeElement(int[] nums, int val) {
        int pos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[pos++] = nums[i];
            }
        }
        return pos;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 4, 5, 5, 6};
        System.out.println(removeElement(nums, 3));
    }
}
