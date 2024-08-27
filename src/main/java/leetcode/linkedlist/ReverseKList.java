package leetcode.linkedlist;

public class ReverseKList {

    static class Node {
        int data;
        Node next;
        Node(int key) {
            data = key;
            next = null;
        }
    }

    public static void main(String[] args) {
        Node head = constructList();
        int k =3;
        Node reversedHead = reverseKgroup(head,k);
        System.out.println("Printing reversed list K at a time");
        while (reversedHead != null){
            System.out.printf("%s -> ", reversedHead.data );
            reversedHead = reversedHead.next;
        }
        System.out.printf("null");
    }

    private static Node reverseKgroup(Node head, int k) {
        Node current = head;
        Node next = null;
        Node prev = null;

        int count = 0;

        while (count < k && current != null){
          next = current.next;
          current.next = prev;
          prev = current;
          current = next;
          count ++;
        }

        if(next != null)
            head.next = reverseKgroup(next,k);
        return prev;

    }

    private static Node constructList() {
        Node four = new Node(4);
        Node two = new Node(2);
        Node eight = new Node(8);
        Node five = new Node(5);
        Node one = new Node(1);
        Node six = new Node(6);
        Node three = new Node(3);
        Node seven = new Node(7);

        four.next = two;
        two.next = eight;
        eight.next = five;
        five.next = one;
        one.next = six;
        six.next = three;
        three.next = seven;

        return four;
    }
}
