package main.java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * 二叉树后序遍历，左子树，右子树，根。
 *
 * 看了官方题解，还有一种更好的，把后序遍历输出写出来后，从后往前插入，addFirst方法插入。相当于逆前序遍历
 */
public class BinaryTreePostorderTraversal {

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        boolean visited;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> visited = new HashSet<>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode treeNode = stack.pop();
            if(visited.contains(treeNode)){
                list.add(treeNode.val);
            }else{
                visited.add(treeNode);
                stack.push(treeNode);
                if(treeNode.right !=null) stack.push(treeNode.right);
                if(treeNode.left != null) stack.push(treeNode.left);
            }
        }
        return list;
    }


//    public List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        traversal(list, root);
//        return list;
//    }
//
//    public void traversal(List<Integer> list, TreeNode root){
//        if(root == null){
//            return;
//        }
//
//        traversal(list, root.left);
//        traversal(list, root.right);
//        list.add(root.val);
//    }

    public static void main(String[] args) {
        TreeNode parent = new TreeNode(0);

        TreeNode layer1LeftNode = new TreeNode(1);

        TreeNode layer1RightNode = new TreeNode(2);

        TreeNode layer2LeftNode = new TreeNode(3);

        parent.left = layer1LeftNode;
        parent.right = layer1RightNode;

        layer1RightNode.left = layer2LeftNode;

        BinaryTreePostorderTraversal binaryTreePostorderTraversal = new BinaryTreePostorderTraversal();
        List<Integer> list = binaryTreePostorderTraversal.postorderTraversal(parent);
        System.out.println(list);

        System.out.println("hello world");
    }

}
