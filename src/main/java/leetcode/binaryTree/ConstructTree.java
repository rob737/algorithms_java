package leetcode.binaryTree;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;


/*
 * Need to practice it again as solution is not full proof.
 * */
public class ConstructTree {

    static class Node {
        Node left, right;
        int key;
    }

    ;

    static Node newNode(int data) {
        Node node = new Node();
        node.key = data;
        node.left = node.right = null;
        return (node);
    }

    ;


    public static void main(String[] args) {

        int postOrder[] = {8, 4, 5, 2, 6, 7, 3, 1};
        int inOrder[] = {4, 8, 2, 5, 1, 6, 3, 7};

        Node root = construct(inOrder, postOrder);

        System.out.print("Inorder      : ");
        printInOrder(root);

        System.out.print("\nPostorder : ");
        printPostOrder(root);

    }

    public static Node construct(int[] inorder, int[] postorder) {
        int n = inorder.length;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        AtomicInteger pIndex = new AtomicInteger(n - 1);
        return construct(0, n - 1, postorder, pIndex, map);
    }

    public static Node construct(int start, int end, int[] postorder, AtomicInteger pIndex, Map<Integer, Integer> map) {
        if (start > end) {
            return null;
        }
        Node root = newNode(postorder[pIndex.getAndDecrement()]);
        int index = map.get(root.key);
        root.right = construct(index + 1, end, postorder, pIndex, map);
        root.left = construct(start, index - 1, postorder, pIndex, map);
        return root;
    }


    private static void printPostOrder(Node node) {
        if (node == null)
            return;

        printInOrder(node.left);
        printInOrder(node.right);
        System.out.print(" " + node.key + " ");
    }

    private static void printInOrder(Node node) {
        if (node == null)
            return;

        printInOrder(node.left);
        System.out.print(" " + node.key + " ");
        printInOrder(node.right);
    }


}
