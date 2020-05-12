package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树前序遍历，根，左子树，右子树。
 */
public class BinaryTreePreorderTraversal {

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode treeNode = stack.pop();
            list.add(treeNode.val);

            if(treeNode.right != null) stack.push(treeNode.right);
            if(treeNode.left != null) stack.push(treeNode.left);
        }
        return list;
    }

//    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        traversal(list, root);
//        return list;
//    }
//
//    public void traversal(List<Integer> list, TreeNode root){
//        if(root == null){
//            return;
//        }
//        list.add(root.val);
//        traversal(list, root.left);
//        traversal(list, root.right);
//    }

    public static void main(String[] args) {
        TreeNode parent = new TreeNode(0);

        TreeNode layer1LeftNode = new TreeNode(1);

        TreeNode layer1RightNode = new TreeNode(2);

        TreeNode layer2LeftNode = new TreeNode(3);

        parent.left = layer1LeftNode;
        parent.right = layer1RightNode;

        layer1RightNode.left = layer2LeftNode;

        BinaryTreePreorderTraversal binaryTreePreorderTraversal = new BinaryTreePreorderTraversal();
        List<Integer> list = binaryTreePreorderTraversal.preorderTraversal(parent);
        System.out.println(list);

        System.out.println("hello world");
    }

}
