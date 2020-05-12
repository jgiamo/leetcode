package main.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。
 */
public class CloneGraph {

    static class Node {

        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }


    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        Map<Node, Node> visitNodeMap = new HashMap<>();
        visitNodeMap.put(node, new Node(1));

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            List<Node> neightbors = currentNode.neighbors;

            for (int i = 0; i < neightbors.size(); i++) {
                Node neighborNode = neightbors.get(i);
                if(!visitNodeMap.containsKey(neighborNode)) {
                    visitNodeMap.put(neighborNode, new Node(neighborNode.val, new ArrayList<>()));
                    queue.add(neighborNode);
                }

                visitNodeMap.get(currentNode).neighbors.add(visitNodeMap.get(neighborNode));
            }
        }

        return visitNodeMap.get(node);
    }


    public static void main(String[] args) {
        CloneGraph cloneGraph = new CloneGraph();

        cloneGraph.cloneGraph(new Node(0));


    }

}
