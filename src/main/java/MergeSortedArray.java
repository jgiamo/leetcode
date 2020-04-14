package main.java;

import java.util.HashMap;
import java.util.Map;

/**
 * 合并有序数组，如果从后往前搜索，就不会有拷贝数组的问题了
 */
public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = m + n - 1;
        m = m - 1;
        n = n - 1;
        while (len >= 0) {
            if (m >= 0 & n >= 0) {
                if (nums1[m] > nums2[n]) {
                    nums1[len] = nums1[m--];
                } else {
                    nums1[len] = nums2[n--];
                }
            } else if (m < 0) {
                nums1[len] = nums2[n--];
            } else {//这种情况下已经有序了
                break;
            }

            len--;
        }

    }

    public static void main(String[] args) {

        MergeSortedArray mergeSortedArray = new MergeSortedArray();

        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};

        mergeSortedArray.merge(nums1, 3, nums2, 3);

        for (int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i] + " ");
        }

    }
}
