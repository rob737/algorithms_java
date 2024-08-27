package leetcode.binaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class IPreOrder {

    public static void main(String[] args) {
        Node root = constructTree();

        Stack<Node> stack = new Stack<>();
        Queue<Node> queue = new LinkedList<>();

        preOrderTraversal(root, stack, queue);

        System.out.println("Pre-Order Traversal");
        while (!queue.isEmpty()) {
            System.out.print(" " + queue.remove().value + " " );
        }

    }

    private static void preOrderTraversal(Node root, Stack<Node> stack, Queue<Node> queue) {

        stack.push(root);
        Node curr;

        while (!stack.isEmpty()){
            curr = stack.pop();
            queue.add(curr);

            if(curr.right != null)
                stack.push(curr.right);
            if(curr.left != null)
                stack.push(curr.left);
        }

    }

    private static Node constructTree() {

        Node six = new Node(6);
        Node four = new Node(4);
        Node one = new Node(1);
        Node five = new Node(5);
        Node ten = new Node(10);
        Node eight = new Node(8);
        Node twelve = new Node(12);

        six.left = four;
        six.right = ten;

        four.left = one;
        four.right = five;

        ten.left = eight;
        ten.right = twelve;

        return six;
    }


}
