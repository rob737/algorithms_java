package leetcode.binaryTree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SpiralOrder {

    public static void main(String[] args) {

        Node root = constructTree();
        Stack<Node> leftToRight = new Stack<>();
        Stack<Node> rightToLeft = new Stack<>();
        Queue<Node> result = new LinkedList<>();

        leftToRight.push(root);

        while (!(leftToRight.isEmpty() && rightToLeft.isEmpty())) {

            Node curr;

            while (!leftToRight.isEmpty()) {
                curr = leftToRight.pop();
                result.add(curr);
                if (curr.right != null)
                    rightToLeft.push(curr.right);
                if (curr.left != null)
                    rightToLeft.push(curr.left);
            }

            while (!rightToLeft.isEmpty()) {
                curr = rightToLeft.pop();
                result.add(curr);

                if(curr.left != null)
                    leftToRight.push(curr.left);
                if(curr.right != null)
                    leftToRight.push(curr.right);
            }
        }

        System.out.println("Printing nodes in Spiral Order");
        Iterator itr = result.iterator();
        while (itr.hasNext()){
            System.out.print(" " + ((Node)itr.next()).value + " ");
        }
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
        Node fourteen = new Node(14);
        Node ten = new Node(10);
        Node sixteen = new Node(16);
        Node seventeen = new Node(17);

        one.left = two;
        one.right = three;

        two.left = four;
        two.right = five;

        three.left = six;
        three.right = seven;

        four.left = eight;
        four.right = fourteen;

        five.left = ten;
        six.right = sixteen;
        seven.left = seventeen;

        return one;
    }
}
