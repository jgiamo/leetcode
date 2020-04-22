package main.java;


import apple.laf.JRSUIUtils.Tree;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树铺平
 */
public class FlattenBinaryTreeToLinkedList {

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public void flatten(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        if(root == null){
            return;
        }
        if (root.right != null) {
            stack.push(root.right);
        }
        if (root.left != null) {
            stack.push(root.left);
        }

        TreeNode parentNode = root;

        while (!stack.isEmpty()) {
            TreeNode nextNode = stack.pop();

            if (nextNode.right != null) {
                stack.push(nextNode.right);
            }
            if (nextNode.left != null) {
                stack.push(nextNode.left);
            }
            parentNode.left = null;
            parentNode.right = nextNode;
            parentNode = nextNode;
        }
    }

    public static void main(String[] args) {
        TreeNode parent = new TreeNode(0);

        TreeNode layer1LeftNode = new TreeNode(3);

        TreeNode layer1RightNode = new TreeNode(1);

        TreeNode layer2LeftNode = new TreeNode(2);

        parent.left = layer1LeftNode;
        parent.right = layer1RightNode;

        layer1RightNode.left = layer2LeftNode;


        FlattenBinaryTreeToLinkedList flattenBinaryTreeToLinkedList = new FlattenBinaryTreeToLinkedList();

        flattenBinaryTreeToLinkedList.flatten(parent);

        System.out.println("hello world");
    }

}
