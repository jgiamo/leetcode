/**
 * Created by jingjie on 2018/5/14.
 */
public class QuickSort {

    public static void swapVal(int[] arr, int p ,int q) {
        int temp = arr[p];
        arr[p] = arr[q];
        arr[q] = temp;
    }

    public static int[] quickSort(int[] arr, int start, int end) {
        int k = start;
        if(start >= end){
            return arr;
        }
        for (int i = start + 1; i <= end; i++) {
            if (arr[i] < arr[k] && i < k) {
                swapVal(arr, k ,i);
                k = i;
            }else if(arr[i] > arr[k] &&i >k){
                swapVal(arr, k ,i);
                k = i;
            }
        }
        quickSort(arr, start, k -1);
        quickSort(arr, k+1, end);
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{42, 445, 778, 12, 32};
        quickSort(arr, 0, arr.length -1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
