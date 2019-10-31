public class RemoveNthNodeFromEndofList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode preNode = head;
        ListNode node = head;
        while (n > 0) {
            if (node == null) {
                return head;
            }
            node = node.next;
            n--;
        }
        if (node == null) {
            return head.next;
        }
        while (node.next != null) {
            node = node.next;
            preNode = preNode.next;
        }

        preNode.next = preNode.next.next;

        return head;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(0);

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        removeNthFromEnd(head, 5);

        while (head.next != null) {
            System.out.println(head.val);
            head = head.next;
        }
        System.out.println(head.val);

        System.out.println("hello world");
    }
}
