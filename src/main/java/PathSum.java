package main.java;


/**
 * 一棵树的存在一条路径，等于sum
 */
public class PathSum {

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        return isPathCorrect(root, sum, 0);
    }

    public boolean isPathCorrect(TreeNode root, int sum,int currentSum){
        if(root == null){
            return false;
        }
        int val = root.val;
        currentSum = currentSum + val;
        if(root.left == null && root.right == null){
            if(currentSum == sum){
                return true;
            }else{
                return false;
            }
        }
        return isPathCorrect(root.left, sum ,currentSum) || isPathCorrect(root.right, sum ,currentSum);
    }


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(0);
        PathSum pathSum = new PathSum();
        System.out.println(pathSum.hasPathSum(treeNode,0));

        System.out.println("hello world");
    }

}
