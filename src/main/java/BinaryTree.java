import java.util.Stack;

/**
 * Created by jingjie on 2018/5/10.
 */
public class BinaryTree {
    static class Node {
        Node leftNode;
        Node rightNode;
        int val;

        Node(int val) {
            this.val = val;
        }
    }

    static void preOrderSearch(Node Tree) {
        if (Tree == null) {
            return;
        }
        System.out.println(Tree.val);
        preOrderSearch(Tree.leftNode);
        preOrderSearch(Tree.rightNode);
    }

    static void preOrderSearchNoRecursive(Node Tree) {
        Stack<Node> stack = new Stack<>();
        if (Tree != null) {
            stack.push(Tree);
        }

        while(!stack.empty()){
            Node node = stack.pop();
            if(node == null){
                continue;
            }
            System.out.println(node.val);
            stack.push(node.rightNode);
            stack.push(node.leftNode);
        }
    }

    public static void main(String[] args) {
        Node tree = new Node(0);
        Node tree1 = new Node(1);
        Node tree2 = new Node(2);
        Node tree3 = new Node(3);
        Node tree4 = new Node(4);
        Node tree5 = new Node(5);
        Node tree6 = new Node(6);

        tree.leftNode = tree1;
        tree.rightNode = tree2;

        tree1.leftNode = tree3;
        tree1.rightNode = tree4;

        tree2.leftNode = tree5;
        tree2.rightNode = tree6;

        preOrderSearch(tree);
        preOrderSearchNoRecursive(tree);
        System.out.println();
    }
}
