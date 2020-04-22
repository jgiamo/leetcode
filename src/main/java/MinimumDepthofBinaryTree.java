package main.java;


/**
 * 一棵树的最短路径
 */
public class MinimumDepthofBinaryTree {

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right ==null){
            return 1;
        }
        if(root.left == null) return minDepth(root.right)+1;
        if(root.right == null) return minDepth(root.left)+1;

        return Math.min(minDepth(root.left), minDepth(root.right))+1;
    }


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(0);
        MinimumDepthofBinaryTree minimumDepthofBinaryTree = new MinimumDepthofBinaryTree();
        System.out.println(minimumDepthofBinaryTree.minDepth(treeNode));

        System.out.println("hello world");
    }

}
