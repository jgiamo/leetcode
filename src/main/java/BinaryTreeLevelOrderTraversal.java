package main.java;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 层序遍历，这里需要对于不同层分开输出。
 * 这里的队列使用不同的数据结构，耗时差别很大
 */
public class BinaryTreeLevelOrderTraversal {

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        //这里选用LinkedList，比选择阻塞队列快的多
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int currentLevelSize = queue.size();
            List<Integer> levelList = new LinkedList<>();
            //当前层的遍历
            for (int i = 0; i < currentLevelSize; i++) {
                TreeNode treeNode = queue.poll();
                levelList.add(treeNode.val);
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
            result.add(levelList);

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

        BinaryTreeLevelOrderTraversal binaryTreeLevelOrderTraversal = new BinaryTreeLevelOrderTraversal();
        List<List<Integer>> list = binaryTreeLevelOrderTraversal.levelOrder(parent);

        System.out.println("hello world");
    }

}
