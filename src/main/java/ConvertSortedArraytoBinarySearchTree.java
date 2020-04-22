package main.java;

/**
 * 将有序数组转化平衡二叉树
 */
public class ConvertSortedArraytoBinarySearchTree {

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length-1);
    }

    public TreeNode buildTree(int[] nums, int start, int end) {
        if(start > end){
            return null;
        }
        int middle = (start + end) / 2;

        TreeNode treeNode = new TreeNode(nums[middle]);

        treeNode.left = buildTree(nums, start, middle - 1);
        treeNode.right = buildTree(nums, middle + 1, end);
        return treeNode;
    }

    public static void main(String[] args) {

        int[] array = new int[]{1, 2, 3, 4, 5};
        ConvertSortedArraytoBinarySearchTree convertSortedArraytoBinarySearchTree = new ConvertSortedArraytoBinarySearchTree();
        TreeNode node = convertSortedArraytoBinarySearchTree.sortedArrayToBST(array);

        System.out.println("hello world");
    }

}
