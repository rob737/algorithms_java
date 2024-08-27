package leetcode.binaryTree;

public class DistanceTwoNodes {

    static class Node {
        int key;
        Node left, right;

        Node(int data) {
            key = data;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        int key1 = 13, key2 = 16;

        // construct tree
        Node root = constructTree();
        // find LCA
        Node LCA = findLCA(root, key1, key2);

        System.out.println("LCA : " + LCA.key);
        // find level
        int shortestDistance = findPath(LCA, key1, key2, 0);
        System.out.println("Shortest Distance : " + shortestDistance);
    }

    private static int findPath(Node lca, int key1, int key2, int level) {

        if (lca == null)
            return 0;
        if (lca.key == key1 || lca.key == key2)
            return level;

        int left = findPath(lca.left, key1, key2, level + 1);
        int right = findPath(lca.right, key1, key2, level + 1);

        if (left != 0 && right != 0)
            return left + right;

        if (left != 0) return left;
        else if (right != 0) return right;
        else
            return 0;
    }

    private static Node findLCA(Node root, int key1, int key2) {

        if (root == null)
            return null;
        if (root.key == key1 || root.key == key2)
            return root;

        Node left = findLCA(root.left, key1, key2);
        Node right = findLCA(root.right, key1, key2);

        if (left != null && right != null) {
            return root;
        }

        if (left != null) return left;
        if (right != null) return right;
        else return null;
    }

    private static Node constructTree() {
        Node node12 = new Node(12);
        Node node4 = new Node(4);
        Node node13 = new Node(13);
        Node node2 = new Node(2);
        Node node9 = new Node(9);
        Node node26 = new Node(26);
        Node node22 = new Node(22);
        Node node25 = new Node(25);
        Node node16 = new Node(16);
        Node node32 = new Node(32);

        node12.left = node4;
        node12.right = node25;

        node4.left = node13;
        node4.right = node9;

        node13.left = node2;

        node9.left = node26;
        node9.right = node22;

        node25.left = node16;
        node25.right = node32;

        return node12;
    }
}
