package main.java;

/**
 * 链表部分反转。
 * 感动，竟然一次通过了
 */
public class ReverseLinkedListII {

    public static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode guard = new ListNode(0);
        guard.next = head;

        int i = 1;
        ListNode firstPreNode = guard;
        ListNode firstNode = head;
        for (; i < m; i++) {
            firstPreNode = firstPreNode.next;
            firstNode = firstNode.next;
        }

        ListNode preNode = firstNode;
        ListNode node = preNode.next;
        ListNode tmp = null;
        for (; i < n; i++) {
            tmp = node.next;
            node.next = preNode;
            preNode = node;
            node = tmp;
        }
        ListNode lastNode  = preNode;
        ListNode lastNextNode = node;

        firstPreNode.next = lastNode;
        firstNode.next = lastNextNode;

        return guard.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;

        ReverseLinkedListII reverseLinkedListII = new ReverseLinkedListII();
        ListNode head = reverseLinkedListII.reverseBetween(node1, 2, 2);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }

        System.out.println("hello world");
    }

}
