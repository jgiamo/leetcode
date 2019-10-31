import java.util.List;

public class SwapNodesInPairs {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode firstNode = new ListNode(0);
        firstNode.next = head;
        ListNode start = firstNode;
        while (start.next != null) {
            ListNode frontHead = start.next;
            if (frontHead.next != null) {
                ListNode backHead = frontHead.next;

                frontHead.next = backHead.next;
                backHead.next = frontHead;
                start.next = backHead;

                start = frontHead;
            } else {
                break;
            }
        }
        return firstNode.next;
    }

    public static ListNode anotherSwapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode nextNode = head.next;
        head.next = anotherSwapPairs(head.next.next);
        nextNode.next = head;
        return nextNode;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(0);
        ListNode node10 = new ListNode(1);
        ListNode node11 = new ListNode(2);


        head1.next = node10;
        node10.next = node11;


        ListNode newHead = swapPairs(head1);
//        ListNode newHead = anotherSwapPairs(head1);

        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }

        System.out.println("hello world");
        System.out.println();
    }
}
