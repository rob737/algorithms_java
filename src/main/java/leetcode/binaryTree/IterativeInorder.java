package leetcode.binaryTree;

import java.util.Stack;

public class IterativeInorder {
    public static void main(String[] args) {
        Node root = constructTree();
        Stack<Node> stack = new Stack<>();
        Node curr = root;

        System.out.println("Iterative Inorder Traversal");

        while (!stack.isEmpty() || curr != null) {
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            System.out.print(" " + curr.value + " ");
            curr = curr.right;
        }
    }

    private static Node constructTree() {
        Node six = new Node(6);
        Node ten = new Node(10);
        Node four = new Node(4);
        Node five = new Node(5);
        Node eight = new Node(8);
        Node twelve = new Node(12);

        six.left = four;
        six.right = ten;
        four.right = five;
        ten.left = eight;
        ten.right = twelve;

        return six;
    }
}
