package main.java;

public class TrappingRainWater {


    public int trap(int[] height) {
        int water = 0;
        int leftMountain[] = new int[height.length];
        int rightMountain[] = new int[height.length];

        int maxMountain = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > maxMountain) {
                maxMountain = height[i];
            }
            leftMountain[i] = maxMountain;
        }

        maxMountain = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            if (height[i] > maxMountain) {
                maxMountain = height[i];
            }
            rightMountain[i] = maxMountain;
        }

        for (int i = 0; i < height.length ; i++) {
            int compareLow = Math.min(leftMountain[i], rightMountain[i]);
            if(compareLow > height[i]){
                water = water + compareLow - height[i];
            }
        }
        return water;

    }

//    public int trap(int[] height) {
//        int water = 0;
//        int leftMountain = 0;
//        for (int i = 0; i < height.length; i++) {
//            if (leftMountain <= height[i]) {
//                leftMountain = height[i];
//                continue;
//            }
//
//            int rightMountain = 0;
//            for (int j = i + 1; j < height.length; j++) {
//                if (height[j] > rightMountain) {
//                    rightMountain = height[j];
//                }
//            }
//            if (rightMountain > height[i]) {
//                water = water + Math.min(leftMountain, rightMountain) - height[i];
//            }
//        }
//        return water;
//
//    }

    public static void main(String[] args) {
        TrappingRainWater trappingRainWater = new TrappingRainWater();
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trappingRainWater.trap(height));
    }

}
