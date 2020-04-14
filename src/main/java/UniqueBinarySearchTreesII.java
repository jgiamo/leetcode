package main.java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import main.java.BinaryTreeInorderTraversal.TreeNode;

/**
 * 生成二叉搜索树。这个是看了答案的解答，太精彩了 ***
 * 因为要求的是所有解法，所有递归返回左右子数也是列表
 */
public class UniqueBinarySearchTreesII {

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<TreeNode> generateTrees(int n) {
        if(n==0){
            return new ArrayList<>();
        }
        return recursionGenerate(1,n);
    }

    public List<TreeNode> recursionGenerate(int start, int end) {
        List<TreeNode> treeNodeList = new LinkedList<>();

        if(start > end){
            treeNodeList.add(null);
            return treeNodeList;
        }
        for (int i = start; i <= end; i++) {

            List<TreeNode> leftTreeNodes = recursionGenerate(start, i-1);

            List<TreeNode> rightTreeNodes = recursionGenerate(i+1, end);

            for (TreeNode leftTree : leftTreeNodes) {
                for (TreeNode rightTree : rightTreeNodes) {
                    TreeNode treeNode = new TreeNode(i);
                    treeNode.left = leftTree;
                    treeNode.right = rightTree;
                    treeNodeList.add(treeNode);
                }
            }
        }
        return treeNodeList;
    }


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        recursionSearch(result, root);
        return result;
    }

    //递归遍历
    public void recursionSearch(List<Integer> list, TreeNode node) {
        if (node != null) {
            recursionSearch(list, node.left);
            list.add(node.val);
            recursionSearch(list, node.right);
        }
    }

    public static void main(String[] args) {

        int n = 3;
        UniqueBinarySearchTreesII uniqueBinarySearchTreesII = new UniqueBinarySearchTreesII();
        List<TreeNode> list = uniqueBinarySearchTreesII.generateTrees(n);

        for (TreeNode treeNode : list) {
            List<Integer> integers = uniqueBinarySearchTreesII.inorderTraversal(treeNode);
            System.out.println(integers);
        }

        System.out.println("hello world");
    }

}
