package leetcode.binaryTree;

public class MaximumSumPath {

    private static int maxSum = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Node root = constructTree();
        findMaxSum(root, 0);
        System.out.println("Maximum sum ");
        System.out.print(maxSum);
    }

    private static void findMaxSum(Node node, int currSum) {
        if (node == null)
            return;

        currSum += node.value;
        if (currSum > maxSum)
            maxSum = currSum;

        findMaxSum(node.left, currSum);
        findMaxSum(node.right, currSum);

    }

    private static Node constructTree() {
        Node six = new Node(6);
        Node four = new Node(4);
        Node sixA = new Node(6);
        Node five = new Node(5);
        Node ten = new Node(10);
        Node eight = new Node(8);
        Node twelve = new Node(12);
        Node test = new Node(14);

        six.left = four;
        four.left = sixA;
        four.right = five;
        five.left = test;

        six.right = ten;
        ten.left = eight;
        ten.right = twelve;

        return six;
    }
}
