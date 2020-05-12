package main.java;

/**
 * 链表排序，用归并排序比较好
 */
public class SortList {

    static class ListNode {

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

    public ListNode sortList(ListNode head) {
//        return quickSort(head);
        return mergeSort(head);
    }

    //归并排序
    public ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode rightHead = slow.next;
        slow.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);
        ListNode helper = new ListNode(0);
        ListNode currentNode = helper;
        while(left != null && right != null){
            if(left.val < right.val){
                currentNode.next = left;
                left = left.next;
            }else{
                currentNode.next = right;
                right = right.next;
            }
            currentNode = currentNode.next;
        }

        currentNode.next = (left == null ? right : left);
        return helper.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        SortList sortList = new SortList();
        sortList.sortList(node1);

    }

}
