package main.java;

import java.util.HashMap;
import java.util.Map;

/**
 * 链表插入排序
 */
public class InsertionSortList {

     static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode insertionSortList(ListNode head) {
        ListNode guard = new ListNode(Integer.MIN_VALUE);
        ListNode node = head;
        while(node != null){
            ListNode nextNode = node.next;

            ListNode sortNode = guard;
            while(sortNode.next != null && node.val > sortNode.next.val){
                sortNode = sortNode.next;
            }
            node.next = sortNode.next;
            sortNode.next = node;

            node = nextNode;
        }

        return guard.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        InsertionSortList insertionSortList = new InsertionSortList();
        insertionSortList.insertionSortList(node1);

    }

}
