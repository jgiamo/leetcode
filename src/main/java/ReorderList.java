package main.java;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ， 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * 有另一种解法，其实可以将链表拆分为两个链表：1。找到中位节点，通过快慢指针 2。后面的链表逆序 3。两个链表合并
 */
public class ReorderList {

    public static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public void reorderList(ListNode head) {
        if(head == null){
            return;
        }
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode node = head;
        int end = 0;
        while (node != null) {
            map.put(end++, node);
            node = node.next;
        }
        int start = 0;
        end--;
        while (start < end) {
            map.get(start).next = map.get(end);

            if (start + 1 < end) {
                map.get(end).next = map.get(start + 1);
            }

            start++;
            end--;
        }
        map.get(start).next = null;

    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ReorderList reorderList = new ReorderList();

        reorderList.reorderList(node1);
    }

}
