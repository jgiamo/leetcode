import java.util.List;

/**
 * Created by jingjie on 2018/4/11.
 */
public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode node = head;
        int posNum = 0;
        while (l1 != null || l2 != null) {
            int sum;
            if (l1 == null) {
                sum = l2.val + posNum;
                l2 = l2.next;
            } else if (l2 == null) {
                sum = l1.val + posNum;
                l1 = l1.next;
            } else {
                sum = l1.val + l2.val + posNum;
                l1 = l1.next;
                l2 = l2.next;
            }
            posNum = sum / 10;
            sum = sum % 10;
            ListNode nextNode = new ListNode(sum);
            node.next = nextNode;
            node = nextNode;
        }
        if (posNum > 0) {
            node.next = new ListNode(posNum);
        }
        return head.next;
    }

    public static class ListNode {
        ListNode(int x) {
            val = x;
        }

        int val;
        ListNode next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode n11 = new ListNode(8);
//        ListNode n12 = new ListNode(0);
        l1.next = n11;
//        n11.next = n12;

        ListNode l2 = new ListNode(0);
//        ListNode n21 = new ListNode(2);
//        ListNode n22 = new ListNode(9);
//        l2.next = n21;
//        n21.next = n22;

        ListNode mergeL = addTwoNumbers(l1, l2);
        while (mergeL.next != null) {
            System.out.println(mergeL.val);
            mergeL = mergeL.next;
        }
        System.out.println(mergeL.val);


    }
}
