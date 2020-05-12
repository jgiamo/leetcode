package main.java;


import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 */
public class SumRootToLeafNumbers {

    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int sum = 0;

    public int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }
        trace(root, 0);
        return sum;
    }

    public void trace(TreeNode root, int parentVal){
        int currentVal = root.val + parentVal * 10;
        if(root.left == null && root.right == null){
            sum = sum + currentVal;
        }
        if(root.left != null){
            trace(root.left, currentVal);
        }
        if(root.right != null){
            trace(root.right, currentVal);
        }
    }

    public static void main(String[] args) {
        SumRootToLeafNumbers sumRootToLeafNumbers = new SumRootToLeafNumbers();
        TreeNode treeNode = new TreeNode(1);
        sumRootToLeafNumbers.sumNumbers(treeNode);

    }
}

