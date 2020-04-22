package main.java;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * 层序遍历，倒者输出
 */
public class BinaryTreeLevelOrderTraversalII {

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result=new LinkedList();
        if(root == null){
            return result;
        }
        Stack<List> stack =  new Stack<>();
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);

        while(!queue.isEmpty()){
            List<Integer> list = new LinkedList();
            int levelSize = queue.size();
            for(int i=0;i<levelSize;i++){
                TreeNode node = queue.poll();
                if(node.left !=null) queue.add(node.left);
                if(node.right !=null) queue.add(node.right);
                list.add(node.val);
            }
            stack.push(list);
        }
        while(!stack.isEmpty()){
            result.add(stack.pop());
        }
        return result;
    }


    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(1);
        BinaryTreeLevelOrderTraversalII binaryTreeLevelOrderTraversalII = new BinaryTreeLevelOrderTraversalII();
        List<List<Integer>> lists = binaryTreeLevelOrderTraversalII.levelOrderBottom(treeNode);

        System.out.println("hello world");
    }

}
