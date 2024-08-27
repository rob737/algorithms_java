package leetcode.binaryTree;

public class MaxSumPathNode {
    private static int result = 0;

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
        findMaxSum(root);
        System.out.println("Max sum path : " + result);
    }

    private static int findMaxSum(Node node) {
        if (node == null)
            return 0;

        int left = findMaxSum(node.left);
        int right = findMaxSum(node.right);
        int leftPathSum = node.value + left;
        int rightPathSum = node.value + right;

        int maxSum = Math.max(Math.max(leftPathSum, rightPathSum), node.value);
        result = Math.max(maxSum, left + right + node.value);

        return maxSum;
    }

    private static Node preconstructTree() {
        Node ten = new Node(10);
        Node two = new Node(2);
        Node nFour = new Node(-4);
        Node nSix = new Node(-6);
        Node twentyEight = new Node(28);
        Node nTwentyTwo = new Node(-22);
        Node fifteen = new Node(15);
        Node nTwentyFive = new Node(-25);
        Node three = new Node(3);
        Node four = new Node(4);

        // constructing binary tree
        ten.left = two;
        ten.right = fifteen;

        two.left = nFour;
        two.right = nSix;

        nFour.left = twentyEight;
        nFour.right = nTwentyTwo;

        fifteen.right = nTwentyFive;

        nTwentyFive.left = three;
        nTwentyFive.right = four;

        return ten;
    }
}
