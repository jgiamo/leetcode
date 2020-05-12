package main.java;

/**
 * 给定一个链表，判断链表中是否有环。
 */
public class LinkedListCycle {

    public static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode fastNode = head;
        ListNode slowNode = head;

        while (fastNode.next != null && fastNode.next.next != null) {
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
            if (fastNode == slowNode) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;

        LinkedListCycle linkedListCycle = new LinkedListCycle();

        System.out.println(linkedListCycle.hasCycle(node1));
    }

}
