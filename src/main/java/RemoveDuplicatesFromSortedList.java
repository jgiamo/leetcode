package main.java;

/**
 * 在有序链表中去除重复元素，相同元素只保留一个
 * 感觉链表的问题，我还需要反复练习
 */
public class RemoveDuplicatesFromSortedList {

    public static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode guard = new ListNode(-100);
        guard.next = head;

        ListNode node = head;

        ListNode preNode = guard;
        while (node != null) {
            if (node.val != preNode.val) {
                preNode.next = node;
                preNode = node;
            }
            node = node.next;
        }
        preNode.next = null;

        return guard.next;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(2);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        RemoveDuplicatesFromSortedList removeDuplicatesFromSortedList = new RemoveDuplicatesFromSortedList();

        ListNode list = removeDuplicatesFromSortedList.deleteDuplicates(head);

        while (list != null) {
            System.out.println(list.val);
            list = list.next;
        }

        System.out.println("hello world");
    }
}
