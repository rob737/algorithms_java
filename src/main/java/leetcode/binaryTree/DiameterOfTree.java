package leetcode.binaryTree;


class Node {
    Node left, right;
    int value;

    Node(int data) {
        value = data;
        left = right = null;
    }
}

public class DiameterOfTree {

    static int maxDiameter = 0;

    public static void main(String[] args) {
        Node root = constructTree();
        findDiameter(root, 0);
        System.out.println("Maximum Diameter : " + maxDiameter);
    }

    private static int findDiameter(Node root, int level) {
        if (root == null)
            return 0;

        int left = findDiameter(root.left, level + 1);
        int right = findDiameter(root.right, level + 1);

        int diameter = left + right + 1;

        if (maxDiameter < diameter)
            maxDiameter = diameter;

        return 1 + Math.max(left, right);

    }

    private static Node constructTree() {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);
        Node eight = new Node(8);
        Node nine = new Node(9);
        Node ten = new Node(10);
        Node eleven = new Node(11);
        Node twelve = new Node(12);
        Node thirteen = new Node(13);

        one.left = two;
        one.right = three;

        two.left = four;
        two.right = nine;
        four.left = five;
        //four.right = six;
        //six.left = seven;
        //seven.right = eight;
        nine.left = ten;
        ten.right = eleven;
        eleven.left = twelve;
       // three.right = thirteen;

        return one;
    }
}
