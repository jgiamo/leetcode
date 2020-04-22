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

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        return trace(root.left,root.val,null) && trace(root.right,null,root.val);
    }

    public boolean trace(TreeNode root,Integer leftTreeMinValue, Integer rightTreeMaxValue){
        if(root == null){
            return true;
        }
        if((leftTreeMinValue!= null && root.val >= leftTreeMinValue) || (rightTreeMaxValue != null && root.val <= rightTreeMaxValue)){
            return false;
        }
        if(!trace(root.left,root.val,rightTreeMaxValue)){
            return false;
        }
        if(!trace(root.right,leftTreeMinValue,root.val)){
            return false;
        }

        return true;
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
