package leetcode.binaryTree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseLevelOrderTraversal {

    private static int n = 0;


    public static void main(String[] args) {
        Node root = constructTree();
        Stack<Node> s = new Stack();
        Queue<Node> q = new LinkedList<>();

        reverseLevelOrder(root,s,q);

        System.out.println("Reverse Level Order Traversal");
        while (!s.empty()){
            System.out.print(" " + s.pop().value +" ");
        }


        /*
        * Level Order Traversal logic
        * int[] arr = new int[n];
        LOT(root, 0, arr);
        System.out.println("Level Order Traversal : ");
        print(arr);
        * */
    }

    private static void reverseLevelOrder(Node root, Stack<Node> s, Queue<Node> q) {
        q.add(root);
        Node node;

        while(q.isEmpty() == false) {
            node = q.peek();
            q.remove();
            s.push(node);

            if(node.right != null)
                q.add(node.right);
            if(node.left != null)
                q.add(node.left);

        }

    }


    private static void print(int[] arr) {
        for (int v : arr)
            System.out.print(v + " ");
    }

    private static void LOT(Node root, int i, int[] arr) {
        if (root == null)
            return;
        arr[i] = root.value;
        LOT(root.left, 2 * i + 1, arr);
        LOT(root.right, 2 * i + 2, arr);
    }

    private static Node constructTree() {

        Node one = new Node(1);
        n++;
        Node two = new Node(2);
        n++;
        Node three = new Node(3);
        n++;
        Node four = new Node(4);
        n++;
        Node five = new Node(5);
        n++;
        Node six = new Node(6);
        n++;
        Node seven = new Node(7);
        n++;
        Node eight = new Node(8);
        Node nine = new Node(9);

        one.left = two;
        one.right = three;
        two.left = four;
        two.right = five;
        three.left = six;
        three.right = seven;
        seven.left=eight;
        seven.right=nine;

        return one;
    }
}
