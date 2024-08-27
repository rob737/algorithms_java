package leetcode.binaryTree;

public class SumTree {
    static class Node {
        int value;
        Node left, right;

        Node(int key) {
            value = key;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        Node root = preconstructTree();
        constructSumTree(root);
        System.out.println("InOrder Traversal ....");
        printNodes(root);
    }

    private static void printNodes(Node node) {
        if(node == null)
            return;
        printNodes(node.left);
        System.out.printf("%s ", node.value);
        printNodes(node.right);
    }

    private static int constructSumTree(Node node) {
        if(node == null)
            return 0;
        int left = constructSumTree(node.left);
        int right = constructSumTree(node.right);
        int originalValue = node.value;
        node.value = left + right;
        return originalValue + node.value;
    }

    private static Node preconstructTree() {
        Node ten = new Node(10);
        Node nThree = new Node(-3);
        Node nine = new Node(9);
        Node nFour = new Node(-4);
        Node four = new Node(4);
        Node six = new Node(6);
        Node five = new Node(5);

        ten.left = nThree;
        ten.right = four;

        nThree.left = nine;
        nThree.right = nFour;

        four.left = six;
        four.right = five;

        return ten;
    }
}
