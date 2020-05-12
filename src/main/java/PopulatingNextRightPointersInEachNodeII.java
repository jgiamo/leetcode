package main.java;

/**
 * 找到每个节点的下一个右测节点指针，这里的树是一个普通的树。
 * 利用迭代的方法实现  **
 */
public class PopulatingNextRightPointersInEachNodeII {

    static class Node {

        Node left;
        Node right;
        Node next;
        int val;

        Node(int val) {
            this.val = val;
        }
    }


    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Node nextLevelHeadNode = null;
        Node preNode = null;

        Node current = root;

        while (current != null) {

            while (current != null) {
                if (current.left != null) {
                    if (preNode != null) {

                        preNode.next = current.left;
                    } else {
                        nextLevelHeadNode = current.left;
                    }
                    preNode = current.left;

                }
                if (current.right != null) {
                    if (preNode != null) {
                        preNode.next = current.right;
                    } else {
                        nextLevelHeadNode = current.right;
                    }
                    preNode = current.right;
                }
                current = current.next;
            }
            current = nextLevelHeadNode;
            preNode = null;

        }
        return root;
    }

    public static void main(String[] args) {
        Node tree = new Node(0);

        PopulatingNextRightPointersInEachNodeII populatingNextRightPointersInEachNodeII = new PopulatingNextRightPointersInEachNodeII();

        populatingNextRightPointersInEachNodeII.connect(tree);

        System.out.println();
    }
}
