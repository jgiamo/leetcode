package main.java;

import java.util.Stack;

/**
 * 二叉树求任意节点开始的最大路径
 * 这题完全是自己想出来的，总共只花了不到半小时，真的开心。
 * 二叉树的问题关键是怎么转化成递归情况去思考
 */
public class BinaryTreeMaximumPathSum {
    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public int max = 0;

    public int maxPathSum(TreeNode root) {
        max = root.val;
        int containRootMax = trace(root);
        return Math.max(max,containRootMax);
    }

    public int trace(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftMax = trace(root.left);
        int rightMax = trace(root.right);
        int sumMax1 = leftMax + rightMax + root.val;
        int sumMax2 = Math.max(leftMax, rightMax) > 0 ?  root.val + Math.max(leftMax, rightMax) : root.val;
        max = Math.max(Math.max(sumMax1, sumMax2), max);

        return sumMax2;

    }

    public static void main(String[] args) {
        BinaryTreeMaximumPathSum binaryTreeMaximumPathSum = new BinaryTreeMaximumPathSum();
        binaryTreeMaximumPathSum.maxPathSum(new TreeNode(1));
        System.out.println();
    }
}
