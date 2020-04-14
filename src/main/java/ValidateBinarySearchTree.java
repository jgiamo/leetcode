package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 判断一个树是不是二叉搜索树
 */
public class ValidateBinarySearchTree {

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        boolean visited;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isValidBST(TreeNode root) {

    }


    public static void main(String[] args) {
        TreeNode parent = new TreeNode(0);

        TreeNode layer1LeftNode = new TreeNode(1);

        TreeNode layer1RightNode = new TreeNode(2);

        TreeNode layer2LeftNode = new TreeNode(3);

        parent.left = layer1LeftNode;
        parent.right = layer1RightNode;

        layer1RightNode.left = layer2LeftNode;

        ValidateBinarySearchTree validateBinarySearchTree = new ValidateBinarySearchTree();
        System.out.println(validateBinarySearchTree.isValidBST(parent));

        System.out.println("hello world");
    }

}
