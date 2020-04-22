package main.java;

/**
 * 判断一个树是不是二叉搜索树
 */
public class SameTree {

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null){
            return true;
        }else if(p== null && q!=null){
            return false;
        }else if(p!=null && q==null){
            return false;
        }else{
            if(p.val!=q.val){
                return false;
            }
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
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

        SameTree sameTree = new SameTree();
        System.out.println(sameTree.isSameTree(parent,parent));

        System.out.println("hello world");
    }

}
