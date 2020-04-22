package main.java;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 一棵树的存在一条路径，等于sum
 */
public class PathSumII {

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<List<Integer>> result = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        getPath(root, sum ,0, new ArrayList<>() );
        return result;
    }

    public void getPath(TreeNode root, int sum, int currentSum, List<Integer> list){
        if(root == null){
            return;
        }
        currentSum = currentSum + root.val;
        list.add(root.val);
        if(root.left == null && root.right == null){
            if(currentSum == sum){
                result.add(new ArrayList(list));
            }
        }
        getPath(root.left,sum,currentSum,list);
        getPath(root.right,sum,currentSum,list);

        list.remove(list.size()-1);

    }

}
