package main.java;

import main.java.LinkedListCycle.ListNode;

/**
 * 给定一个链表，判断链表中是否有环。环的入口节点
 * 我的方法其实复杂了，加了一次循环，实际上第二次循环求长度没有必要，直接用第一次循环后的head和slow开始第三次循环就可以了。因为环入口节点：kn+a，
 */
public class LinkedListCycleII {

    public static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode fastNode = head;
        ListNode slowNode = head;

        boolean hasCycle = false;

        while (fastNode.next != null && fastNode.next.next != null) {
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
            if (fastNode == slowNode) {
                hasCycle = true;
                break;
            }
        }

        if(!hasCycle){
            return null;
        }
        //求环的长度
        int len = 1;
        fastNode = fastNode.next;
        while(fastNode != slowNode){
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
            len ++;
        }

        slowNode = head;
        fastNode = head;
        for(int i=1;i<=len;i++){
            fastNode = fastNode.next;
        }
        while(fastNode!=slowNode){
            slowNode = slowNode.next;
            fastNode = fastNode.next;
        }
        return slowNode;


    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;

        LinkedListCycleII linkedListCycleII = new LinkedListCycleII();

        System.out.println(linkedListCycleII.detectCycle(node1));
    }

}
