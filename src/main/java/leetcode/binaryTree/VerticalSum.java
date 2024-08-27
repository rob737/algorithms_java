package leetcode.binaryTree;

import java.util.LinkedHashMap;

public class VerticalSum {


    private static LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

    // used linkedhash map to maintain the insertion order.

    public static void main(String[] args) {

        Node root = constructBinaryTree();
        verticalSum(root, 0);
        System.out.println("Vertical sum is as follows");
        System.out.println(map);
    }

    private static void verticalSum(Node node, int dist) {
        if (node == null)
            return;

        verticalSum(node.left, dist - 1);
        if (null != map.get(dist)) {
            map.put(dist, node.value + map.get(dist));
        } else {
            map.put(dist, node.value);
        }
        verticalSum(node.right, dist + 1);


    }

    private static Node constructBinaryTree() {

        Node thirteen = new Node(13);
        Node ten = new Node(10);
        Node eight = new Node(8);
        Node twelve = new Node(12);
        Node eleven = new Node(11);
        Node eighteen = new Node(18);
        Node twenty = new Node(20);
        Node twentyTwo = new Node(22);
        Node fifteen = new Node(15);
        Node five = new Node(5);

        thirteen.left = ten;
        ten.left = eight;
        ten.right = twelve;

        twelve.left = eleven;
        thirteen.right = eighteen;
        eighteen.right = twenty;
        twenty.left = twentyTwo;

        eleven.left = fifteen;
        eighteen.left=five;

        return thirteen;
    }
}
