package main.java;

/**
 * 判断一个树是不是二叉搜索树
 */
public class RecoverBinarySearchTree {

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    TreeNode firstSwapNode = null;
    TreeNode secondSwapNode =null;
    TreeNode lastNode =null;
    public void recoverTree(TreeNode root) {
        trace(root);
        if(firstSwapNode!=null && secondSwapNode!=null){
            int tmp = firstSwapNode.val;
            firstSwapNode.val = secondSwapNode.val;
            secondSwapNode.val = tmp;
        }
    }

    public void trace(TreeNode node){
        if(node==null){
            return;
        }

        trace(node.left);

        if(lastNode!=null){
            if(node.val < lastNode.val){
                if(firstSwapNode==null){
                    firstSwapNode=lastNode;
                    secondSwapNode = node;
                }else{
                    secondSwapNode=node;
                }
            }
        }
        lastNode = node;

        trace(node.right);
    }


    public static void main(String[] args) {
        TreeNode parent = new TreeNode(0);

        TreeNode layer1LeftNode = new TreeNode(1);

        TreeNode layer1RightNode = new TreeNode(2);

        TreeNode layer2LeftNode = new TreeNode(3);

        parent.left = layer1LeftNode;
        parent.right = layer1RightNode;

        layer1RightNode.left = layer2LeftNode;

        RecoverBinarySearchTree recoverBinarySearchTree = new RecoverBinarySearchTree();
        recoverBinarySearchTree.recoverTree(parent);

        System.out.println("hello world");
    }

}
