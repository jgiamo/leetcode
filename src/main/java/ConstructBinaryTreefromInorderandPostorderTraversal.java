package main.java;

/**
 * 根据中序遍历和后序遍历
 */
public class ConstructBinaryTreefromInorderandPostorderTraversal {

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode root = traceBuild(inorder, 0, inorder.length-1,postorder,0,postorder.length-1);
        return root;
    }
    public TreeNode traceBuild(int[] inorder,int inorderStart, int inorderEnd,int[]postorder,int postorderStart, int postorderEnd){

        if(inorderStart > inorderEnd){
            return null;
        }

        int parentValue = postorder[postorderEnd];
        TreeNode parent = new TreeNode(parentValue);
        if(inorderStart == inorderEnd){
            return parent;
        }

        int splitPos = inorderStart;
        for(;splitPos<inorderEnd;splitPos++){
            if(inorder[splitPos]==parentValue){
                break;
            }
        }
        int leftTreeLength = splitPos - inorderStart;

        parent.left=traceBuild(inorder,inorderStart,splitPos-1,postorder,postorderStart,postorderStart+leftTreeLength-1);
        parent.right=traceBuild(inorder,splitPos+1,inorderEnd,postorder,postorderStart+leftTreeLength,postorderEnd-1);
        return parent;
    }

    public static void main(String[] args) {

        int[] inorder = new int[]{};
        int[] postorder = new int[]{};
        ConstructBinaryTreefromInorderandPostorderTraversal constructBinaryTreefromInorderandPostorderTraversal = new ConstructBinaryTreefromInorderandPostorderTraversal();
        TreeNode node = constructBinaryTreefromInorderandPostorderTraversal.buildTree(inorder, postorder);

        System.out.println("hello world");
    }

}
