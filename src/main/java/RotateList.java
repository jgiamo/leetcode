package main.java;

/**
 * 往右侧转移链表k次，需要找到三个节点。另外如果k%n=0，就不需要转移了
 */
public class RotateList {

    public static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return null;
        }
        ListNode guard = new ListNode(0);
        guard.next = head;
        ListNode node = guard;
        ListNode preNode, nowNode, finalNode = head;
        int len = 0;
        while (node.next != null) {
            len++;
            node = node.next;
            finalNode = node;
        }
        k = k % len;
        if(k == 0){
            return head;
        }

        node = head;

        //找到要放到开头节点的前一个节点
        for (int i = 0; i < len - k - 1; i++){
            node = node.next;
        }
        //这里可以在前面循环的时候，连上环，这里只要把环断开就可以了
        preNode = node;
        nowNode = node.next;

        preNode.next = null;
        finalNode.next = guard.next;
        guard.next = nowNode;

        return guard.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;

        RotateList rotateList = new RotateList();
        ListNode head = rotateList.rotateRight(node1, 5);

        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }

        System.out.println("hello world");
    }

}
