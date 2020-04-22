package main.java;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * 层序遍历，锯齿形遍历，这里需要对于不同层分开输出。
 * 使用两个栈实现
 */
public class BinaryTreeZigzagLevelOrderTraversal {

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);

        while (!stack1.isEmpty()) {
            List<Integer> list1 = new LinkedList<>();

            while (!stack1.isEmpty()) {
                TreeNode treeNode = stack1.pop();
                list1.add(treeNode.val);
                if (treeNode.left != null) {
                    stack2.push(treeNode.left);
                }
                if (treeNode.right != null) {
                    stack2.push(treeNode.right);
                }
            }
            if(list1.size()>0) {
                result.add(list1);
            }

            List<Integer> list2 = new LinkedList<>();
            while (!stack2.isEmpty()) {
                TreeNode treeNode = stack2.pop();
                list2.add(treeNode.val);
                if (treeNode.right != null) {
                    stack1.push(treeNode.right);
                }
                if (treeNode.left != null) {
                    stack1.push(treeNode.left);
                }
            }
            if(list2.size()>0) {
                result.add(list2);
            }
        }

        return result;
    }


    public static void main(String[] args) {
        TreeNode parent = new TreeNode(0);

        TreeNode layer1LeftNode = new TreeNode(1);

        TreeNode layer1RightNode = new TreeNode(1);

        TreeNode layer2LeftNode = new TreeNode(2);

        parent.left = layer1LeftNode;
        parent.right = layer1RightNode;

        layer1RightNode.left = layer2LeftNode;

        BinaryTreeZigzagLevelOrderTraversal binaryTreeZigzagLevelOrderTraversal = new BinaryTreeZigzagLevelOrderTraversal();
        List<List<Integer>> list = binaryTreeZigzagLevelOrderTraversal.zigzagLevelOrder(parent);

        System.out.println("hello world");
    }

}
