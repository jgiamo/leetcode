package main.java;

/**
 * 在直方图中，找面积最大的矩形. *** 这题有点难想到
 * 还有个方法栈实现，太巧妙了
 *
 */
public class LargestRectangleInHistogram {

//    //暴力法，直方图中每个圆柱为基底的最大面积
//    public int largestRectangleArea(int[] heights) {
//
//        int maxArea = 0;
//        for (int i = 0; i < heights.length; i++) {
//            int leftPos = i;
//            int rightPos = i;
//            //接下来的两个循环，如果放到外面，会不会好一些
//            for (int j = i - 1; j >= 0; j--) {
//                if(heights[j] < heights[i]){
//                    break;
//                }
//                leftPos--;
//            }
//            for (int j = i + 1; j < heights.length; j++) {
//                if(heights[j] < heights[i]){
//                    break;
//                }
//                rightPos++;
//            }
//            maxArea = Math.max(maxArea, heights[i] * (rightPos -leftPos+1));
//
//
//        }
//        return maxArea;
//    }

    //直方图中每个圆柱为基底的最大面积
    public int largestRectangleArea(int[] heights) {

        if(heights.length == 0){
            return 0;
        }
        int maxArea = 0;
        int[] leftPos = new int[heights.length];
        int[] rightPos = new int[heights.length];
        leftPos[0] = -1;
        rightPos[heights.length - 1] = heights.length;

        //接下来的两个循环，如果放到外面，会不会好一些
        for (int i = 1; i < heights.length; i++) {
            int tmp = i - 1;
            while (tmp >= 0 && heights[tmp] >= heights[i]) {
                //继续找第一个小于heights[i]的值。用第一个小于heights[tmp]的值去和heights[i]比较
                tmp = leftPos[tmp];
            }
            leftPos[i] = tmp;
        }
        for (int i = heights.length - 2; i >= 0; i--) {
            int tmp = i + 1;
            while (tmp < heights.length && heights[tmp] >= heights[i]) {
                tmp = rightPos[tmp];
            }
            rightPos[i] = tmp;
        }

        for (int i = 0; i < heights.length; i++) {
            maxArea = Math.max(maxArea, heights[i] * (rightPos[i] - leftPos[i] - 1));
        }
        return maxArea;
    }


    public static void main(String[] args) {

        LargestRectangleInHistogram largestRectangleInHistogram = new LargestRectangleInHistogram();

        int[] heights = new int[]{2, 1, 2};

        System.out.println(largestRectangleInHistogram.largestRectangleArea(heights));
    }
}
