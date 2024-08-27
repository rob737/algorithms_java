package leetcode.binaryTree;

import java.util.ArrayList;
import java.util.List;

public class SerializeDeSerialize {

    static List<Integer> preOrder = new ArrayList<>();
    private static int index = -1;

    public static void main(String[] args) {
        Node root = constructTree();

        populatePreOrderArray(root);
        Node deserializedRoot = desierializeBinaryTree();
        System.out.println("Printing Deserialized Binary Tree");
        preOrderTraversal(deserializedRoot);
    }

    private static void preOrderTraversal(Node node) {

        if (node == null)
            return;

        System.out.print(" " + node.value + " ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    private static Node desierializeBinaryTree() {

        index++;
        if (preOrder.get(index) == -1) {
            return null;
        }
        Node node = new Node(preOrder.get(index));

        node.left = desierializeBinaryTree();
        node.right = desierializeBinaryTree();

        return node;
    }

    private static void populatePreOrderArray(Node node) {
        if (node == null) {
            preOrder.add(-1);
            return;
        }

        preOrder.add(node.value);
        populatePreOrderArray(node.left);
        populatePreOrderArray(node.right);
    }

    private static Node constructTree() {
        Node one = new Node(1);
        Node two = new Node(2);
        Node four = new Node(4);
        Node five = new Node(5);
        Node eight = new Node(8);
        Node three = new Node(3);
        Node six = new Node(6);
        Node seven = new Node(7);

        one.left = two;
        one.right = three;
        two.left = four;
        two.right = five;
        three.left = six;
        three.right = seven;
        five.left = eight;

        return one;
    }
}
