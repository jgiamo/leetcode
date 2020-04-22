package main.java;


/**
 * 判断是否是平衡二叉树
 */
public class BalancedBinaryTree {

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isBalanced(TreeNode root) {
        int height = trace(root);
        if (height == -1) {
            return false;
        }
        return true;
    }

    public int trace(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = trace(root.left);
        int rightHeight = trace(root.right);

        if (leftHeight == -1 || rightHeight == -1) {
            return -1;
        }
        if (leftHeight - rightHeight > 1 || leftHeight - rightHeight < -1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(0);
        BalancedBinaryTree binaryTree = new BalancedBinaryTree();
        System.out.println(binaryTree.isBalanced(treeNode));

        System.out.println("hello world");
    }

}
