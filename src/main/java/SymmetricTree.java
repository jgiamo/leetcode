package main.java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 判断一个树是不是对称的，
 * 递归的解法，一看就会，一写就不行。还是练习不够
 */
public class SymmetricTree {

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        return traverse(root, root);
    }

    public boolean traverse(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (right.val == left.val) {
            if (traverse(left.left, right.right) && traverse(left.right, right.left)) {
                return true;
            }
        }
        return false;
    }

        public static void main (String[]args){
            TreeNode parent = new TreeNode(0);

            TreeNode layer1LeftNode = new TreeNode(1);

            TreeNode layer1RightNode = new TreeNode(1);

            TreeNode layer2LeftNode = new TreeNode(2);

            parent.left = layer1LeftNode;
            parent.right = layer1RightNode;

            layer1RightNode.left = layer2LeftNode;

            SymmetricTree symmetricTree = new SymmetricTree();
            System.out.println(symmetricTree.isSymmetric(parent));

            System.out.println("hello world");
        }

    }
