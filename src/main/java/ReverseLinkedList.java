package main.java;

/**
 * 链表反转
 */
public class ReverseLinkedList {

    public class ListNode {

        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode node = null;
        ListNode nextNode = head;
        while (nextNode != null) {
            ListNode tmp = nextNode.next;
            nextNode.next = node;

            node = nextNode;
            nextNode = tmp;
        }
        return node;

    }


}

