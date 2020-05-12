package main.java;

/**
 * 相交链表的交点。
 * 这道题看了解法，太巧妙了。 ***
 * 按照评论的说法太浪漫了。

 */
public class IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode node1 = headA;
        ListNode node2 = headB;

        while(node1 != null && node2 != null) {
            node1 = node1.next;
            node2 = node2.next;
        }
        if(node1 == null) node1 = headB;
        if(node2 == null) node2 = headA;

        while(node1 != null && node2 != null) {
            node1 = node1.next;
            node2 = node2.next;
        }
        if(node1 == null) node1 = headB;
        if(node2 == null) node2 = headA;


        while(node1 != null && node2 != null) {
            if(node1 == node2){
                return node1;
            }
            node1 = node1.next;
            node2 = node2.next;
        }

        return null;
    }
    public static class ListNode {
        ListNode(int x) {
            val = x;
        }

        int val;
        ListNode next;
    }

}
