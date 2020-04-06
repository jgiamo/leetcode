package main.java;

/**
 * 分割链表
 * 拆分成两个链表，最后在连接
 */
public class PartitionList {

    public static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode partition(ListNode head, int x) {
        ListNode guard1 = new ListNode(0);
        ListNode guard2 = new ListNode(0);

        ListNode tail1 = guard1;
        ListNode tail2 = guard2;
        while (head != null) {
            if (head.val < x) {
                tail1.next = head;
                tail1 = head;
            } else{
                tail2.next = head;
                tail2 = head;
            }
            head = head.next;
        }

        tail1.next = guard2.next;
        tail2.next = null;

        return guard1.next;

    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);

        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(2);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        PartitionList partitionList = new PartitionList();

        ListNode list = partitionList.partition(head, 3);

        while (list != null) {
            System.out.println(list.val);
            list = list.next;
        }

        System.out.println("hello world");
    }
}
