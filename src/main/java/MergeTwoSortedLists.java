public class MergeTwoSortedLists {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l0 = new ListNode(0);

        ListNode myNode = l0;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                myNode.next = l1;
                l1 = l1.next;
            } else {
                myNode.next = l2;
                l2 = l2.next;
            }
            myNode = myNode.next;
        }

        if (l1 != null) {
            myNode.next = l1;
        }
        if (l2 != null) {
            myNode.next = l2;
        }

        return l0.next;
    }


    public static ListNode otherFunctionMergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        if (l1.val < l2.val) {
            l1.next = otherFunctionMergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = otherFunctionMergeTwoLists(l2.next, l1);
            return l2;
        }
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(0);
        ListNode node10 = new ListNode(1);
        ListNode node11 = new ListNode(2);


        ListNode head2 = new ListNode(1);
        ListNode node20 = new ListNode(2);
        ListNode node21 = new ListNode(5);

        head1.next = node10;
        node10.next = node11;

        head2.next = node20;
        node20.next = node21;

        ListNode mergeHead = mergeTwoLists(head1, head2);

        while (mergeHead != null) {
            System.out.println(mergeHead.val);
            mergeHead = mergeHead.next;
        }

        System.out.println("hello world");
    }
}
