package main.java;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 找到每个节点的下一个右测节点指针,这颗树是完美二叉树   **
 * 只想到了层序遍历，其实可以将二叉树劈为两半，递归遍历
 */
public class PopulatingNextRightPointersInEachNode {
    static class Node {
        Node left;
        Node right;
        Node next;
        int val;

        Node(int val) {
            this.val = val;
        }
    }

//    //层序遍历
//    public Node connect(Node root) {
//
//        Queue<Node> queue = new LinkedList<>();
//        queue.add(root);
//
//
//        while(!queue.isEmpty()){
//            Node preNode = null;
//            int levelSize = queue.size();
//
//            for(int i=0;i<levelSize;i++) {
//                Node currentNode = queue.poll();
//
//                if (preNode != null) {
//                    preNode.next = currentNode;
//                }
//
//                if (currentNode.leftNode != null) queue.add(currentNode.leftNode);
//                if (currentNode.rightNode != null)queue.add(currentNode.rightNode);
//
//                preNode = currentNode;
//            }
//            preNode.next = null;
//        }
//        return root;
//    }

    public Node connect(Node root) {
        if(root == null){
            return root;
        }
        Node left = root.left;
        Node right = root.right;
        while(left != null && right !=null){
            left.next = right;
            left = left.right;
            right = right.left;
        }
        connect(root.left);
        connect(root.right);
        return root;
    }

    public static void main(String[] args) {
        Node tree = new Node(0);

        PopulatingNextRightPointersInEachNode populatingNextRightPointersInEachNode = new PopulatingNextRightPointersInEachNode();

        populatingNextRightPointersInEachNode.connect(tree);

        System.out.println();
    }
}
