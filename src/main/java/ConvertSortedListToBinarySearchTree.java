package main.java;

import apple.laf.JRSUIUtils.Tree;

/**
 * 将有序链表转化平衡二叉树，设置两个节点一快一慢就能找到中间的节点
 */
public class ConvertSortedListToBinarySearchTree {

    static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode sortedListToBST(ListNode head) {
        TreeNode treeNode = buildTree(head, null);
        return treeNode;
    }

    public TreeNode buildTree(ListNode head, ListNode tail) {
        if(head == tail){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != tail) {
            if (fast.next != tail) {
                fast = fast.next.next;
                slow = slow.next;
            } else {
                fast = fast.next;
            }
        }

        TreeNode treeNode = new TreeNode(slow.val);
        treeNode.left = buildTree(head, slow);
        treeNode.right = buildTree(slow.next, tail) ;
        return treeNode;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(0);
        ConvertSortedListToBinarySearchTree convertSortedListToBinarySearchTree = new ConvertSortedListToBinarySearchTree();
        TreeNode node = convertSortedListToBinarySearchTree.sortedListToBST(head);

        System.out.println("hello world");
    }

}
