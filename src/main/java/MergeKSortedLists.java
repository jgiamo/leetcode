import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public static ListNode mergeKLists(ListNode[] lists) {

        ListNode smallestNode = null;
        int pos = -1;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] == null) {
                continue;
            }
            if (smallestNode == null || lists[i].val < smallestNode.val) {
                smallestNode = lists[i];
                pos = i;
            }
        }
        if (smallestNode == null) {
            return null;
        }
        lists[pos] = lists[pos].next;
        smallestNode.next = mergeKLists(lists);
        return smallestNode;
    }

    public static ListNode anotherMergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(lists.length + 1, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return (o1.val - o2.val);
            }
        });
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] == null) {
                continue;
            }
            priorityQueue.add(lists[i]);
        }
        ListNode smallestNode = new ListNode(0);
        ListNode resultNode = smallestNode;
        while (!priorityQueue.isEmpty()) {
            ListNode listNode = priorityQueue.poll();
            resultNode.next = listNode;
            resultNode = resultNode.next;
            if (listNode.next != null) {
                priorityQueue.add(listNode.next);
            }
        }
        return smallestNode.next;
    }


    public static void main(String[] args) {
        ListNode head1 = new ListNode(0);
        ListNode node10 = new ListNode(1);
        ListNode node11 = new ListNode(2);


        ListNode head2 = new ListNode(1);
        ListNode node20 = new ListNode(2);
        ListNode node21 = new ListNode(5);

        ListNode head3 = new ListNode(3);
        ListNode node30 = new ListNode(4);
        ListNode node31 = new ListNode(7);

//        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(5, new Comparator<ListNode>() {
//            @Override
//            public int compare(ListNode o1, ListNode o2) {
//                return (o1.val - o2.val);
//            }
//        });
//        priorityQueue.add(head1);
//        priorityQueue.add(node21);
//        priorityQueue.add(node20);
//        priorityQueue.add(node30);
//        while(!priorityQueue.isEmpty()){
//            System.out.println(priorityQueue.poll().val);
//        }


        head1.next = node10;
        node10.next = node11;

        head2.next = node20;
        node20.next = node21;

        head3.next = node30;
        node30.next = node31;

        ListNode[] listNodes = new ListNode[0];
//        listNodes[0] = head1;
//        listNodes[1] = head2;
//        listNodes[2] = head3;


        ListNode mergeHead = anotherMergeKLists(listNodes);

        while (mergeHead != null) {
            System.out.println(mergeHead.val);
            mergeHead = mergeHead.next;
        }

        System.out.println("hello world");
        System.out.println();
    }
}
