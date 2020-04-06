package main.java;

/**
 * 在有序链表中去除重复元素  ***
 * 要多练习这种题目。
 * 网上的方法和我不一样，内部有个循环，先找到和下一个元素不一样的元素
 */
public class RemoveDuplicatesFromSortedListII {

    public static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode guard = new ListNode(0);
        guard.next = head;

        ListNode node = head;

        ListNode preNode = guard;


        ListNode perpareNode = null;
        int preVal = -100;
        while (node != null) {
            if (node.val != preVal) {
                //如果这个node和前一个node不相等，前一个prepareNode加入到链表中
                if (perpareNode != null) {
                    preNode.next = perpareNode;
                    preNode = perpareNode;/**/
                }
                //如果这个node和前一个node不相等，当前node变为准备node。
                perpareNode = node;
            } else{
                perpareNode = null;
            }
            preVal = node.val;
            node = node.next;
        }
        preNode.next = perpareNode;

        return guard.next;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(5);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        RemoveDuplicatesFromSortedListII removeDuplicatesFromSortedListII = new RemoveDuplicatesFromSortedListII();

        ListNode list = removeDuplicatesFromSortedListII.deleteDuplicates(head);

        while (list != null) {
            System.out.println(list.val);
            list = list.next;
        }

        System.out.println("hello world");
    }
}
