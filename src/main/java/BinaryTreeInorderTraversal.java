package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树中序遍历，左子树，根，右子树。
 */
public class BinaryTreeInorderTraversal {

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        boolean visited;

        TreeNode(int x) {
            val = x;
        }
    }

//    //非递归的方法，感觉容易乱
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> result = new ArrayList<>();
//        Stack<TreeNode> stack = new Stack<>();
//
//        TreeNode node = root;
//        while (node != null || !stack.isEmpty()) {
//            while (node != null) {
//                stack.push(node);
//                node = node.left;
//            }
//            node =  stack.pop();
//            result.add(node.val);
//            node = node.right;
//
//        }
//
//        return result;
//    }


    //非递归的方法，增加了一种标识为，感觉容易理解了
    public List<Integer> inorderTraversalOther(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode node  = root;
        stack.push(node);
        while (!stack.isEmpty()) {
            node = stack.pop();
            if (!node.visited) {
                node.visited = true;
                if (node.right != null) {
                    stack.push(node.right);
                }
                stack.push(node);
                if (node.left != null) {
                    stack.push(node.left);
                }
            } else {
                result.add(node.val);
            }

        }

        return result;
    }

//    递归遍历
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        recursionSearch(result, root);
        return result;
    }

    //递归遍历
    public static void recursionSearch(List<Integer> list, TreeNode node){
        if(node != null){
            recursionSearch(list, node.left);
            list.add(node.val);
            recursionSearch(list, node.right);
        }
    }

    public static void main(String[] args) {
        TreeNode parent = new TreeNode(0);

        TreeNode layer1LeftNode = new TreeNode(1);

        TreeNode layer1RightNode = new TreeNode(2);

        TreeNode layer2LeftNode = new TreeNode(3);

        parent.left = layer1LeftNode;
        parent.right = layer1RightNode;

        layer1RightNode.left = layer2LeftNode;

        BinaryTreeInorderTraversal binaryTreeInorderTraversal = new BinaryTreeInorderTraversal();
        List<Integer> list = binaryTreeInorderTraversal.inorderTraversal(parent);
        System.out.println(list);

        System.out.println("hello world");
    }

}
