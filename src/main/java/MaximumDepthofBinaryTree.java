package main.java;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 求高度
 */
public class MaximumDepthofBinaryTree {

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxDepth = traverse(root);
        return maxDepth;
    }

    public int traverse(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(traverse(root.left) + 1, traverse(root.right) + 1);
    }


    public static void main(String[] args) {
        TreeNode parent = new TreeNode(0);

        TreeNode layer1LeftNode = new TreeNode(1);

        TreeNode layer1RightNode = new TreeNode(1);

        TreeNode layer2LeftNode = new TreeNode(2);

        parent.left = layer1LeftNode;
        parent.right = layer1RightNode;

        layer1RightNode.left = layer2LeftNode;

        MaximumDepthofBinaryTree maximumDepthofBinaryTree = new MaximumDepthofBinaryTree();
        System.out.println(maximumDepthofBinaryTree.maxDepth(parent));

        System.out.println("hello world");
    }

}
