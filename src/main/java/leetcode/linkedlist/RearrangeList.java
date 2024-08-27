package leetcode.linkedlist;

public class RearrangeList {
    static class Node {
        int data;
        Node next;

        Node(int key) {
            data = key;
            next = null;
        }
    }

    private static Node temp, curr;

    public static void main(String[] args) {
        Node head = constructList();
        curr = head;
        Node mid = findMid(head);
        rearrangeList(mid);
        curr.next = null;
        print(head);
    }

    private static void print(Node head) {
        System.out.println("Printing rearranged list");
        while (head != null) {
            System.out.printf("%s -> ", head.data);
            head = head.next;
        }
        System.out.println("null");
    }

    private static Node findMid(Node head) {
        Node fast = head, slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private static void rearrangeList(Node node) {
        if (node == null)
            return;
        rearrangeList(node.next);
        temp = curr;
        curr = curr.next;
        temp.next = node;
        node.next = curr;
    }

    private static Node constructList() {
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

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        /*six.next = seven;
        seven.next = eight;
        eight.next = nine;
        nine.next = ten;*/

        return one;
    }
}
