package main.java;

import java.util.HashMap;
import java.util.Map;

/**
 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。

 要求返回这个链表的 深拷贝。
 */
public class CopyListWithRandomPointer {

    static class Node {

        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> cloneNodeMap = new HashMap<>();

        Node node = head;
        cloneNodeMap.put(node, new Node(node.val));
        while (node != null) {
            Node cloneNode = cloneNodeMap.get(node);

            if (node.next != null) {
                Node cloneNextNode = cloneNodeMap.getOrDefault(node.next, new Node(node.next.val));
                cloneNodeMap.put(node.next, cloneNextNode);
                cloneNode.next = cloneNextNode;
            }

            if (node.random != null) {
                Node cloneNextNode = cloneNodeMap
                    .getOrDefault(node.random, new Node(node.random.val));
                cloneNodeMap.put(node.random, cloneNextNode);
                cloneNode.random = cloneNextNode;
            }

            node = node.next;
        }
        return cloneNodeMap.get(head);
    }

    public static void main(String[] args) {
        CopyListWithRandomPointer copyListWithRandomPointer = new CopyListWithRandomPointer();

        copyListWithRandomPointer.copyRandomList(new Node(1));


    }

}
