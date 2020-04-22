package main.java;

import apple.laf.JRSUIUtils.Tree;

/**
 * 根据前序遍历中序遍历构造树。通过前序遍历知道根节点，在中序遍历找到对应的位置，就可以分离出左右子树。
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal {

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode treeNode = traceBuild(preorder, 0, preorder.length - 1, inorder, 0,
            inorder.length - 1);
        return treeNode;
    }

    //这里其实中序遍历没必要写出来，可以一开始用一个map表示后，中序遍历就没用了。因为没有重复元素
    public TreeNode traceBuild(int[] preOrder, int preOrderStart, int preOrderEnd, int[] inorder,
        int inOrderStart, int inOrderEnd) {

        if(preOrderStart > preOrderEnd || inOrderStart > inOrderEnd){
            return null;
        }
        int parentVal = preOrder[preOrderStart];
        TreeNode parent = new TreeNode(parentVal);
        if(preOrderStart == preOrderEnd || inOrderStart == inOrderEnd){
            return parent;
        }

        //找到父亲节点在中序遍历的位置
        int splitPos = inOrderStart;
        for (; splitPos <= inOrderEnd; splitPos++) {
            if (inorder[splitPos] == parentVal) {
                break;
            }
        }
        int leftNum = splitPos - inOrderStart;


        parent.left = traceBuild(preOrder, preOrderStart + 1, preOrderStart + leftNum, inorder,
            inOrderStart, splitPos - 1);
        parent.right = traceBuild(preOrder, preOrderStart + leftNum + 1, preOrderEnd, inorder, splitPos + 1, inOrderEnd);
        return parent;
    }


    public static void main(String[] args) {

        int[] preOrder = new int[]{};
        int[] inOrder = new int[]{};
        ConstructBinaryTreefromPreorderandInorderTraversal constructBinaryTreefromPreorderandInorderTraversal = new ConstructBinaryTreefromPreorderandInorderTraversal();
        TreeNode node = constructBinaryTreefromPreorderandInorderTraversal
            .buildTree(preOrder, inOrder);

        System.out.println("hello world");
    }

}
