package main.java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 96 生成二叉搜索树。做了前一题后，这一题也算是用动态规划做出来了。确实巧妙
 */
public class UniqueBinarySearchTrees {

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int numTrees(int n) {
        int[] array = new int[n + 1];
        array[0] = 1;
        array[1] = 1;

        for (int i = 2; i <= n; i++) {

            int sum = 0;
            for (int j = 0; j < i; j++) {
                sum = sum + array[j] * array[i - 1 - j];
            }
            array[i] = sum;
        }

        return array[n];
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

        int n = 17;
        UniqueBinarySearchTrees uniqueBinarySearchTreesII = new UniqueBinarySearchTrees();
        int num = uniqueBinarySearchTreesII.numTrees(n);

        System.out.println(num);
    }

}
