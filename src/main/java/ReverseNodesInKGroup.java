import java.util.List;

public class ReverseNodesInKGroup {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 0) {
            return head;
        }
        ListNode[] reverseNode = new ListNode[k];

        int i = 0;
        for (; i < k; i++) {
            if (head != null) {
                reverseNode[i] = head;
                head = head.next;
            } else {
                break;
            }
        }
        if (i == k) {
            ListNode nextPeriod = reverseNode[i - 1].next;
            for (i = i - 1; i > 0; i--) {
                reverseNode[i].next = reverseNode[i - 1];
            }
            reverseNode[i].next = reverseKGroup(nextPeriod, k);
            return reverseNode[k - 1];
        } else {
            return reverseNode[0];
        }
    }


    public static ListNode anotherReverseKGroup(ListNode head, int k) {
        if (k <= 0) {
            return head;
        }
        int count = 0;
        ListNode cur = head;
        for (; count < k; count++) {
            if (cur != null) {
                cur = cur.next;
            } else {
                return head;
            }
        }
        ListNode nextNode = head.next;
        head.next = anotherReverseKGroup(cur, k);
        cur = nextNode;

        while (count > 1) {
            nextNode = cur.next;
            cur.next = head;
            head = cur;
            cur = nextNode;
            count--;
        }
        return head;
    }

    public void reverse() {

    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(0);
        ListNode node10 = new ListNode(1);
        ListNode node11 = new ListNode(2);
        ListNode node12 = new ListNode(3);
        ListNode node13 = new ListNode(4);
        ListNode node14 = new ListNode(5);

        head1.next = node10;
        node10.next = node11;
        node11.next = node12;
        node12.next = node13;
        node13.next = node14;


        ListNode newHead = anotherReverseKGroup(head1, 3);
//        ListNode newHead = anotherSwapPairs(head1);

        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }

        System.out.println("hello world");
        System.out.println();
        System.out.println("hello world");
    }
}
